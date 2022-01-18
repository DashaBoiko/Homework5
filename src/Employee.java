public class Employee  extends User {
    private int employeeRank;


    public Employee(String firstName, String lastName, String login,
                    String password, int employeeRank)
    {
        super(firstName, lastName, login, password);
        this.employeeRank = employeeRank;

    }


    public int getEmployeeRank()
    {
        return employeeRank;
    }


    public void setEmployeeRank(int employeeRank) {
        this.employeeRank = employeeRank;
    }


    public String toString()
    {

        String str = super.toString();
        str+= "Employee Rank: ";
        if(employeeRank==1)str+= "ordinary employee\n";
        else if(employeeRank==2)str+="manager\n";
        else str+="member of the management team\n";

        return str;
    }


    public int getType()
    {
        return 1;
    }
}

