import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;
import javax.swing.UIManager.*;

public class ManagerGUI extends JFrame implements ActionListener {

    private static JLabel greetingLabel;
    private static JLabel statusLabel;
    private static JButton userButton;
    private static JButton productButton;
    private static JButton orderButton;
    private static String errorMessage;

    public ManagerGUI() {

        Connection myConn;

        try {
            myConn = DriverManager.getConnection(database.url,database.user,database.password);

            Statement stmt = myConn.createStatement();
            String query = "SELECT * FROM our_company.Users where User_ID="+LoginPage.user;
            ResultSet rs = stmt.executeQuery(query);
            rs.next();

            String sql = "update our_company.Users set "
                    + "last_login_date='" + java.time.LocalDate.now() + "'"
                    + " where User_ID=" + LoginPage.user;

            PreparedStatement p = myConn.prepareStatement(sql);
            p.execute();

        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting MySQL databse");
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        /* general frame settings */
        this.setTitle("Inventory Management");
        this.setSize(400, 350); //set dimension
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        /* greeting label */
        JLabel greetingLabel = new JLabel("Hello " + database.returnVal("users", "user_id", LoginPage.user, "first_name") + " " + database.returnVal("users", "user_id", LoginPage.user, "last_name") + " [Employee ID: " + LoginPage.user + "]", JLabel.LEFT);
        greetingLabel.setBounds(20, 20, 300, 25);
        this.add(greetingLabel);

        /* status label */
        JLabel statusLabel = new JLabel ("Role: " + LoginPage.access, JLabel.LEFT);
        statusLabel.setBounds(20, 45, 300, 25);
        this.add(statusLabel);

        /* user button */
        userButton = new JButton("Manage Users");
        userButton.setBounds(140, 100, 120, 40);
        userButton.addActionListener(this);
        userButton.setFocusPainted(false);
        this.add(userButton);

        /* product button */
        productButton = new JButton("Manage Products");
        productButton.setBounds(140, 160, 120, 40);
        productButton.addActionListener(this);
        productButton.setFocusPainted(false);
        this.add(productButton);

        /* order button */
        orderButton = new JButton("Manage Orders");
        orderButton.setBounds(140, 220, 120, 40);
        orderButton.addActionListener(this);
        orderButton.setFocusPainted(false);
        this.add(orderButton);

        this.setVisible(true);//make panel visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == userButton) {
            if (LoginPage.access.equals("Manager")) {
                this.dispose();
                User user = new User();
            } else {
                errorMessage = "You do not have access to this function!";
                JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
            }


        }

        if (e.getSource() == orderButton) {
            this.dispose();
            Order order = new Order();
        }

    }

}
