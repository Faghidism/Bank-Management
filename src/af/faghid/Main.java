package af.faghid;

/*

Proje modiriyat bank
Farid afrakhte 990122680092

*/

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        createfile();
        menuoption();
        selectLoginOptions();
    }


    private static void createfile() throws IOException {  // sakht file baraye save kardan etelaat
        createEmployeeFile();
        createManagerFile();
        createBankFile();
        createCustomerFile();
    }

    private static void createCustomerFile() throws IOException {
        createFile("Documents/CustomersName.txt");      //Customer name
        createFile("Documents/CustomersUserName.txt");  //Customer username
        createFile("Documents/CustomerId.txt");         //Customer Id
        createFile("Documents/CustomersPassword.txt");  //Customer pass
        createFile("Documents/CustomersInventory.txt"); //Customer cash in wallet
        createFile("Documents/CustomersLoan.txt");      //Customer loan amount
    }

    private static void createBankFile() throws IOException{
        createFile("Documents/Property.txt");           // to save Bank Property
        createFile("Documents/AccountsName.txt");       // to save Account Names
        createFile("Documents/CompleteAccount.txt");    // to save Account information
        createFile("Documents/AccountAndCustomer.txt"); // to save Account Name And Customer Name next to each other

    }

    private static void createManagerFile() throws IOException{
        createFile("Documents/ManagerName.txt");           //esm manager
        createFile("Documents/ManagerUserName.txt");       //username manager
        createFile("Documents/ManagerPassword.txt");       //password manager
        createFile("Documents/ManagerId.txt");             //id manager
    }

    private static void createEmployeeFile() throws IOException {
        createFile("Documents/EmployeesName.txt");              //Employee Name
        createFile("Documents/EmployeesUserName.txt");          //Employee username
        createFile("Documents/EmployeeId.txt");                 //Employee Id
        createFile("Documents/EmployeesPassword.txt");          //Employee password
        createFile("Documents/EmployeeIncome.txt");             //Employee fee
    }

    public static void menuoption() throws IOException{      // namayesh option menu va sedaye beep

        Toolkit.getDefaultToolkit().beep();
        System.out.println("1. Signin");
        System.out.println("2. Signup");
        System.out.println("press E for Exit");

    }

    public static void selectLoginOptions() throws IOException {    //entekhab yeki az 3 option menu
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        boolean trueSelect = false;
        while (!trueSelect) {

            String select = scanner.nextLine();
            if (select.equals("1")) {
                cls();
                user.signIn();
                selectUserTypeToSignIn();
                trueSelect = true;
            }
            if (select.equals("2")) {

                cls();
                user.signUp();
                Toolkit.getDefaultToolkit().beep();
                System.out.println("Enter any key to return menu :\n");
                String ch = scanner.nextLine();
                cls();
                menu();
                trueSelect = true;
            }
            if (select.equalsIgnoreCase("E")) {
                trueSelect = true;
                cls();
                Toolkit.getDefaultToolkit().beep();
                System.out.println("Bye");
            }
            if (!trueSelect)
                Toolkit.getDefaultToolkit().beep();
                System.out.println("Wrong number, try Again");

        }
    }

    private static void selectUserTypeToSignIn() throws IOException{
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        boolean trueSelect = false;
        while (!trueSelect) {
            String select = scanner.nextLine();


            if (select.equals("1")) {   // agar adad 1 vared shavad singin customer vared mishavad
                // if user selected "1" go to sign in Customer method in " User " Class
                if (user.signInCustomer()) {
                    cls();
                    showCustomerOptionAfterSignIn();
                    selectCustomerOptionAfterSignIn();

                } else {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("The information Entered is InCorrect !");
                    System.out.println(" -- Enter Any key to Return Menu -- ");
                    String menu = scanner.nextLine();
                    cls();
                    menu();
                }

                trueSelect = true;
            }
            if (select.equals("2")) {  // agar adad 2 vared shavad singin karmand vared mishavad

                if (user.signInEmployee()) {

                    cls();
                    showEmployeeOptionAfterSignIn();
                    selectEmployeeOptionAfterSignIn();

                } else {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("The information Entered is InCorrect !");
                    System.out.println(" -- Enter Any key to Return Menu -- ");
                    String menu = scanner.nextLine();
                    cls();
                    menu();// return to menu and try again
                }
            }
            if (select.equals("3")) {  //agar adad 3 vared shavad singin modir vared mishavad
                if (user.signInManager()) {
                    cls();
                    showManagerOptionsAfterSignIn();
                    selectOptionForManagerAfterSignIn();
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("The information Entered is InCorrect !");
                    System.out.println(" -- Enter Any key to Return Menu -- ");
                    String menu = scanner.nextLine();
                    cls();
                    menu();
                }
                trueSelect = true;
            }
            if (select.equalsIgnoreCase("e")) {
                trueSelect = true;
                cls();
                menu();
            }
            if (!trueSelect)
                System.out.println("Wrong input !");

        }
    }
    private static void showManagerOptionsAfterSignIn() {
        Toolkit.getDefaultToolkit().beep();// chap menu maneger bad az vorod
        System.out.println("1. Add Customer");
        System.out.println("2. Add Employee");
        System.out.println("3. Remove Customer");
        System.out.println("4. Remove Employee");
        System.out.println("5. Show customer");
        System.out.println("6. Show Employees profile");
        System.out.println("7. Choose Employees side");
        System.out.println("8. Show Bank income");
        System.out.println("9. Show Bank expense");
        System.out.println("10. Show loan profile ");
        System.out.println("11. Count of Account");
        System.out.println("12. Pay employee salaries");
        System.out.println("13. Depositing money and paying customers debts");
        System.out.println("14. Open an Account or ban an account");
        System.out.println("15. Search Customer");
        System.out.println("16. Search Employee");
        System.out.println("17. Show property Of Bank");
    }

    private static void selectOptionForManagerAfterSignIn() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean trueInput = false;
        Manager manager = new Manager();
        while (!trueInput) {

            String select = scanner.nextLine();
            if (select.equals("1")) {
                cls();

                manager.addNewCustomer();                                         // add customer name
                Toolkit.getDefaultToolkit().beep();
                System.out.println("The Customer name saved successfully !");
                System.out.println("Enter any key to return menu :\n");
                String returnMenu = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                  // bargasht be menu manager


            }
            if (select.equals("2")) {
                cls();
                manager.addNewEmployee();                                         //add employee name
                Toolkit.getDefaultToolkit().beep();
                System.out.println("The Employee name saved successfully !");
                System.out.println("Enter any key to return menu :\n");
                String returnMenu = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                  // bargasht be menu manager

            }
            if (select.equals("3")) {
                cls();
                manager.removeCustomer();                                         //remove customer
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                  // bargasht be menu manager
            }
            if (select.equals("4")) {
                cls();
                manager.removeEmployee();                                         //remove employee
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                  // bargasht be menu manager
            }
            if (select.equals("5")) {
                cls();
                manager.showCustomer();                                           //show Customer
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                  // bargasht be menu manager

            }
            if (select.equals("6")) {
                cls();
                manager.showEmployeesProfile();                                   //show employees profile
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                   // bargasht be menu manager

            }
            if (select.equals("7")) {
                cls();
                manager.chooseEmployeesJob();                                      //show EmployeesSide
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                  // bargasht be menu manager

            }
            if (select.equals("8")) {
                cls();
                manager.ShowBankIncome();                                           // show Bank Income
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                    // bargasht be menu manager

            }
            if (select.equals("9")) {
                cls();
                manager.ShowBankExpense();                                          //show Bank Expense
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                   // bargasht be menu manager

            }
            if (select.equals("10")) {
                cls();
                manager.ShowLoanprofile();                                         //show Loan profile
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                   // bargasht be menu manager

            }
            if (select.equals("11")) {
                cls();
                manager.CountOfAccount();                                          //show Count Of Account
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                  // bargasht be menu manager

            }
            if (select.equals("12")) {
                cls();
                manager.PayEmployeeSalaries();                                   //Pay employee fee
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                 // bargasht be menu manager

            }
            if (select.equals("13")) {
                cls();
                manager.DepositingMoneyAndPayingCustomer();                       //Depositing Money
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                  // bargasht be menu manager

            }
            if (select.equals("14")) {
                cls();
                manager.OpenOrBanAccount();                                      //Open or ban an Account
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                // bargasht be menu manager

            }
            if (select.equals("15")) {
                cls();
                manager.SearchCustomer();                                      //search customer
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                // bargasht be menu manager

            }
            if (select.equals("16")) {
                cls();
                manager.SearchEmployee();                                        // to search employee
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                  // bargasht be menu manager

            }
            if (select.equals("17")) {
                cls();
                manager.ShowPropertyOfBank();                                      // to search customer or employee
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showManagerOptionsAfterSignIn();                                    // bargasht be menu manager

            }
            if (select.equalsIgnoreCase("e")) {
                cls();
                menu();
                trueInput = true;
            }
        }
    }

    private static void showEmployeeOptionAfterSignIn() {                       // chap menu karmand bad az vorod
        Toolkit.getDefaultToolkit().beep();
        System.out.println("1. Employees Information");
        System.out.println("2. Withdraw money from an account");
        System.out.println("3. Money transfer");
        System.out.println("4. Payed loan of customer");
        System.out.println("5. Open account");
        System.out.println("6. Ban an account");
        System.out.println("7. Search Customer");


    }

    private static void selectEmployeeOptionAfterSignIn() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean trueInput = false;
        Employee employee = new Employee();
        while (!trueInput) {


            String select = scanner.nextLine();
            if (select.equals("1")) {
                cls();
                employee.employeeInformation();                                  //employee information
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showEmployeeOptionAfterSignIn();                                 // bargasht be menu karmand
            }
            if (select.equals("2")) {
                cls();
                employee.decreaseCustomerLoan();                                 //import Customer Account
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showEmployeeOptionAfterSignIn();                                 // bargasht be menu karmand
            }
            if (select.equals("3")) {
                cls();
                employee.transferMoney();                                        //transfer Money
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showEmployeeOptionAfterSignIn();                                // bargasht be menu karmand
            }
            if (select.equals("4")) {
                cls();
                employee.paiedCustomerLoan();                                   // pay Customer loan
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showEmployeeOptionAfterSignIn();                                   // bargasht be menu karmand

            }
            if (select.equals("5")) {
                cls();
                employee.startAnAccount();                                     //enter a new account
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showEmployeeOptionAfterSignIn();                                // bargasht be menu karmand
            }
            if (select.equals("6")) {
                cls();
                employee.banAnAccount();                                       //ban  account
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showEmployeeOptionAfterSignIn();                                // bargasht be menu karmand
            }
            if (select.equals("7")) {
                cls();
                employee.searchCustomer();                                        // to search customer by id or userName
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showEmployeeOptionAfterSignIn();                                 // bargasht be menu karmand
            }
            if (select.equals("e")) {
                trueInput = true;
                cls();
                menu();
            }
        }
    }


    private static void showCustomerOptionAfterSignIn() {      //chap menu moshtari bad az vorod
        Toolkit.getDefaultToolkit().beep();
        System.out.println("1. Customers Profile");
        System.out.println("2. inventory");
        System.out.println("3. Cash withdrawal");
        System.out.println("4. Deposit");
        System.out.println("5. Buy Charge");
        System.out.println("6. Show Remaining loan");
    }

    private static void selectCustomerOptionAfterSignIn() throws  IOException {
        Scanner scanner = new Scanner(System.in);
        boolean trueInput = false;
        Customer customer = new Customer();
        while (!trueInput) {
            String select = scanner.nextLine();


            if (select.equals("1")) {
                cls();
                customer.customerProfile();                                      // make/show customer profile
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showCustomerOptionAfterSignIn();                                 // bargasht be menu moshtari

            }
            if (select.equals("2")) {
                cls();
                customer.showInventory();                                       // to Shows Inventory
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showCustomerOptionAfterSignIn();                                // bargasht be menu moshtari
            }
            if (select.equals("3")) {
                cls();
                customer.cashWithDrawal();                                     // to cash withdrawal from Inventory
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showCustomerOptionAfterSignIn();                                // bargasht be menu moshtari
            }
            if (select.equals("4")) {
                cls();
                customer.depositInBank();                                       //deposit in bank
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showCustomerOptionAfterSignIn();                                // bargasht be menu moshtari
            }
            /*
                if (select.equals("5")) {
                cls();
                customer.buyCharge(); // to buy charge
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
              showCustomerOptionAfterSignIn();
            }
            */

            if (select.equals("6")) {
                cls();
                customer.showRemainingLoan();                                       // show remaining loan
                Toolkit.getDefaultToolkit().beep();
                System.out.println("\n Enter Any key to Return Menu :\n");
                String ch = scanner.nextLine();
                cls();
                showCustomerOptionAfterSignIn();                                    // bargasht be menu moshtari
            }
            if (select.equals("e")) {
                cls();
                menu();
                trueInput = true;
            }
        }
            }

    public static void createFile(String fileName) throws IOException {
        File myObject = new File(fileName);
        myObject.createNewFile();
    }

    public static void cls() {
            for (int i = 0; i < 100; i++)
                System.out.println();
        }
    }
