//package org.redoy;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    Scanner input = new Scanner(System.in);
    static ArrayList<Cart> carts = new ArrayList<>();

    // test
    public void placeOrder(ArrayList<Product> products, String inputName) {
        if (products.isEmpty()) {
            System.out.println("\n\n\t\t\t\tNo products available to order.");
            return;
        }

        System.out.print("\n\t\t\t\tHow many different products do you want to order?");
        int count = input.nextInt();
        input.nextLine();
        for (int i = 0; i < count; i++) {
            System.out.print("\t\t\t\tEnter Product ID: ");
            String productID = input.nextLine();
            System.out.print("\t\t\t\tEnter Quantity to order: ");
            int orderQty = input.nextInt();
            input.nextLine();
            boolean found = false;

            for (Product product : products) {
                if (product.productId.equals(productID)) {
                    if (product.productQuantity >= orderQty) {
                        // Add to cart
                        Cart cart = new Cart(product.productId, product.productName, product.productPrice,
                                product.productDescription, orderQty, inputName, product.inputUserName);
                        carts.add(cart);
                        product.productQuantity -= orderQty;
                        System.out.println("\t\t\t\tProduct '" + product.productName + "' added to cart.");
                    } else {
                        System.out.println("\t\t\t\tNot enough quantity for product: " + product.productName);
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("\t\t\t\tProduct ID not found.");
            }
        }
    }

    // test
    public void displayCardOrder(String inputUsername) {
        if (carts.isEmpty()) {
            System.out.println("\n\t\t\t\tYour cart is empty.");
            return;
        }
        System.out.println("\n\n\t\t\t\t\t===============================");
        System.out.println("\t\t\t\t\t          ORDER SUMMARY       ");
        System.out.println("\t\t\t\t\t===============================");
        System.out.printf("\t\t\t\t%-15s %-10s %-10s %-10s %-10s\n", "Product Name", " Product ID", "Quantity", "Price",
                "Total");
        for (Cart cart : carts) {
            if (cart.inputUserName.equals(inputUsername)) {
                double total = cart.productPrice * cart.productQuantity;
                System.out.printf("\t\t\t\t%-15s %-10s %-10d %-10.2f %-10.2f\n", cart.productName, cart.productId,
                        cart.productQuantity, cart.productPrice, total);
            }
        }
    }

    // test
    public void updateCartItemById(String productId, String inputName) {
        if (carts.isEmpty()) {
            System.out.println("\n\t\t\t\tYour cart is empty.");
            return;
        }
        boolean found = false;
        for (Cart cart : carts) {
            if (cart.productId.equals(productId) && cart.inputUserName.equals(inputName)) {
                found = true;
                System.out.println("\n\n\t\t\t\tUpdating Cart Item: " + cart.productName);
                System.out.print("\t\t\t\tEnter new quantity: ");
                int newQuantity = input.nextInt();
                cart.productQuantity = newQuantity;
                System.out.println("\n\t\t\t\tCart item updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out
                    .println("\n\t\t\t\tNo cart item found with Product ID: " + productId + " for user: " + inputName);
        }
    }
    // test

    // test
    public void deleteCartItemById(String productId, String inputName) {
        if (carts.isEmpty()) {
            System.out.println("\n\t\t\t\tYour cart is empty.");
            return;
        }

        boolean found = false;
        for (int i = 0; i < carts.size(); i++) {
            Cart cart = carts.get(i);
            if (cart.productId.equals(productId) && cart.inputUserName.equals(inputName)) {
                carts.remove(i);
                System.out.println("\n\t\t\t\tCart item with Product ID " + productId + " deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out
                    .println("\n\t\t\t\tNo cart item found with Product ID: " + productId + " for user: " + inputName);
        }
    }
    // test

    // test
    public void displayFinalBill(String inputName) {
        if (carts.isEmpty()) {
            System.out.println("\n\t\t\t\tYour cart is empty. Nothing to display.");
            return;
        }
        double totalCharge = 0;
        System.out.println("\n\n\t\t\t\t+-------------------------------------------------------------+");
        System.out.println("\t\t\t\t|                    Total Amount Of Charge                   |");
        System.out.println("\t\t\t\t+-------------------------------------------------------------+");
        System.out.println();
        System.out.println("\n\t\t\t\tName : " + inputName);
        System.out.println();
        System.out.println("\t\t\t\tYou Have Bought :");
        System.out.println("\t\t\t\t_________________");
        System.out.printf("\n\t\t\t\t%-15s %-12s %-10s %-20s\n", "Food Name", "Quantities", "Price",
                "Total Price(Taka)");
        System.out.println("\t\t\t\t-------------------------------------------------------------");

        for (Cart cart : carts) {
            if (cart.inputUserName.equals(inputName)) {
                double itemTotal = cart.productQuantity * cart.productPrice;
                totalCharge += itemTotal;
                System.out.printf("\t\t\t\t%-15s %-12d %-10.2f %2dx%.2f = %.2f\n",
                        cart.productName,
                        cart.productQuantity,
                        cart.productPrice,
                        cart.productQuantity,
                        cart.productPrice,
                        itemTotal);
            }
        }
        double discount = totalCharge * 0.10;
        double payable = totalCharge - discount;

        System.out.println("\t\t\t\t-------------------------------------------------------------");
        System.out.printf("\t\t\t\tTotal Charge      : \t%.2f Taka\n", totalCharge);
        System.out.printf("\t\t\t\tWith 10%% Discount\n\t\t\t\tYour Payable Bill Is: %.2f Taka\n", payable);
        System.out.println("\t\t\t\t       To Pay Your Bill Go To Cash Counter");
        System.out.println();
        input.nextLine();
    }
    // test

    // test
    public void cashCounter(String inputName, String number) {
        if (carts.isEmpty()) {
            System.out.println("\n\n\t\t\t\tYour cart is empty. Nothing to display.");
            return;
        }
        double totalCharge = 0;
        System.out.println("\n\n\t\t\t\t\t+-------------------------------------------------------------+");
        System.out.println("\t\t\t\t\t|                    Total Amount Of Charge                   |");
        System.out.println("\t\t\t\t\t+-------------------------------------------------------------+");
        System.out.println();
        System.out.println("\n\t\t\t\tName : " + inputName);
        System.out.println("\t\t\t\tNumber : " + number);
        System.out.println();
        System.out.println("\t\t\t\tYou Have Bought :");
        System.out.println("\t\t\t\t_________________");
        System.out.printf("\t\t\t\t%-15s %-12s %-10s %-20s\n", "Food Name", "Quantities", "Price", "Total Price(Taka)");
        System.out.println("\t\t\t\t-------------------------------------------------------------");

        for (Cart cart : carts) {
            if (cart.inputUserName.equals(inputName)) {
                double itemTotal = cart.productQuantity * cart.productPrice;
                totalCharge += itemTotal;
                System.out.printf("\t\t\t\t%-15s %-12d %-10.2f %2dx%.2f = %.2f\n",
                        cart.productName,
                        cart.productQuantity,
                        cart.productPrice,
                        cart.productQuantity,
                        cart.productPrice,
                        itemTotal);
            }
        }
        double discount = totalCharge * 0.10;
        double payable = totalCharge - discount;

        System.out.println("\t\t\t\t-------------------------------------------------------------");
        System.out.printf("\t\t\t\tTotal Charge      : %.2f Taka\n", totalCharge);
        System.out.printf("\t\t\t\tWith 10%% Discount\n\t\t\t\tYour Payable Bill Is: %.2f Taka\n", payable);
        System.out.println("\t\t\t\t        You paid : " + payable);
        System.out.println("\t\t\t\t        Changes : : 0.00 Taka");
        System.out.println("\n\t\t\t\tThank you for your Everything!\n\t\t\t\tHave a nice day!\n");
    }
    // test

    // test
    public void displayOrderedItemOfSeller(String inputUsername) {
        if (carts.isEmpty()) {
            System.out.println("\n\t\t\t\tNo Ordered Form Your Shop");
            return;
        }
        System.out.println("\n\n\t\t\t\t===============================");
        System.out.println("\t\t\t\t          ORDERED SUMMARY       ");
        System.out.println("\t\t\t\t===============================");
        System.out.printf("\t\t\t\t%-15s %-10s %-10s\n", "Product Name", " Product ID", "Quantity");
        for (Cart cart : carts) {
            if (cart.shopName.equals(inputUsername)) {
                double total = cart.productPrice * cart.productQuantity;
                System.out.printf("\t\t\t\t%-15s %-10s %-10d\n", cart.productName, cart.productId,
                        cart.productQuantity);
            }
        }
    }

    // test

    public void displayTotalSaleOfSeller(String sellerUsername) {
        boolean found = false;
        double totalSale = 0;

        System.out.println("\n\n\t\t\t\t+-------------------------------------------------------------+");
        System.out.println("\t\t\t\t|                Total Sales Report For Your Shop             |");
        System.out.println("\t\t\t\t+-------------------------------------------------------------+");
        System.out.println("\n\t\t\t\tSeller Name: " + sellerUsername);
        System.out.printf("\t\t\t\t%-15s %-12s %-10s %-20s\n", "Product Name", "Quantity", "Unit Price",
                "Total (Taka)");
        System.out.println("\t\t\t\t-------------------------------------------------------------");

        for (Cart cart : carts) {
            if (cart.shopName.equals(sellerUsername)) {
                found = true;
                double itemTotal = cart.productQuantity * cart.productPrice;
                totalSale += itemTotal;

                System.out.printf("\t\t\t\t%-15s %-12d %-10.2f %2dx%.2f = %.2f\n",
                        cart.productName,
                        cart.productQuantity,
                        cart.productPrice,
                        cart.productQuantity,
                        cart.productPrice,
                        itemTotal);
            }
        }
        if (!found) {
            System.out.println("\n\t\t\t\tNo sales found for seller: " + sellerUsername);
        } else {
            System.out.println("\t\t\t\t-------------------------------------------------------------");
            System.out.printf("\t\t\t\tTotal Sales Amount : %.2f Taka\n", totalSale);
        }

        System.out.println();
    }

    // test

}
