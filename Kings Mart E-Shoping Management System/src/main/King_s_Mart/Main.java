
//package org.redoy;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Shop shop = new Shop();
    static Seller seller = new Seller(); // Saller
    static Customer customer = new Customer();
    static Order order = new Order();
    static Admin admin = new Admin();

    public static void sellerManipulation(String inputUsername) {
        clearScreen();
        System.out.println("\n\n\n\u001B[1m\u001B[32m");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t|             Seller Section             |");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------\n");
        System.out.println("\u001B[0m");
        System.out.println(
                "\t\t\t\t\t\t ---------------------------\t---------------------------\t---------------------------");
        System.out.println(
                "\t\t\t\t\t\t | 1. Display Products     |\t| 2. Add Product          |\t| 3. Update Product       |");
        System.out.println(
                "\t\t\t\t\t\t ---------------------------\t---------------------------\t---------------------------");
        System.out.println("\t\t\t\t\t\t ---------------------------\t---------------------------");
        System.out.println("\t\t\t\t\t\t | 4. Delete Product       |\t| 5. Total Sales          |");
        System.out.println("\t\t\t\t\t\t ---------------------------\t---------------------------");
        System.out.println("\t\t\t\t\t\t ---------------------------");
        System.out.println("\t\t\t\t\t\t | 6. Ordered Items        |");
        System.out.println("\t\t\t\t\t\t ---------------------------");
        System.out.println("\t\t\t\t\t\t\t\t      ----------------");
        System.out.println("\t\t\t\t\t\t\t\t      |    7. Back    |");
        System.out.println("\t\t\t\t\t\t\t\t      ----------------");
        System.out.print("\n\t\t\t\t\t\t Enter your choice: ");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                clearScreen();
                shop.displayProducts(inputUsername);
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 2:
                clearScreen();
                shop.addProduct(inputUsername);
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 3:
                System.out.print("\n\n\t\t\t\tProduct Updating");
                input.nextLine();
                System.out.print("\n\n\t\t\t\tEnter product ID: ");
                String productId = input.nextLine();
                clearScreen();
                shop.updateProduct(inputUsername, productId);
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 4:
                System.out.println("\n\n\t\t\t\tRemoving product");
                input.nextLine();
                System.out.print("\n\t\t\t\tEnter product ID: ");
                String productID = input.nextLine();
                clearScreen();
                shop.removeProduct(inputUsername, productID);
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 5:
                clearScreen();
                order.displayTotalSaleOfSeller(inputUsername);
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 6:
                clearScreen();
                order.displayOrderedItemOfSeller(inputUsername);
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 7:
                clearScreen();
                selerSection();
                break;
            default:
                System.out.println("\n\n\n\t\t\t\t\tInvalid choice, please try again");
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
        }
        sellerManipulation(inputUsername);
    }

    public static void selerSection() {
        clearScreen();
        System.out.println("\n\n\n\u001B[1m\u001B[32m");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t|            Seller Section              |");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------\n");
        System.out.println("\u001B[0m");
        System.out.println("\t\t\t\t\t\t ---------------------------\t-------------------------");
        System.out.println("\t\t\t\t\t\t |        1. LogIn         | \t|     2. Register       |");
        System.out.println("\t\t\t\t\t\t ---------------------------\t-------------------------");
        System.out.println("\t\t\t\t\t\t\t\t      ----------------");
        System.out.println("\t\t\t\t\t\t\t\t      |    3. Back    |");
        System.out.println("\t\t\t\t\t\t\t\t      ----------------");
        System.out.print("\n\t\t\t\t\t\t Enter your choice: ");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                boolean flag = false;
                System.out.println("\n\n\n\t\t\t\t\tLogin as Seller");
                input.nextLine();
                System.out.print("\n\t\t\t\tEnter Username: ");
                String inputUsername = input.nextLine();
                System.out.print("\n\t\t\t\tEnter Password: ");
                String inputPassword = input.nextLine();
                boolean flag1 = seller.login(inputUsername, inputPassword, flag);
                if (flag1) {
                    System.out.println("\n\t\t\t\tSeller Login Successful");
                    System.out.print("\n\t\t\t\t\t Any Key to continue...");
                    input.nextLine();
                    clearScreen();
                    sellerManipulation(inputUsername);
                }
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 2:
                clearScreen();
                seller.register();
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("\n\n\n\t\t\t\t\tInvalid choice, please try again");
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                break;
        }
        selerSection();
    }

    public static void payment(String inputUsername) {
        clearScreen();
        System.out.println("\n\n\n\u001B[1m\u001B[32m");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t|               Payment                 |");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------\n");
        System.out.println("\u001B[0m");
        System.out.println("\t\t\t\t\t\t -------------------------------\t-------------------------");
        System.out.println("\t\t\t\t\t\t | 1. Bkash/Nogod/Roket        | \t|      2. Card         |");
        System.out.println("\t\t\t\t\t\t -------------------------------\t-------------------------");
        System.out.println("\t\t\t\t\t\t -------------------------------\t-------------------------");
        System.out.println("\t\t\t\t\t\t |        3. Cash              | \t|      4. Back         |");
        System.out.println("\t\t\t\t\t\t -------------------------------\t-------------------------");
        System.out.print("\n\t\t\t\t\t\t Enter your choice: ");
        int choice2 = input.nextInt();
        String pin, number, cardNumber;
        switch (choice2) {
            case 1:
                System.out.println("\n\n\t\t\t\tTotal Amount Of Charges");
                System.out.println("\n\n\t\t\t\tName : " + inputUsername);
                System.out.println("\t\t\t\tYour Payment Method : Bkash/Nogod/Roket");
                System.out.print("\t\t\t\tEnter Your Bkash/Nogod/Roket Number: ");
                input.nextLine();
                number = input.nextLine();
                System.out.print("\t\t\t\tEnter Your Pin : ");
                pin = input.nextLine();
                clearScreen();
                order.cashCounter(inputUsername, number);
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 2:
                System.out.println("\n\n\t\t\t\tTotal Amount Of Charges");
                System.out.println("\n\n\t\t\t\tName : " + inputUsername);
                System.out.println("\t\t\t\tYour Payment Method : Card");
                System.out.print("\t\t\t\tEnter Your Phone Number: ");
                number = input.nextLine();
                System.out.print("\t\t\t\tEnter Your Card Number: ");
                cardNumber = input.nextLine();
                System.out.print("\t\t\t\tEnter Your Pin : ");
                pin = input.nextLine();
                clearScreen();
                order.cashCounter(inputUsername, number);
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 3:
                System.out.println("\n\n\t\t\t\tTotal Amount Of Charges");
                System.out.println("\n\n\t\t\t\tName : " + inputUsername);
                System.out.println("\t\t\t\tYour Payment Method : Cash");
                System.out.print("\t\t\t\tEnter Your Phone Number: ");
                number = input.nextLine();
                clearScreen();
                order.cashCounter(inputUsername, number);
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 4:
                clearScreen();
                customerManipulation(inputUsername);
                break;
            default:
                System.out.println("\n\n\n\t\t\t\t\tInvalid choice, please try again");
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
        }
        payment(inputUsername);
    }

    public static void customerManipulation(String inputUsername) {
        clearScreen();
        System.out.println("\u001B[1m\u001B[32m");
        System.out.println("\n\n\n\t\t\t\t\t\t\t------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t|           Customer Section             |");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------\n");
        System.out.println("\u001B[0m");
        System.out.println(
                "\t\t\t\t -------------------------------\t-------------------------------\t-------------------------------");
        System.out.println(
                "\t\t\t\t | 1. Display All Products     |\t| 2. Place Order              |\t| 3. View Ordered Items       |");
        System.out.println(
                "\t\t\t\t -------------------------------\t-------------------------------\t-------------------------------");
        System.out.println(
                "\t\t\t\t -------------------------------\t-------------------------------\t-------------------------------");
        System.out.println(
                "\t\t\t\t | 4. Update Ordered Items     |\t| 5. Delete Ordered Items     |\t| 6. Display Final Bill       |");
        System.out.println(
                "\t\t\t\t -------------------------------\t-------------------------------\t-------------------------------");
        System.out.println("\t\t\t\t\t\t\t  ------------------------\t------------------------");
        System.out.println("\t\t\t\t\t\t\t  | 7. Payment           |\t| 8. Back               |");
        System.out.println("\t\t\t\t\t\t\t  ------------------------\t------------------------");

        System.out.print("\n\n\t\t\t\t\t\tEnter your choice: ");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                clearScreen();
                shop.displayAllProducts();
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 2:
                clearScreen();
                shop.displayAllProducts();
                shop.customerPlaceOrder(inputUsername);
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 3:
                clearScreen();
                order.displayCardOrder(inputUsername);
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                ;
                break;
            case 4:
                System.out.println("\n\n\t\t\t\tUpdate Ordered Items");
                input.nextLine();
                System.out.print("\n\n\t\t\t\tEnter Product ID to update in cart: ");
                String id = input.nextLine();
                clearScreen();
                order.updateCartItemById(id, inputUsername);
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 5:
                System.out.println("\n\n\n\t\t\t\tDelete ordered Item");
                input.nextLine();
                System.out.print("\n\n\t\t\t\tEnter Product ID to delete from cart: ");
                String deleteId = input.nextLine();
                clearScreen();
                order.deleteCartItemById(deleteId, inputUsername);
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 6:
                clearScreen();
                order.displayFinalBill(inputUsername);
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 7:
                clearScreen();
                payment(inputUsername);
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 8:
                clearScreen();
                orderProduct();
            default:
                System.out.println("\n\n\n\t\t\t\t\tInvalid choice, please try again");
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                break;
        }
        customerManipulation(inputUsername);
    }

    public static void orderProduct() {
        clearScreen();
        System.out.println("\u001B[1m\u001B[32m");
        System.out.println("\n\n\n\t\t\t\t\t\t\t------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t|           Ordered Product             |");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------\n");
        System.out.println("\u001B[0m");

        System.out.println("\t\t\t\t\t\t ---------------------------\t-------------------------");
        System.out.println("\t\t\t\t\t\t |        1. Login         | \t|       2. Register      |");
        System.out.println("\t\t\t\t\t\t ---------------------------\t-------------------------");

        System.out.println("\t\t\t\t\t\t\t\t      ----------------");
        System.out.println("\t\t\t\t\t\t\t\t      |    3. Back    |");
        System.out.println("\t\t\t\t\t\t\t\t      ----------------");

        System.out.print("\n\n\t\t\t\t\t\tEnter your choice: ");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                boolean flag = false;
                System.out.println("\n\n\t\t\t\tLogin as Customer");
                input.nextLine();
                System.out.print("\n\t\t\t\tEnter Username: ");
                String inputUsername = input.nextLine();
                System.out.print("\n\n\t\t\t\tEnter Password: ");
                String inputPassword = input.nextLine();
                boolean flag1 = customer.login(inputUsername, inputPassword, flag);
                if (flag1) {
                    System.out.println("\n\n\t\t\t\tCustomer Login Successful");
                    System.out.print("\n\t\t\t\tEnter any key to continue: ");
                    input.nextLine();
                    clearScreen();
                    customerManipulation(inputUsername);
                }
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 2:
                clearScreen();
                customer.register();
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 3:
                // System.out.println("Back");
                clearScreen();
                customerSection();
                break;
            default:
                System.out.println("\n\n\n\t\t\t\t\tInvalid choice, please try again");
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                break;
        }
        orderProduct();
    }

    public static void customerSection() {
        clearScreen();
        System.out.println("\u001B[1m\u001B[32m");
        System.out.println("\n\n\n\t\t\t\t\t\t\t------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t|           Customer Section             |");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------\n");
        System.out.println("\u001B[0m");

        System.out.println("\t\t\t\t\t\t ---------------------------\t-------------------------");
        System.out.println("\t\t\t\t\t\t | 1. Display All Products  | \t| 2. Order Products      |");
        System.out.println("\t\t\t\t\t\t ---------------------------\t-------------------------");

        System.out.println("\t\t\t\t\t\t\t\t      ----------------");
        System.out.println("\t\t\t\t\t\t\t\t      |    3. Back    |");
        System.out.println("\t\t\t\t\t\t\t\t      ----------------");

        System.out.print("\n\n\t\t\t\t\t\tEnter your choice: ");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                clearScreen();
                shop.displayAllProducts();
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 2:
                clearScreen();
                orderProduct();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("\n\n\n\t\t\t\t\tInvalid choice, please try again");
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
        }
        customerSection();
    }

    public static void adminManipulation() {
        clearScreen();
        System.out.println("\n\n\n\u001B[1m\u001B[32m");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t|             Admin Section              |");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------\n");
        System.out.println("\u001B[0m");
        System.out.println(
                "\t\t\t\t-------------------------------\t-------------------------------\t-------------------------");
        System.out.println(
                "\t\t\t\t| 1. Display All Sellers      | \t| 2. Update Seller    | |\t3. Delete Seller   |");
        System.out.println(
                "\t\t\t\t-------------------------------\t-------------------------------\t-------------------------");
        System.out.println("\t\t\t\t\t\t\t  -------------------------------\t--------------------");
        System.out.println("\t\t\t\t\t\t\t  | 4. Display All Customers   | \t|  5. Back          |");
        System.out.println("\t\t\t\t\t\t\t  -------------------------------\t--------------------");
        System.out.print("\n\t\t\t\t\t\t\tEnter your choice: ");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                clearScreen();
                seller.displaySellers();
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 2:
                System.out.println("\n\n\n\t\t\t\tUpdate Seller Details");
                input.nextLine();
                System.out.print("\n\n\t\t\t\tEnter Seller Username : ");
                String inputUsername = input.nextLine();
                clearScreen();
                seller.updateSellerByUsername(inputUsername);
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 3:
                System.out.println("\n\n\n\t\t\t\tDelete Seller Details");
                input.nextLine();
                System.out.print("\n\n\t\t\t\tEnter Seller Username : ");
                inputUsername = input.nextLine();
                clearScreen();
                seller.deleteSeller(inputUsername);
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 4:
                clearScreen();
                customer.displayAllCustomers();
                System.out.print("\n\n\t\t\t\tEnter Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("\n\n\n\t\t\t\t\tInvalid choice, please try again");
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
        }
        adminManipulation();
    }

    public static void adminSection() {
        clearScreen();
        System.out.println("\n\n\n\u001B[1m\u001B[32m");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t|              Admin Section             |");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------\n");
        System.out.println("\u001B[0m");

        System.out.println("\t\t\t\t\t\t ---------------------------\t-------------------------");
        System.out.println("\t\t\t\t\t\t |        1.Login          |    |        2.Back       |");
        System.out.println("\t\t\t\t\t\t ---------------------------\t-------------------------");

        System.out.print("\n\n\t\t\t\t\t\tEnter your choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                boolean flag = false;
                System.out.println("\n\n\t\t\t\tLogin as Admin");
                input.nextLine();
                System.out.print("\n\t\t\t\tEnter Username: ");
                String inputUsername = input.nextLine();
                System.out.print("\n\n\t\t\t\tEnter Password: ");
                String inputPassword = input.nextLine();
                boolean flag1 = admin.login(inputUsername, inputPassword, flag);
                if (flag1) {
                    System.out.println("\n\t\t\t\tAdmin Login Successful!");
                    System.out.print("\n\t\t\t\t\t Any Key to continue...");
                    input.nextLine();
                    clearScreen();
                    adminManipulation();
                }
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
            case 2:
                menu();
                break;
            default:
                System.out.println("\n\n\n\t\t\t\t\tInvalid choice, please try again");
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
        }
        adminSection();
    }

    public static void menu() {
        clearScreen();
        System.out.println("\n\n\n\u001B[32m\t\t\t\t\t\t  +===============================================+");
        System.out.println(
                "\u001B[1m\u001B[32m\t\t\t\t\t\t  |               King's Mart!                    |\u001B[0m\u001B[32m");
        System.out.println("\t\t\t\t\t\t  +===============================================+\n\u001B[0m");
        System.out.println("\t\t\t\t\t --------------------\t--------------------\t---------------------");
        System.out.println("\t\t\t\t\t |   1. Customer    |\t|    2. Seller     |\t|    3. Admin       |");
        System.out.println("\t\t\t\t\t --------------------\t--------------------\t---------------------");
        System.out.println("\t\t\t\t\t\t   --------------------\t--------------------");
        System.out.println("\t\t\t\t\t\t   |   4. Help        |\t|    5. Exit       |");
        System.out.println("\t\t\t\t\t\t   --------------------\t--------------------");
        System.out.print("\n\n\t\t\t\t\tEnter your choice: ");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                clearScreen();
                customerSection();
                break;
            case 2:
                clearScreen();
                selerSection();
                break;
            case 3:
                clearScreen();
                adminSection();
                break;
            case 4:
                System.out.println("Help method is not implemented yet");
                break;
            case 5:
                exit(5);
                break;
            default:
                System.out.println("\n\n\n\t\t\t\t\tInvalid choice, please try again");
                System.out.print("\n\t\t\t\t\t Any Key to continue...");
                input.nextLine();
                input.nextLine();
                break;
        }
        menu();
    }

    public static void loadAutoAddProduct() {
        // 1st Seller
        seller.autoLoadSellers("Adib", "164", "0197555210", "adib@gmail.com", "adib", "1234", "Bananni12", "Dhaka",
                "BD", "UttorBongo", "UttorBongo101", "DSC");
        shop.autoAddProduct("Java Book", "101", 100.0d, 10, "Java Book", "adib");
        shop.autoAddProduct("Oop Book", "102", 200.0d, 10, "oop Book", "adib");
        // 2nd Seller
        seller.autoLoadSellers("King Redoy", "178", "0197555210", "king@gmail.com", "king", "1234", "Nars12",
                "Narshigndhi", "BD", "Kings Stall", "King101", "DSC");
        shop.autoAddProduct("Pizza", "103", 50.0d, 20, "Food", "king");
        shop.autoAddProduct("Burger", "104", 150.0d, 15, "Food", "king");

        // 3rd seller
        seller.autoLoadSellers("Tarak", "137", "01793922363", "tarak@gmail.com", "tarak", "9876", "Mirpur10", "Dhaka",
                "BD", "MobileShop", "TR11", "Mirpur");
        shop.autoAddProduct("Iphone", "105", 150000.0d, 10, "Apple", "tarak");
        shop.autoAddProduct("Samsung", "106", 120000.0d, 10, "Samsung", "tarak");

        // 4th seller
        seller.autoLoadSellers("Sami", "009", "01535817134", "sami@gmail.com", "sami", "4567", "Savar", "Dhaka",
                "BD", "Electronics", "ASM22", "Savar");
        shop.autoAddProduct("Light", "107", 500.0d, 10, "LED", "sami");
        shop.autoAddProduct("Fan", "108", 2000.0d, 10, "Charger", "sami");

        // 5th seller
        seller.autoLoadSellers("Pranth", "282", "01555455512", "pranth@gmail.com", "pranth", "2233", "Khagan", "Dhaka",
                "BD", "Cloths", "JDP34", "Khagan");
        shop.autoAddProduct("Shirt", "109", 2000.0d, 10, "Red", "pranth");
        shop.autoAddProduct("Pant", "110", 2500.0d, 10, "Black", "pranth");
    }

    // test
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    // test

    public static void welcomePage() {
        System.out.println(
                "\n\n\n\t\t\t\t\t\u001B[1m\u001B[32mWelcome to E-Commerce Shopping System\n \t\t\t\t\t\tKing's Mart!\u001B[0m");
        System.out.println("\n\n\n\t\t\t\tLoading...");
        try {
            Thread.sleep(3000); // Hold for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        clearScreen();
        welcomePage();
        loadAutoAddProduct(); // when program will be run, automaticly some saller and his shop product assign
        menu();
    }

}
