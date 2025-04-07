package af.faghid;

/*
method haye menu modir sakhte shode
farakhani mishan
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Manager {
    public String managerName;
    public Bank bank = new Bank();
    public Employee employee = new Employee();
    public int bankIncome;

    public void addNewCustomer() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Customer Name :");
        String customerName = scanner.nextLine();
        writeCustomersName(customerName);
        Bank bank = new Bank();
        bank.setCustomerArray();
    }

    public void writeCustomersName(String customerName) throws IOException {
        FileWriter writer = new FileWriter("Documents/CustomersName.txt", true);
        writer.write(customerName + "\n");
        writer.close();

    }
    public void addNewEmployee() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Employee Name :");
        String employeeName = scanner.nextLine();
        writeEmployeesName(employeeName);
        Bank bank = new Bank();
        bank.setEmployeeArray();
    }

    private void writeEmployeesName(String employeeName) throws IOException {
        FileWriter writer = new FileWriter("Documents/EmployeesName.txt", true);
        writer.write(employeeName + "\n");
        writer.close();
    }

    public void removeCustomer() throws IOException {
        User user = new User();
        boolean findCustomer = false;
        bank.setCustomerArray();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Customer Name :\n");
        String customerName = scanner.nextLine();
        for (int i = 0; i < bank.customerArray.length; i++) {
            if (bank.customerArray[i].equals(customerName)) {
                findCustomer = true;
                bank.customerArray[i] = "";
                deleteCustomerFile();
                updateCustomerFile();
                System.out.println("The customer in question has been removed");
            }
        }
        if (!findCustomer) System.out.println("The customer Name Not Available !");
    }// option 3 in manager List

    private void updateCustomerFile() throws IOException{
        FileWriter writer = new FileWriter("Documents/CustomersName.txt");
        writer.write("");
        writer.close();

    }

    private void deleteCustomerFile() throws IOException{
        FileWriter writer = new FileWriter("Documents/CustomersName.txt", true);
        for (int i = 0; i < bank.customerArray.length; i++)
            writer.write(bank.customerArray[i] + "\n");
        writer.close();
    }

    public void removeEmployee() throws IOException {
        User user = new User();
        boolean findEmployee = false;
        bank.setEmployeeArray();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Employee Name :\n");
        String employeeName = scanner.nextLine();
        for (int i = 0; i < bank.employeeArray.length; i++) {
            if (bank.employeeArray[i].equals(employeeName)) {
                findEmployee = true;
                bank.employeeArray[i] = "";
                deleteEmployeeFile();
                updateEmployeeFile();
                System.out.println("The employee in question has been removed");
            }
        }
        if (!findEmployee) System.out.println("The Employee Name Not Avialable !");
    }

    private void updateEmployeeFile() throws IOException{
        FileWriter writer = new FileWriter("Documents/EmployeesName.txt");
        writer.write("");
        writer.close();

    }

    private void deleteEmployeeFile() throws IOException{
        FileWriter writer = new FileWriter("Documents/EmployeesName.txt", true);
        for (int i = 0; i < bank.employeeArray.length; i++)
            writer.write(bank.employeeArray[i] + "\n");
        writer.close();
    }

    public void showCustomer() {
        
    }

    public void showEmployeesProfile() {
    }

    public void chooseEmployeesJob() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter The Employee Name :\n");
        String employeeName = scanner.nextLine();
        bank.setEmployeeArray();
        if (findEmployeeName(employeeName)) {
            System.out.println("Enter the name of the job you want the employee to enter :\n");
            String jobName = scanner.nextLine();
            Job aJob = new Job();
            aJob.jobAndEmployee(jobName, employeeName);
            if (!jobIsExist(jobName)) {
                writeJobNames(jobName);
                bank.setJobArray();
                setCompleteJob();

                bank.completeJob[bank.jobNumber - 1] = jobName + "#| " + employeeName + " | ";
                writeCompleteJob();


            } else {
                bank.setJobArray();
                setCompleteJob();
                if (!(bank.completeJob[searchJobNumber(jobName)].contains(jobName + "#| ")))
                    bank.completeJob[searchJobNumber(jobName)] += jobName + "#| " + employeeName + " | ";
                else bank.completeJob[searchJobNumber(jobName)] += employeeName + " | ";
                writeCompleteJob();

            }


        } else System.out.println("The employee not found !");
    }

    private int searchJobNumber(String sideName) {
        int sideNumber = 0;
        for (int i = 0; i < bank.jobNumber; i++) {
            if (sideName.equalsIgnoreCase(bank.jobArray[i])) {
                sideNumber = i;
                break;
            }
        }

        return sideNumber;
    }

    private void writeJobNames(String jobName) throws IOException {
        FileWriter writer = new FileWriter("Documents/JobsName.txt", true);
        writer.write(jobName + "\n");
        writer.close();
    }

    private boolean jobIsExist(String sideName) throws FileNotFoundException{
        boolean find = false;
        String data;
        File myObject = new File("Documents/JobsName.txt");
        Scanner scanner = new Scanner(myObject);
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            if (data.equalsIgnoreCase(sideName)) {
                find = true;
                break;
            }
        }
        return find;
    }

    private void setCompleteJob() throws FileNotFoundException{
        File myObject = new File("Documents/CompleteJob.txt");

        Scanner scanner = new Scanner(myObject);
        int i = 0;
        while (scanner.hasNextLine()) {
            bank.completeJob[i] = scanner.nextLine();
            i++;

        }
    }

    private boolean findEmployeeName(String employeeName) {
        boolean findEmployee = false;
        for (int i = 0; i < bank.employeeArray.length; i++)
            if (bank.employeeArray[i].equalsIgnoreCase(employeeName)) {
                findEmployee = true;
                break;
            }

        return findEmployee;
    }

    private void writeCompleteJob() throws FileNotFoundException{
        File myObject = new File("Documents/CompleteJob.txt");

        Scanner scanner = new Scanner(myObject);
        int i = 0;
        while (scanner.hasNextLine()) {
            bank.completeJob[i] = scanner.nextLine();
            i++;

        }
    }

    public void ShowBankIncome() throws FileNotFoundException {
        File file = new File("Documents/BankIncome.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            if (data != null) {
                int numberSignIndex = data.indexOf("#");
                bankIncome += Integer.valueOf(data.substring(numberSignIndex + 1, data.length()));
            }
        }
        System.out.println(bankIncome + "$");

    }

    public void ShowBankExpense() throws  FileNotFoundException{
        File file = new File("Documents/EmployeeIncome.txt");
        Scanner scanner = new Scanner(file);
        int Expenses = 0;
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();

            int numberSignIndex;
            if (data != null) {
                numberSignIndex = data.indexOf("#");
                Expenses += Integer.valueOf(data.substring(numberSignIndex + 1, data.length()));
            }


        }
        System.out.println(Expenses + "$");
    }

    public void ShowLoanprofile() throws  FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter The Customer Name :\n");
        String customerName = scanner.nextLine();
        findPayementsMade(customerName);
    }
    public void findPayementsMade(String customerName) throws FileNotFoundException {
        int i = 1;
        int total = 0;
        File file = new File("Documents/CustomersTuition.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            int numberSignIndex;

            if (data != null) {

                numberSignIndex = data.indexOf("#");
                if (data.contains(customerName)) {
                    System.out.println(i + " :" + data.substring(numberSignIndex + 1, data.length()) + "$");
                    total += Integer.valueOf(data.substring(numberSignIndex + 1, data.length()));
                    i++;
                }

            }
        }
        System.out.println("\n\nAnnual tuition fee : " + 10000);
        System.out.println("The total amount paid : " + total + "$");
        System.out.println("Remaining tuition : " + (10000 - total) + "$");
    }
    public void CountOfAccount() {
    }

    public void PayEmployeeSalaries() throws IOException {
        employee.setEmployeeName();
        boolean findEmployee = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Employee Name :\n");
        String employeeName = scanner.nextLine();
        for (int i = 0; i < employee.employeeNameArray.length; i++) {
            if (employeeName.equals(employee.employeeNameArray[i])) {
                findEmployee = true;
                System.out.println("Enter the amount you want to pay :\n");
                String money = scanner.nextLine();
                if (findEmployeeIncome(employeeName) + Integer.valueOf(money) <= 3000) {
                    writeEmployeeSalaries(employeeName, money);
                    System.out.println("|  Done :D  |");
                } else System.out.println("The amount of input is more than the rest of the employee's salary !");
            }
        }
        if (!findEmployee)
            System.out.println("The Employee Name Not Found !");

    }

    private Integer findEmployeeIncome(String employeeName) throws FileNotFoundException {
        File file = new File("Documents/EmployeeIncome.txt");
        int income = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            if (data != null) {

                if (data.contains(employeeName))
                    income += Integer.valueOf(data.substring(data.indexOf("#") + 1, data.length()));
            }
        }
        return income;
    }

    private void writeEmployeeSalaries(String employeeName, String employeeMoney) throws IOException {
        FileWriter writer = new FileWriter("Documents/EmployeeIncome.txt", true);
        writer.write(employeeName + "#" + employeeMoney + "\n");
        writer.close();
    }

    public void DepositingMoneyAndPayingCustomer() {

    }

    public void OpenOrBanAccount() {
    }

    public void ShowPropertyOfBank() throws FileNotFoundException {
        String bankName = "", bankType = "";

        File myobject = new File("Documents/Property.txt");
        Scanner scanner = new Scanner(myobject);
        int i = 0;
        while (scanner.hasNextLine()) {
            if (i == 0) {
                bankName = scanner.nextLine();
                i++;
            }
            if (i == 1) {
                bankType = scanner.nextLine();
            }

        }
        System.out.println("-- School Name : " + bankName + " --");
        System.out.println("-- School Type : " + bankType + " --");
    }

    public void SearchEmployee() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        searchEmployeeOptions();
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
            Employee employee = new Employee();
            Scanner input = new Scanner(System.in);
            System.out.println("Please Enter Employee ID :\n");
            String employeeId = input.nextLine();

            File file = new File("Documents/EmployeeId.txt");
            Scanner scanner = new Scanner(file);
            String data = "";
            boolean findEmployee = false;
            while (scanner.hasNextLine()) {
                data = scanner.nextLine();
                if (data != null) {
                    if (data.substring(data.indexOf("#") + 1, data.length()).equals(employeeId)) {
                        if (employee.employeeNameIsAvailable(data.substring(0, data.indexOf("#") - 1))) {
                            findEmployee = true;
                            break;

                        }
                    }
                }
            }
            if (findEmployee) {
                System.out.println("The Employee ID is Available And he/she name is : " + data.substring(0, data.indexOf("#")));
                System.out.println("And He/She Job Name is : "+employee.findEmployeeJob(data.substring(0, data.indexOf("#")-1)));
            } else System.out.println("The Employee Name is UnAvailable !");

    }

    private void searchByName() throws FileNotFoundException {
        Employee employee = new Employee();
        bank.setEmployeeArray();
        boolean findEmployee = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Employee Name :\n");
        String employeeName = scanner.nextLine();

        for (int i = 0; i < bank.employeeArray.length; i++) {
            if (employeeName.equals(bank.employeeArray[i])) {
                findEmployee = true;
                break;
            }
        }
        if (findEmployee) {
            System.out.println("The Employees Is Available ! :D");
            System.out.println("The Employee Job Name is : " + employee.findEmployeeJob(employeeName));
        } else System.out.println("The Employees Is Unavailable !");

    }

    private void searchEmployeeOptions() {
        System.out.println("1. Search By Name");
        System.out.println("2. Search By ID");
    }

    public void SearchCustomer() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        searchCustomerOptions();
        boolean trueInput = false;
        while (!trueInput) {
            String select = scanner.nextLine();
            if (select.equals("1")) {
                searchBYName();
                trueInput = true;
            }
            if (select.equals("2")) {
                searchByID();
                trueInput = true;
            }
            if (!trueInput) System.out.println("Wrong Input !");
        }
    }

    private void searchByID() throws FileNotFoundException {
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
                    if (customer.customerNameIsAvailable(data.substring(0, data.indexOf("#") - 1))) {
                        findCustomer = true;
                        break;

                    }
                }
            }
        }
        if (findCustomer) {
            System.out.println("The Customer ID is Available And he/she name is : " + data.substring(0, data.indexOf("#")));
            System.out.println("And He/She Account id is : "+customer.findCustomerAccount(data.substring(0, data.indexOf("#")-1)));
        } else System.out.println("The Customer Name is UnAvailable !");

    }

    private void searchBYName() throws FileNotFoundException {
        Customer customer = new Customer();
        bank.setCustomerArray();
        boolean findCustomer = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Customer Name :\n");
        String customerName = scanner.nextLine();

        for (int i = 0; i < bank.customerArray.length; i++) {
            if (customerName.equals(bank.customerArray[i])) {
                findCustomer = true;
                break;
            }
        }
        if (findCustomer) {
            System.out.println("The Customer Is Available ! :D");
            System.out.println("The Customer Account Id is : " + customer.findCustomerAccount(customerName));
        } else System.out.println("The Customer Is Unavailable !");

    }

    private void searchCustomerOptions() {
        System.out.println("1. Search By Name");
        System.out.println("2. Search By ID");
    }

}
