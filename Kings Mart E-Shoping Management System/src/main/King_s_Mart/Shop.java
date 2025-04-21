//package org.redoy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Shop {
    Scanner input = new Scanner(System.in);
    private String shopName;
    private String shopId;
    private String shopAddress;

    Shop() {
    }

    ArrayList<Product> products = new ArrayList<>();

    public Shop(String shopName, String shopId, String shopAddress) {
        this.shopName = shopName;
        this.shopId = shopId;
        this.shopAddress = shopAddress;
    }

    public String displayShop() {
        return shopName + " " + shopId + " " + shopAddress;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public void addProduct(String inputUsername) {
        System.out.println("\n\n\n\t\t\t\t\tAdding product");
        System.out.print("\n\t\t\t\tEnter product Name: ");
        String productName = input.nextLine();
        System.out.print("\t\t\t\tEnter product ID: ");
        String productId = input.nextLine();
        System.out.print("\t\t\t\tEnter product Price: ");
        double productPrice = input.nextDouble();
        System.out.print("\t\t\t\tEnter product Quantity: ");
        int productQuantity = input.nextInt();
        input.nextLine();
        System.out.print("\t\t\t\tEnter product Description: ");
        String productDescription = input.nextLine();
        Product product = new Product(productName, productId, productPrice, productQuantity, productDescription,
                inputUsername);
        products.add(product);
        System.out.println("\n\t\t\t\t\tProduct Added");
    }

    public void displayProducts(String inputUsername) {
        if (products.isEmpty()) {
            System.out.println("\n\n\t\t\t\tNo products to display.");
            return;
        }
        System.out.printf("\n\n\t\t\t\t%-15s %-10s %-12s %-15s %-20s%n", "ProductName", "ProductID", "ProductPrice",
                "ProductQuantity", "ProductDescription");
        for (Product product : products) {
            if (Objects.equals(inputUsername, product.inputUserName)) {
                System.out.printf("\t\t\t\t%-15s %-10s %-12.2f %-15d %-20s%n",
                        product.productName,
                        product.productId,
                        product.productPrice,
                        product.productQuantity,
                        product.productDescription);
            }
        }
    }

    public void removeProduct(String inputUsername, String productId) {
        if (products.isEmpty()) {
            System.out.println("\n\t\t\t\tNo products to remove.");
            return;
        }
        boolean found = false;
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.inputUserName.equals(inputUsername) && product.productId.equals(productId)) {
                iterator.remove();
                System.out.println("\n\n\t\t\t\tProduct with ID " + productId + " has been removed.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\n\n\t\t\t\tProduct not found or you do not have permission to delete it.");
        }
    }

    public void updateProduct(String inputUsername, String productId) {
        if (products.isEmpty()) {
            System.out.println("\n\n\t\t\t\tNo products to update.");
            return;
        }
        boolean found = false;
        for (Product product : products) {
            if (product.productId.equals(productId) && product.inputUserName.equals(inputUsername)) {
                //input.nextLine();
                System.out.println("\n\n\t\t\t\t\tUpdating product: " + product.productName);
                System.out.print("\t\t\t\tEnter new product name: ");
                product.productName = input.nextLine();
                System.out.print("\t\t\t\tEnter new product price: ");
                product.productPrice = input.nextDouble();
                System.out.print("\t\t\t\tEnter new product quantity: ");
                product.productQuantity = input.nextInt();
                input.nextLine();
                System.out.print("\t\t\t\tEnter new product description: ");
                product.productDescription = input.nextLine();
                System.out.println("\n\n\t\t\t\tProduct updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\n\n\t\t\t\tProduct not found or you don't have permission to update it.");
        }
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("\n\n\t\t\t\tNo products to display.");
            return;
        }
        System.out.printf("\n\n\t\t\t\t%-15s%-10s  %-12s %-15s %-20s%n", "ProductName", "ProductID", "ProductPrice",
                "ProductQuantity", "ProductDescription");
        for (Product product : products) {
            System.out.printf("\t\t\t\t%-15s %-10s %-12.2f %-15d %-20s%n",
                    product.productName,
                    product.productId,
                    product.productPrice,
                    product.productQuantity,
                    product.productDescription);
        }
    }

    public void customerPlaceOrder(String inputUsername) {
        Order order = new Order();
        order.placeOrder(products, inputUsername);
    }

    // test
    public void autoAddProduct(String productName, String productId, double productPrice, int productQuantity,
            String productDescription, String inputUsername) {
        Product product = new Product(productName, productId, productPrice, productQuantity, productDescription,
                inputUsername);
        products.add(product);
        // System.out.println("Product Added");
    }
    // test

}
