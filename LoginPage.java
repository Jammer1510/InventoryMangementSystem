import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager.*;

public class LoginPage extends JFrame implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton logButton;
    private static String errorMessage;
    public static String user;
    private static String pass;
    public static String access;

    public LoginPage() {

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
        this.setSize(380, 400); //set dimension
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        /* username label */
        JLabel userLabel = new JLabel("Username:", JLabel.CENTER);
        userLabel.setBounds(50, 115, 80, 20);
        this.add(userLabel);
        /* username fill-in */
        userText = new JTextField();
        userText.setBounds(120, 115, 165, 20);
        this.add(userText);

        /* password label */
        JLabel passwordLabel = new JLabel("Password:", JLabel.CENTER);
        passwordLabel.setBounds(50, 160, 80, 20);
        this.add(passwordLabel);
        /* password fill-in */
        passwordText = new JPasswordField();
        passwordText.setBounds(120, 160, 165, 20);
        this.add(passwordText);

        /* log-in button */
        logButton = new JButton("Login");
        logButton.setBounds(215, 200, 80, 25);
        logButton.addActionListener(this);
        logButton.setFocusPainted(false);
        this.add(logButton);

        this.setVisible(true);//make panel visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        user = userText.getText();
        pass = String.valueOf(passwordText.getPassword());

        boolean passSpaceCheck = false;
        boolean intCheck = true;

        for(int i = 0; i < pass.length(); i++){
            if(Character.isWhitespace(pass.charAt(i))){
                passSpaceCheck = true;
            }
        }

        try {
            Integer.parseInt(user);
        } catch (NumberFormatException ex) {
            intCheck = false;
        }

        if (e.getSource() == logButton) {

            if (user == null || user.isEmpty()) {
                errorMessage = "Username cannot be empty!";
                JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (pass == null || pass.isEmpty()) {
                errorMessage = "Password cannot be empty!";
                JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (intCheck == false) {
                errorMessage = "Username must be an integer!";
                JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
                intCheck = true;
            } else if (passSpaceCheck == true) {
                errorMessage = "Password cannot contain a space!";
                JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
                passSpaceCheck = false;
            }
            else {
                for (int i = 0; i < 1000; i++) {
                    if (database.strUser[i] == null) {
                        errorMessage = "Invalid login credentials!";
                        JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if (user.equals(database.strUser[i]) && pass.equals(database.strPass[i])) {
                        this.dispose();
                        if (database.strAccess[i].equals("1"))
                            access = "Manager";
                        else if (database.strAccess[i].equals("2"))
                            access = "Employee";
                        ManagerGUI manager = new ManagerGUI();
                        break;
                    }
                }
            } //checks for combination of username and pw
        }

    }


}
