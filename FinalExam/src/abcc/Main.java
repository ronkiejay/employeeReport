package abcc;

import java.util.*;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

    public static void main(String[] args)
    {
	    Scanner input = new Scanner(System.in);

	    //creating an arraylist to hold multiple employees
        Employee emp[] = new Employee[500];
        int processedEmployees = 0;
        int processedFaculty = 0;
        int processedNonFac = 0;
        char response;
        int i = 0;

        System.out.println("Please enter the month this report is for");
        String month = input.next();

        try
        {
            FileWriter existfile = new FileWriter("slipReports.txt", true);
            BufferedWriter report = new BufferedWriter(existfile);
            report.write("Employee Slip Report for the Month of " + month);

            report.newLine();
            report.close();

        }
        catch (IOException ex)
        {
            System.out.println("Error : " + ex.getMessage());
        }

        do {
            System.out.println("Do you want to enter new Employee: Y/N");
            response = input.next().charAt(0);

            if(response == 'Y' || response == 'y')
            {
                System.out.println("Employee " + (i+1));
                System.out.println("Please enter employee's first name:");
                String first = input.next();
                System.out.println("Please enter employee's last name:");
                String last = input.next();
                System.out.println("Please enter employee's ID:");
                int empId = input.nextInt();
                System.out.println("Please enter employee's type:");
                char type = input.next().charAt(0);

                emp[i] = new Employee(empId, first, last, type);


                if(emp[i].getEmployeeType() == 'N' || emp[i].getEmployeeType() == 'n')
                {
                    System.out.println("Please enter employee's monthly Salary:");
                    double monthlySalary = input.nextDouble();
                    System.out.println("How many hours is worked by this employee? ");
                    double hours = input.nextDouble();

                    NonFacultyPaySlip nonFac = new NonFacultyPaySlip(emp[i], hours, monthlySalary);
                    //System.out.println(nonFac.toString());
                    try
                    {
                            FileWriter existfile = new FileWriter("slipReports.txt", true);
                            BufferedWriter report = new BufferedWriter(existfile);
                            report.append(nonFac.toString());

                            report.newLine();
                            report.close();

                    }
                    catch (IOException ex)
                    {
                        System.out.println("Error : " + ex.getMessage());
                    }
                    processedNonFac += 1;
                }
                else if(emp[i].getEmployeeType() == 'F' || emp[i].getEmployeeType() == 'f')
                {
                    System.out.println("Please enter employee's qualification code:");
                    char code = input.next().charAt(0);
                    System.out.println("How many hours is worked by this employee? ");
                    double hours = input.nextDouble();

                    FacultyPaySlip fac = new FacultyPaySlip(emp[i], hours, code);
                    //System.out.println(fac.toString());
                    try
                    {
                        FileWriter newfile = new FileWriter("slipReports.txt", true);
                        BufferedWriter report = new BufferedWriter(newfile);
                        report.append(fac.toString());
                        report.newLine();
                        report.close();
                    }
                    catch (IOException ex)
                    {
                        System.out.println("Error : " + ex.getMessage());
                    }
                    processedFaculty += 1;
                }
                i++;
                processedEmployees += 1;
            }
            else if(response == 'N' || response == 'n')
            {
                try {
                    FileWriter file = new FileWriter("slipReports.txt", true);
                    BufferedWriter report = new BufferedWriter(file);
                    report.append("\nTotal Number of processed employees: " + processedEmployees);
                    report.append("\nTotal number of processed faculty employees " + processedFaculty);
                    report.append("\nTotal number of processed non faculty employees " + processedNonFac);

                    report.close();

                } catch (IOException ex) {
                    System.out.println("\nError : " + ex.getMessage());
                }
                System.exit(0);
            }
            else
                System.out.println("Invalid input! Please enter a Y/N");

        }while(response != 'N' || response != 'n');


    }
}
