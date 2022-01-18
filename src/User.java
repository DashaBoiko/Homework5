public class User {
    protected String firstName;
    protected String lastName;
    protected String login;
    protected String password;

    public User (String firstName, String lastName, String login, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }



    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return lastName;
    }



    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getLogin()
    {
        return login;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }



    public String toString()
    {

        String str = "First name: " + firstName;
        str+= "\nLast name: " + lastName;
        str+= "\nLogin: " + login;
        str+= "\nPassword: " + password+"\n";

        return str;
    }

    public int getType()
    {
        return 0;
    }

}

