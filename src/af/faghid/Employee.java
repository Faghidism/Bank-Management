package af.faghid;

/* kelad karmand
method haye menu karmad sakhte shode
farakhani mishan
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Employee {
    public String[] employeeNameArray;
    public String employeeName;
    public Bank bank = new Bank();


    public void setEmployeeName() throws FileNotFoundException {
        employeeNameArray = new String[employeesNumber()];

        File file = new File("Documents/EmployeesName.txt");
        Scanner scanner = new Scanner(file);
        int i = 0;
        while (scanner.hasNextLine()) {
            employeeNameArray[i] = scanner.nextLine();
            i++;

        }

    }

    private int employeesNumber() throws FileNotFoundException {
        int employeeNumber = 0;
        File file = new File("Documents/EmployeesName.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            scanner.nextLine();
            employeeNumber++;

        }
        return employeeNumber;
    }

    public void employeeInformation() throws IOException {
        if (employeeInformationIsAvilable(getOnlineEmployeeName()))
            showEmployeeInformations();
        else importEmployeeInformations();
    } // option "2" in Employee List

    private boolean employeeInformationIsAvilable(String employee) throws FileNotFoundException {
        boolean avilable = false;

        File file = new File("Documents/EmployeesInformations.txt");
        Scanner scanner = new Scanner(file);
        int numberSingIndex = 0;
        String data;

        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            if (data != null)
                numberSingIndex = data.indexOf("#");
            if (data.substring(0, numberSingIndex).equals(employee))
                avilable = true;
        }

        return avilable;
    }
    private void setOnlineEmployeeName() throws FileNotFoundException {
        File file = new File("Documents/OnlineCustomer.txt");
        Scanner scanner = new Scanner(file);
        employeeName = scanner.nextLine();
    }
    private String getOnlineEmployeeName() throws FileNotFoundException {
        setOnlineEmployeeName();
        return employeeName;
    }



    private void showEmployeeInformations() throws FileNotFoundException {
        File file = new File("Documents/EmployeesInformations.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            int numberSignIndex = data.indexOf("#");
            int starSignIndex = data.indexOf("*");
            if (data.substring(0, numberSignIndex).equals(getOnlineEmployeeName())) {
                System.out.println("Name : " + getOnlineEmployeeName());
                System.out.println("identification number : " + data.substring(numberSignIndex + 1, starSignIndex));
                System.out.println("Age : " + data.substring(starSignIndex + 1, data.length()));
            }
        }

    }

    private void importEmployeeInformations() throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter writer = new FileWriter("Documents/EmployeesInformations.txt", true);

        System.out.println("Please Enter Your identification number :");
        String number = scanner.nextLine();
        writer.write(getOnlineEmployeeName() + "#" + number);
        System.out.println("Please Enter Your Age :");
        String age = scanner.nextLine();
        writer.write("*" + age + "\n");
        writer.close();
        System.out.println("| Your Information Saved successfully |");

    }

    public void decreaseCustomerLoan() {

    }

    public void transferMoney() {
    }

    public void paiedCustomerLoan() {
    }

    public void startAnAccount() {
    }

    public void banAnAccount() {
    }

    public void searchCustomer() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        searchCustomerOptions();
        boolean trueInput = false;
        while (!trueInput) {
            String select = scanner.nextLine();
            if (select.equals("1")) {
                searchByName();
                trueInput = true;
            }
            if (select.equals("2")) {
                searchById();
                trueInput = true;
            }
            if (!trueInput) System.out.println("Wrong Input !");
        }
    }

    private void searchById() throws FileNotFoundException {
        Customer customer = new Customer();
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Customer ID :\n");
        String customerId = input.nextLine();

        File file = new File("Documents/CustomerId.txt");
        Scanner scanner = new Scanner(file);
        String data = "";
        boolean findCustomer = false;
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            if (data != null) {
                if (data.substring(data.indexOf("#") + 1, data.length()).equals(customerId)) {
                    if (customer.customerNameIsAvilable(data.substring(0, data.indexOf("#") - 1))) {
                        findCustomer = true;
                        break;

                    }
                }
            }
        }
        if (findCustomer) {
            System.out.println("The Customer ID is Available And he/she name is : " + data.substring(0, data.indexOf("#")));
        } else System.out.println("The Customer Name is UnAvailable !");
    }

    private void searchByName() throws FileNotFoundException {
        Customer customer = new Customer();
        bank.setCustomerArray();
        boolean findCustomer = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Customer Name :\n");
        String studentName = scanner.nextLine();

        for (int i = 0; i < bank.customerArray.length; i++) {
            if (studentName.equals(bank.customerArray[i])) {
                findCustomer = true;
                break;
            }
        }
        if (findCustomer) {
            System.out.println("The Customers Is Available ! :D");
        } else System.out.println("The Customers Is Unavailable !");

    }

    private void searchCustomerOptions() {
        System.out.println("1. Search By Name");
        System.out.println("2. Search By ID");
    }

    public String findEmployeeJob(String employeeName) throws FileNotFoundException {
        String jobName = "";
        File file = new File("Documents/CompleteJob.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            if (data != null) {
                if (data.contains(employeeName)) {
                    jobName = data.substring(0, data.indexOf("#"));
                    break;
                }
            }
        }
        return jobName;

    }

    public boolean employeeNameIsAvailable(String employeeName) {
        bank.setEmployeeArray();
        boolean findEmployee = false;
        for (int i = 0; i < bank.employeeArray.length; i++)
            if (bank.employeeArray[i].equalsIgnoreCase(employeeName)) {
                findEmployee = true;
                break;
            }
        return findEmployee;
    }
}
