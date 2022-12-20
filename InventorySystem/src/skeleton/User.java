package skeleton;

public class User
{
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private int lastLogin;
    private int access;
    
    public User(int id, String firstName, String lastName, String emailAddress, String password, int lastLogin, int access)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.lastLogin = lastLogin;
        this.access = access;
    }
    
    public void setID(int id)
    {
        this.id = id;
    }
    
    public int getID()
    {
        return id;
    }
    
    public void setName(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getName()
    {
        String name = firstName + lastName;
        return name;
    }
    
    public void setEmail(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }
    public String getEmail()
    {
        return emailAddress;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public void setLastLogin(int lastLogin)
    {
        this.lastLogin = lastLogin;
    }
    public int getLastLogin()
    {
        return lastLogin;
    }
    
    public void setAccess(int access)
    {
        this.access = access;
    }
    public int getAccess()
    {
        return access;
    }
}