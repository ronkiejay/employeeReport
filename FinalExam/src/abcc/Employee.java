package abcc;

public class Employee
{
    private int employeeID;
    private String firstName;
    private String lastName;
    private char employeeType;

    //constructor methods
    public Employee()
    {

    }

    public Employee(int employeeID, String firstName, String lastName, char employeeType)
    {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeType = employeeType;
    }

    // getters and setters


    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(char employeeType)
    {
        this.employeeType = employeeType;
    }

    public String empFullName()
    {
        return this.getFirstName() + " " + this.getLastName();
    }

    @Override
    public String toString() {
        return ("EmployeeId: " + this.getEmployeeID() + "\nEmployee Full Name: " + empFullName() + " \nEmployee Type: " + this.getEmployeeType());
    }
}
