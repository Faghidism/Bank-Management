package af.faghid;

/*
kelas bank
esm , type tedad karmand va moshtari
getter setter va constructor inha
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bank {
    public String bankName;
    public String bankType;
    public int customerNumber;
    public int employeeNumber;
    public int jobNumber;
    public String[] customerArray = new String[customerNumber];
    public String[] employeeArray = new String[employeeNumber];
    public String[] completeJob = new String[jobNumber];
    public String[] jobArray = new String[jobNumber];

    public void setBankName(String bankname) {

        bankName = bankname;

    }

    public String getBankName() {

        return bankName;
    }

    public void setBankType(String banktype) {
        bankType = banktype;
    }

    public String getBankType() {
        return bankType;
    }

    public void setCustomerArray() throws FileNotFoundException {
        setCustomerNumber();
        File myObject = new File("Documents/CustomersName.txt");
        Scanner scanner = new Scanner(myObject);
        int i = 0;
        while (scanner.hasNextLine()) {
            customerArray[i] = scanner.nextLine();
            i++;

        }
    }

    private void setCustomerNumber() throws FileNotFoundException{
        customerNumber = countingCustomersNumber();
        customerArray = new String[customerNumber];
    }

    private int countingCustomersNumber() throws FileNotFoundException{
        int customersNumber = 0;
        File myObject = new File("Documents/CustomersName.txt");
        Scanner scanner = new Scanner(myObject);
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            customersNumber++;
        }

        return customersNumber;
    }

    public void setEmployeeArray() {

    }

    public void setJobArray() throws FileNotFoundException{
        setJobNumber();
        File myObject = new File("Documents/JobsName.txt");
        Scanner scanner = new Scanner(myObject);
        int i = 0;
        while (scanner.hasNextLine()) {
            jobArray[i] = scanner.nextLine();

            i++;
        }
    }

    private void setJobNumber() throws FileNotFoundException{
        jobNumber = countingJobsNumber();
        jobArray = new String[jobNumber];
        completeJob = new String[jobNumber];
    }

    private int countingJobsNumber() throws FileNotFoundException {
        int jobNumber = 0;
        File myObject = new File("Documents/JobsName.txt");
        Scanner scanner = new Scanner(myObject);

        while (scanner.hasNextLine()) {
            scanner.nextLine();
            jobNumber++;
        }
        return jobNumber;
    }
}
