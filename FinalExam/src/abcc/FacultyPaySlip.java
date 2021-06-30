package abcc;

public class FacultyPaySlip extends EmployeePaySlip
{
    protected char qualificationCode;

    //getters and setters


    public char getQualificationCode() {
        return qualificationCode;
    }

    public void setQualificationCode(char qualificationCode) {
        this.qualificationCode = qualificationCode;
    }

    //constructor methods
    public FacultyPaySlip()
    {

    }

    public FacultyPaySlip(char qualificationCode)
    {
        this.qualificationCode = qualificationCode;
    }

    public FacultyPaySlip(Employee emp, double hoursWorked, char qualificationCode) {
        super(emp, hoursWorked);
        this.qualificationCode = qualificationCode;
    }

    @Override
    public double calcGrossSalary()
    {
        double grossPay = 0;
        if(this.getQualificationCode() == 'M' || this.getQualificationCode() == 'm')
        {
            final double hourlyRate = 175.00;
            final double allowance = 1500.00;
            grossPay = (hourlyRate * this.getHoursWorked()) + allowance;
        }
        else if(this.getQualificationCode() == 'B' || this.getQualificationCode() == 'b')
        {
            final double hourlyRate = 100.00;
            final double allowance = 600.00;
            grossPay = (hourlyRate * this.getHoursWorked()) + allowance;
        }
        return grossPay;

    }

    public String toString()
    {
        return ("\n\n" + emp.toString() + "\nGross Salary: " + calcGrossSalary() + ". \nDeductions: "
                + calcDeductions() + "\nNet Pay: " + calcNetSalary() + ".\n");
    }
}
