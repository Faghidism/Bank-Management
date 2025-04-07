package af.faghid;

/*
class moshtari
esm moshtari, costructor , getter va setter
+ arraye list tedad moshtari ha
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Customer {
    public String customerName;
    public String[] customerNameArray;


    public Bank bank = new Bank();

    private void setCustomerName() throws FileNotFoundException{
        customerNameArray = new String[customersNumber()];

        File file = new File("Documents/CustomersName.txt");
        Scanner scanner = new Scanner(file);
        int i = 0;
        while (scanner.hasNextLine()) {
            customerNameArray[i] = scanner.nextLine();
            i++;

        }
    }

    private int customersNumber() throws FileNotFoundException {
        int customerNumber = 0;
        File file = new File("Documents/CustomersName.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            scanner.nextLine();
            customerNumber++;

        }
        return customerNumber;
    }

    private String getCustomerName() throws FileNotFoundException{
        setCustomerName();
        return customerName;
    }


    public void customerProfile() throws IOException {
        profileOption();
        Scanner scanner = new Scanner(System.in);

        boolean trueInput = false;
        while (!trueInput) {
            String select = scanner.nextLine();
            if (select.equals("1")) {
                showCustomerInformation(getCustomerName());
                trueInput = true;
            }
            if (select.equals("2")) {
                enterCustomerInformation(getCustomerName());
                trueInput = true;
            }
            if (select.equalsIgnoreCase("e")) {
                trueInput = true;
            } else if (!trueInput) System.out.println("Wrong Input !");
        }
    }// option "1" in Customer List

    public void profileOption() {
        System.out.println("1. Show My information");
        System.out.println("2. Inter New Information");
        System.out.println("Enter E to return menu");
    }


    private void showCustomerInformation(String customerName) throws FileNotFoundException {
        File file = new File("Documents/CustomersProfile.txt");
        Scanner scanner = new Scanner(file);
        String customerInformation = "";
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            int numberSignIndex;
            if (data != null) {
                numberSignIndex = data.indexOf("#");
                if (data.substring(0, numberSignIndex).equals(customerName))
                    customerInformation = data.substring(numberSignIndex + 1, data.length());
            }
        }
        System.out.println(customerInformation);
    }

    private void enterCustomerInformation(String customerName) throws IOException{
        Scanner scanner = new Scanner(System.in);
        FileWriter writer = new FileWriter("Documents/CustomersProfile.txt", true);
        System.out.println("How old is the Customer ?");
        String age = scanner.nextLine();
        System.out.println("Please Enter Customer Mothers Name :\n");
        String motherName = scanner.nextLine();
        System.out.println("Please Enter Customer Fathers Name :\n");
        String fathersName = scanner.nextLine();
        System.out.println("Please Enter Customer Phone Number :\n");
        String numberPhone = scanner.nextLine();
        writer.write(customerName + "#" + "Age :" + age + "| Mothers Name : " + motherName + "| Fathers Name : " + fathersName + "| phone Number :" + numberPhone + "\n");
        writer.close();
    }



    public void showInventory() throws FileNotFoundException {
        File file = new File("Documents/CustomersInventory.txt");
        Scanner scanner = new Scanner(file);
        int inventory = 0;
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            int numberSignIndex = data.indexOf("#");
            if (data != null) {
                numberSignIndex = data.indexOf("#");
                inventory += Integer.valueOf(data.substring(numberSignIndex + 1, data.length()));
            }
        }
        System.out.println(inventory + "$");
    }

    private String getOnlineCustomerName() throws FileNotFoundException {
        setOnlineCustomerName();
        return customerName;
    }

    private void setOnlineCustomerName() throws FileNotFoundException {
        File file = new File("Documents/OnlineCustomer.txt");
        Scanner scanner = new Scanner(file);
        customerName = scanner.nextLine();
    }

    public void cashWithDrawal() throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Customers Name :\n");
        String customerName = scanner.nextLine();
        if (existCustomer(customerName)) {
            System.out.println("Total customer inventory : 5000000 $");
            System.out.println("Paid : " + findCustomerCashWithDrawal(customerName) + "$");
            System.out.println("Remaining inventory : " + (5000000 - findCustomerCashWithDrawal(customerName)) + "$");
        } else System.out.println("The Customer Name is UnAvailable !");
    }

    private Integer findCustomerCashWithDrawal(String customerName) throws FileNotFoundException {
        File file = new File("Documents/CustomerCashWithDrawal.txt");
        Scanner scanner = new Scanner(file);
        int cashWithDrawal = 0;
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            int numberSignIndex = data.indexOf("#");
            if (data != null) {
                numberSignIndex = data.indexOf("#");
                cashWithDrawal += Integer.valueOf(data.substring(numberSignIndex + 1, data.length()));
            }
        }
        System.out.println(cashWithDrawal + "$");
        return cashWithDrawal;
    }


    private boolean existCustomer(String customerName) throws FileNotFoundException {
        setCustomerName();
        boolean exist = false;

        for (int i = 0; i < customerNameArray.length; i++)
            if (customerName.equals(customerNameArray[i]))
                exist = true;

        return exist;
    }




//        File file = new File("Documents/CustomerCashWithDrawal.txt");
//        Scanner scanner = new Scanner(file);
//        int CashWithDrawal = 0;
//        while (scanner.hasNextLine()) {
//            String data = scanner.nextLine();
//            int numberSignIndex;
//            if (data != null) {
//                numberSignIndex = data.indexOf("#");
//                CashWithDrawal += Integer.valueOf(data.substring(numberSignIndex + 1, data.length()));
//            }
//
//
//        }
      //  System.out.println(CashWithDrawal + "$");
   // }

    public void depositInBank() {

    }

//    public void buyCharge() throws FileNotFoundException {
//        chargeOption();
//        Scanner scanner = new Scanner(System.in);
//
//        boolean trueInput = false;
//        while (!trueInput) {
//            String select = scanner.nextLine();
//            if (select.equals("1")) {
//                enterCharge10000(getCustomerName());
//                trueInput = true;
//            }
//            if (select.equals("2")) {
//                enterCharge5000(getCustomerName());
//                trueInput = true;
//            }
//            if (select.equals("3")) {
//                enterCharge2000(getCustomerName());
//                trueInput = true;
//            }
//            if (select.equals("4")) {
//                enterCharge1000(getCustomerName());
//                trueInput = true;
//            }
//            if (select.equalsIgnoreCase("e")) {
//                trueInput = true;
//            } else if (!trueInput) System.out.println("Wrong Input !");
//        }
//    }

//    private void enterCharge10000(String customerName) {
//
//    }

//    private void chargeOption() {
//    }

    public void showRemainingLoan() throws FileNotFoundException {
        File file = new File("Documents/CustomersLoan.txt");
        showInventory();
        Scanner scanner = new Scanner(file);
        int loan = 0;
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            if (data != null)
                if (data.substring(0, numberSignIndex(data) - 1).equals(getCustomerName())) {
                    loan += (Integer.valueOf(data.substring(numberSignIndex(data), data.length())));

                }
        }
        System.out.println(1000000 - loan + "$");
    }

    public boolean customerNameIsAvilable(String customerName) throws FileNotFoundException {
        bank.setCustomerArray();
        boolean findCustomer = false;
        for (int i = 0; i < bank.customerArray.length; i++)
            if (bank.customerArray[i].equalsIgnoreCase(customerName)) {
                findCustomer = true;
                break;
            }
        return findCustomer;
    }

    public String findCustomerAccount(String customerName) throws FileNotFoundException {
        String accountId = "";
        File file = new File("Documents/CompleteId.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            if (data != null) {
                if (data.contains(customerName)) {
                    accountId = data.substring(0, data.indexOf("#"));
                    break;
                }
            }
        }
        return accountId;

    }

    public boolean customerNameIsAvailable(String customerName) throws FileNotFoundException {
        bank.setCustomerArray();
        boolean findCustomer = false;
        for (int i = 0; i < bank.customerArray.length; i++)
            if (bank.customerArray[i].equalsIgnoreCase(customerName)) {
                findCustomer = true;
                break;
            }
        return findCustomer;
    }

    public int numberSignIndex(String line) {
        int index = 0;
        if (line != null) {

            for (int i = 0; i < line.length(); i++)
                if (line.charAt(i) == '#') {
                    index = i;
                    break;
                }
        }
        return index + 1;
    }

}
