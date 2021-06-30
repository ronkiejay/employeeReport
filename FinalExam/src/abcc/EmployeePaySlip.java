package abcc;

public abstract class EmployeePaySlip
{
    protected Employee emp;
    protected double hoursWorked;

    //constructor methods
    public EmployeePaySlip()
    {

    }

    public EmployeePaySlip(Employee emp, double hoursWorked) {
        this.emp = emp;
        this.hoursWorked = hoursWorked;
    }

    //getters and setters
    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }


    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }


    //calculating health surcharge fee
    public double calcHealthSurge()
    {
        double healthSurcharge;
        if(calcGrossSalary() > 3000)
        {
            healthSurcharge = 33;
        }
        else
        {
            healthSurcharge = 19.20;
        }
        return healthSurcharge;
    }

    //calculating deductions
    public  double calcDeductions()
    {
        double deductions = 0;
        final double canadaTax = 0.25;
        if(calcGrossSalary() < 2500)
        {
            deductions = 0;
        }
        else
        {
            double healthCharge = calcHealthSurge();
            deductions = (canadaTax * calcGrossSalary()) + healthCharge;
        }

        return deductions;
    }

    //calculating net salary
    public double calcNetSalary()
    {
        double netSalary = calcGrossSalary() - calcDeductions();
        return netSalary;
    }

    //abstract methods
    public abstract double calcGrossSalary();

    public abstract String toString();



}
