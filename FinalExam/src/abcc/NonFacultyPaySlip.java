package abcc;

public class NonFacultyPaySlip extends EmployeePaySlip
{

    protected double monthlySalary;

    //getters and setters method


    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    //constructor methods
    public NonFacultyPaySlip()
    {

    }

    public NonFacultyPaySlip(Employee emp, double hoursWorked, double monthlySalary)
    {
        super(emp, hoursWorked);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calcGrossSalary()
    {
        double grossPay = 0;
        //double fullSalary = 0;
        double addedHours = 0;
        double addedSalary;
        final double fullHours = 160;
        final double hourlyRate = this.getMonthlySalary() / 160;
        if(this.getHoursWorked() == 160)
        {
            grossPay = this.getMonthlySalary();
        }
        else if(this.getHoursWorked() < fullHours)
        {
            grossPay = hourlyRate * this.getHoursWorked();
        }
        else if(this.getHoursWorked() > 160)
        {
            addedHours = this.getHoursWorked() - fullHours;
            addedSalary = 2 * hourlyRate * addedHours;
            grossPay = this.getMonthlySalary() + addedSalary;
        }
        return grossPay;
    }

//    public String toString()
//    {
//        return (emp.toString() + ". \nGross Salary: " + calcGrossSalary());
//    }

    public String toString()
    {
        return ("\n\n" + emp.toString() + "\nGross Salary: " + calcGrossSalary() + ". \nDeductions: "
                + calcDeductions() + "\nNet Pay: " + calcNetSalary() + ".\n");
    }

}
