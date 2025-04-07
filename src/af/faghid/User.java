package af.faghid;

/*
class user
chech mikone user esm va pass id har yek az user ha to file vojod dare ya na
 */

import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.util.Scanner;

public class User {
    Bank bank = new Bank();
    Customer customer = new Customer();
    public String customerName;


    public void signIn() throws FileNotFoundException {
        userTypeOption(); // to show user type option and select

    }


    public boolean signInCustomer() throws IOException {

        Scanner scanner = new Scanner(System.in);
        boolean customerSignIn = false;

        System.out.println("Please Enter Your Name :\n");
        String name = scanner.nextLine();
        setCustomerNameAfterSignIn(name);
        writeOnlineUserName(name);

        if (existUser(name, "Documents/CustomersName.txt")) {
            if (customerInformationIsRight())
                customerSignIn = true;
            else System.out.println("User Not Found !");
        } else System.out.println("The Customer Name Not Found !\n");


        return customerSignIn;
    }

    public void setCustomerNameAfterSignIn(String name) {
        customerName = "";
        customerName = name;
    }

    public String getCustomerNameAfterSignIn() {
        return customerName;
    }


    public boolean signInEmployee() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean employeeSignIn = false;
        System.out.println("Please Enter Your Name :\n");
        String name = scanner.nextLine();
        setCustomerNameAfterSignIn(name);
        writeOnlineUserName(name);

        if (existUser(name, "Documents/EmployeesName.txt")) {
            if (employeeInformationIsRight()) {
                employeeSignIn = true;
            } else System.out.println("User Not Found !");
        } else System.out.println("The Employee Name Not Found !\n");


        return employeeSignIn;
    }

    public boolean signInManager() throws IOException {
        cls();
        boolean managerSignIn = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter Your Name :\n");
        String name = scanner.nextLine();
        setCustomerNameAfterSignIn(name);


        if (existUser(name, "Documents/ManagerName.txt")) {
            if (managerInformationIsRightToSignIn()) {
                managerSignIn = true;

            }
        }

        return managerSignIn;
    }


    public boolean existUser(String name, String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        boolean nameExist = false;
        String data;
        File myObject = new File(fileName);
        Scanner myReader = new Scanner(myObject);
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            if (data.equals(name)) {
                nameExist = true;
                break;
            }
        }


        return nameExist;
    }

    // To enter a username and password, if the username and password match, enter the next step
    public boolean managerInformationIsRightToSignIn() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String managerPassword = "", managerUserName = "";

        System.out.println("Please enter your user name :\n");
        String userName = scanner.nextLine();
        System.out.println("Please enter your password :\n");
        String password = scanner.nextLine();


        File userNameObjet = new File("Documents/ManagerUserName.txt");
        Scanner userNameFileScanner = new Scanner(userNameObjet);
        while (userNameFileScanner.hasNextLine()) {
            managerUserName = userNameFileScanner.nextLine();
            break;
        }

        File passwordObject = new File("Documents/ManagerPassword.txt");
        Scanner passwordScanner = new Scanner(passwordObject);
        while (passwordScanner.hasNextLine()) {
            managerPassword = passwordScanner.nextLine();
            break;
        }


        if (managerPassword.equals(password) && managerUserName.equals(userName))
            return true;
        else return false;
    }

    // if customer information is right the user can be sign in
    public boolean customerInformationIsRight() throws FileNotFoundException {
        boolean login = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter Your User Name :\n");
        String userName = scanner.nextLine();
        System.out.println("Please Enter Your Password :\n");
        String password = scanner.nextLine();
        if (customerUserNameIsRight(getCustomerNameAfterSignIn(), userName) && customerPassWordIsRight(getCustomerNameAfterSignIn(), password))
            login = true;


        return login;
    }

    public boolean employeeInformationIsRight() throws FileNotFoundException {
        boolean login = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter Your User Name :\n");
        String userName = scanner.nextLine();
        System.out.println("Please Enter Your Password :\n");
        String password = scanner.nextLine();
        if (employeeUserNameIsRight(getCustomerNameAfterSignIn(), userName) && employeePasswordIsRight(getCustomerNameAfterSignIn(), password)) {
            login = true;
        }
        return login;

    }

    public boolean customerUserNameIsRight(String name, String userName) throws FileNotFoundException {
        boolean findUserName = false;
        File file = new File("Documents/CustomersUserName.txt");
        Scanner scanner = new Scanner(file);

        String data;
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            int numberSignIndex = data.indexOf("#");
            if (data.contains("#" + userName) && data.contains(name)) {
                if (data.substring(numberSignIndex + 1, data.length()).equals(userName))
                    findUserName = true;
                break;
            }
        }


        return findUserName;
    }

    public boolean employeeUserNameIsRight(String name, String userName) throws FileNotFoundException {
        boolean findUserName = false;
        File file = new File("Documents/EmployeesUserName.txt");
        Scanner scanner = new Scanner(file);

        String data;
        while (scanner.hasNextLine()) {

            data = scanner.nextLine();
            int numberSignIndex = data.indexOf("#");
            if (data.contains("#" + userName) && data.contains(name)) {
                if (data.substring(numberSignIndex + 1, data.length()).equals(userName))

                    findUserName = true;
                break;
            }
        }

        return findUserName;
    }

    public boolean customerPassWordIsRight(String name, String password) throws FileNotFoundException {
        boolean findPassword = false;
        File file = new File("Documents/CustomersPassword.txt");
        Scanner scanner = new Scanner(file);

        String data;
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            int numberSignIndex = data.indexOf("#");

            if (data.contains(name) && data.contains("#" + password)) {
                if (data.substring(numberSignIndex + 1, data.length()).equals(password))
                    findPassword = true;
                break;
            }
        }


        return findPassword;
    }

    public boolean employeePasswordIsRight(String name, String password) throws FileNotFoundException {
        boolean findPassword = false;
        File file = new File("Documents/EmployeesPassword.txt");
        Scanner scanner = new Scanner(file);

        String data;
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            int numberSignIndex = data.indexOf("#");
            if (data.contains(name) && data.contains("#" + password)) {
                if (data.substring(numberSignIndex + 1, data.length()).equals(password))

                    findPassword = true;
                break;

            }
        }

        return findPassword;
    }
    // to sign up user
    public void signUp() throws IOException {
        userTypeOption(); // show option , user can be student teacher or manager
        selectUserTypetoSignUp(); // to select user type and register
    }

    public void userTypeOption() {
        System.out.println("select your user type :\n");
        System.out.println("1. Customer");
        System.out.println("2. Employee");
        System.out.println("3. Manager");
        System.out.println("Enter E to return the menu");
    }

    public void selectUserTypetoSignUp() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean trueSelect = false;
        while (!trueSelect) {
            String select = scanner.nextLine();
            if (select.equals("1")) {
                cls();
                signUpCustomerUser();
                trueSelect = true;
            }
            if (select.equals("2")) {
                cls();
                signUpEmployeeUser();
                trueSelect = true;
            }
            if (select.equals("3")) {
                if (!existManager()) {
                    cls();
                    signUpManagerUser();

                } else System.out.println(" | You can not Sign up ! |\n -- because Manager is now available :( --");
            }
            if (select.equalsIgnoreCase("E")) {
                trueSelect = true;
                cls();
                Main main = new Main();
                main.menu();
            }
            if (!trueSelect)
                System.out.println("Wrong input !");
        }
    }

    public void signUpCustomerUser() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Your Name :\n");
        String customerName = scanner.nextLine();

        if (customerNameIsAvailable(customerName)) {
            FileWriter userNameWriter = new FileWriter("Documents/CustomersUserName.txt", true);
            FileWriter passwordWriter = new FileWriter("Documents/CustomersPassword.txt", true);
            FileWriter idWriter = new FileWriter("Documents/CustomerId.txt", true);
            userNameWriter.write(customerName + " #");
            userNameWriter.close();
            getUserNameToSignUp("Documents/CustomersUserName.txt");
            passwordWriter.write(customerName + " #");
            passwordWriter.close();
            getPasswordToSignUp("Documents/CustomersPassword.txt");
            idWriter.write(customerName + " #");
            idWriter.close();
            generateId("Documents/CustomerId.txt");
        } else System.out.println("The Customer Not Found !");

    }

    public void signUpEmployeeUser() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Your Name :\n");
        String employeeName = scanner.nextLine();
        if (existUser(employeeName, "Documents/EmployeesName.txt")) {
            FileWriter userNameWriter = new FileWriter("Documents/EmployeesUserName.txt", true);
            FileWriter passwordWriter = new FileWriter("Documents/EmployeesPassword.txt", true);
            FileWriter idWriter = new FileWriter("Documents/EmployeesId.txt", true);
            userNameWriter.write(employeeName + " #");
            userNameWriter.close();
            getUserNameToSignUp("Documents/EmployeesUserName.txt");
            passwordWriter.write(employeeName + " #");
            passwordWriter.close();
            getPasswordToSignUp("Documents/EmployeesPassword.txt");
            idWriter.write(employeeName + " #");
            idWriter.close();
            generateId("Documents/EmployeesId.txt");

        } else System.out.println("The Employee Not Found!");

    }

    public boolean existManager() throws FileNotFoundException {
        boolean testExist = false;
        File myObject = new File("Documents/ManagerName.txt");

        Scanner scanner = new Scanner(myObject);
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            testExist = true;
        }

        return testExist;
    }

    public void signUpManagerUser() throws IOException {
        getNameToSignUp("Documents/ManagerName.txt");
        cls();
        getUserNameToSignUp("Documents/ManagerUserName.txt");
        cls();
        getPasswordToSignUp("Documents/ManagerPassword.txt");
        cls();
        generateId("Documents/ManagerId.txt");


    }


    public void getNameToSignUp(String fileAddress) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your first name :\n");
        String firstName = scanner.nextLine();

        System.out.println("Please enter your last name :\n");
        String lastName = scanner.nextLine();

        FileWriter writer = new FileWriter(fileAddress, true);
        writer.write(firstName + " " + lastName + "\n");
        writer.close();
    }

    public boolean customerNameIsAvailable(String customerName) throws FileNotFoundException {
        boolean avilable = false;
        bank.setCustomerArray();
        for (int i = 0; i < bank.customerArray.length; i++)
            if (customerName.equals(bank.customerArray[i])) {
                avilable = true;
                break;
            }
        return avilable;
    }

    public void getUserNameToSignUp(String fileName) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please select a user name and enter it : \n");
        String userName = scanner.nextLine();

        FileWriter myWriter = new FileWriter(fileName, true);
        myWriter.write(userName + "\n");
        myWriter.close();
    }


    public void getPasswordToSignUp(String fileName) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please select a Password : ");
        String password = scanner.nextLine();
        FileWriter myWriter = new FileWriter(fileName, true);
        myWriter.write(password + "\n");
        myWriter.close();
    }


    public void generateId(String fileName) throws IOException {
        String id = "";
        if (fileName.equals("Documents/ManagerId.txt"))
            id = "m" + generateRandomNumber();
        if (fileName.equals("Documents/CustomerId.txt"))
            id = "c" + generateRandomNumber();
        if (fileName.equals("Documents/EmployeesId.txt"))
            id = "e" + generateRandomNumber();

        System.out.println("--Registration completed successfully--\n");
        System.out.println("Your ID is :\n" + id);
        FileWriter writer = new FileWriter(fileName, true);
        writer.write(id + "\n");
        writer.close();
    }

    public int generateRandomNumber() {
        double doubleNumber;
        doubleNumber = (Math.random() * 100000000);
        int idNumber = 1000000000 + (int) doubleNumber;

        return idNumber;

    }

    public void writeOnlineUserName(String name) throws IOException {
        FileWriter writer = new FileWriter("Documents/OnlineCustomer.txt");
        writer.write(name);
        writer.close();
    }

    public void cls() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }
}