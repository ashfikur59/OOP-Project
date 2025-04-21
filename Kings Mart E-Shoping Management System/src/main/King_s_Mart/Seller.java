////package org.redoy;

import java.util.ArrayList;
import java.util.Scanner;

public class Seller extends Person {
    private Shop shop;
    static ArrayList<Person> sellers = new ArrayList<>();
    Scanner input = new Scanner(System.in);


    public void register() {
        try {
            Seller seller = new Seller();
            System.out.println("\n\n\t\t\t\t\tRegister Seller");
            System.out.print("\n\n\t\t\t\tEnter Seller's Name: ");
            seller.setName(input.nextLine());
            System.out.print("\t\t\t\tEnter Seller's ID: ");
            seller.setId(input.nextLine());
            System.out.print("\t\t\t\tEnter Seller's Phone: ");
            seller.setPhone(input.nextLine());
            System.out.print("\t\t\t\tEnter Seller's Email: ");
            seller.setEmail(input.nextLine());
            System.out.print("\t\t\t\tEnter Seller's Username: ");
            seller.setUserName(input.nextLine());
            System.out.print("\t\t\t\tEnter Seller's Password: ");
            seller.setPassword(input.nextLine());
            System.out.print("\t\t\t\tEnter Seller's Street: ");
            String street = input.nextLine();
            System.out.print("\t\t\t\tEnter Seller's City: ");
            String city = input.nextLine();
            System.out.print("\t\t\t\tEnter Seller's Country: ");
            String country = input.nextLine();
            Address address = new Address(street, city, country);
            seller.setAddress(address);
            System.out.print("\t\t\t\tEnter Seller's Shop Name: ");
            String shopName = input.nextLine();
            System.out.print("\t\t\t\tEnter Seller's Shop ID: ");
            String shopID = input.nextLine();
            System.out.print("\t\t\t\tEnter Seller's Shop Address: ");
            String shopAddress = input.nextLine();
            Shop shop = new Shop(shopName, shopID, shopAddress);
            seller.setShop(shop); // Set shop to the individual seller
            sellers.add(seller);
            System.out.println("\n\t\t\t\tRegistration successful!");
        } catch (Exception e) {
            System.out.println("\n\t\t\t\tThere was a problem registering the seller: " + e);
        }
    }

    @Override
    public boolean login(String inputUsername, String inputPassword, boolean flag) {
        boolean found = false;

        for (Person seller : sellers) {
            if (seller.getUserName().equals(inputUsername) && seller.getPassword().equals(inputPassword)) {
                System.out.println("\n\n\t\t\t\tLogin successful!");
                System.out.println("\t\t\t\tWelcome, " + seller.getName() + "!");
                flag = true;
                found = true;

                Address address = seller.getAddress();
                if (address != null) {
                    address.displayAddress();
                }
                break;
            }
        }

        if (!found) {
            System.out.println("\n\t\t\t\tLogin failed. Username or password is incorrect.");
        }

        return flag;
    }

    public void displaySellers() {
        if (sellers.isEmpty()) {
            System.out.println("\n\t\t\t\tNo sellers registered yet.");
            return;
        }

        System.out.printf("\n\t\t\t\t\t%-15s %-10s %-25s %-20s %-30s %-15s %-10s %-20s\n",
                "Name", "ID", "Email", "Username", "Address", "Shop Name", "Shop ID", "Shop Address");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Person seller : sellers) {
            Address address = seller.getAddress();
            String fullAddress = (address != null) ? address.displayAddress() : "Not Provided";

            String shopName = "Not Provided";
            String shopId = "Not Provided";
            String shopAddress = "Not Provided";

            if (seller instanceof Seller) {
                Seller actualSeller = (Seller) seller;
                Shop shop = actualSeller.getShop();

                if (shop != null) {
                    if (shop.getShopName() != null) shopName = shop.getShopName();
                    if (shop.getShopId() != null) shopId = shop.getShopId();
                    if (shop.getShopAddress() != null) shopAddress = shop.getShopAddress();
                }
            }

            System.out.printf("\t\t\t\t%-15s %-10s %-25s %-20s %-30s %-15s %-10s %-20s\n",
                    seller.getName(), seller.getId(), seller.getEmail(), seller.getUserName(),
                    fullAddress, shopName, shopId, shopAddress);
        }
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }


    //test
    public void updateSellerByUsername(String username) {
        boolean found = false;

        for (Person seller : sellers) {
            if (seller.getUserName().equals(username)) {
                found = true;

                System.out.println("\n\t\t\t\tUpdating Seller Info for Username: " + username);

                System.out.print("\n\t\t\t\tEnter new Name: ");
                seller.setName(input.nextLine());

                System.out.print("\t\t\t\tEnter new ID: ");
                seller.setId(input.nextLine());

                System.out.print("\t\t\t\tEnter new Email: ");
                seller.setEmail(input.nextLine());

                System.out.print("\t\t\t\tEnter new Username: ");
                seller.setUserName(input.nextLine());

                System.out.print("\t\t\t\tEnter new Street: ");
                String street = input.nextLine();
                System.out.print("\t\t\t\tEnter new City: ");
                String city = input.nextLine();
                System.out.print("\t\t\t\tEnter new Country: ");
                String country = input.nextLine();
                Address address = new Address(street, city, country);
                seller.setAddress(address);

                System.out.print("\t\t\t\tEnter new Shop Name: ");
                String shopName = input.nextLine();
                System.out.print("\t\t\t\tEnter new Shop ID: ");
                String shopID = input.nextLine();
                System.out.print("\t\t\t\tEnter new Shop Address: ");
                String shopAddress = input.nextLine();
                Shop shop = new Shop(shopName, shopID, shopAddress);
                seller.setShop(shop);
                System.out.println("\n\t\t\t\tSeller information updated successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("\n\t\t\t\tSeller with username \"" + username + "\" not found.");
        }
    }

    //test

    //test
    public void deleteSeller(String username) {
        boolean found = false;

        for (int i = 0; i < sellers.size(); i++) {
            if (sellers.get(i).getUserName().equals(username)) {
                sellers.remove(i);
                System.out.println("\n\n\t\t\t\tSeller with username '" + username + "' has been deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\n\t\t\t\tNo seller found with username: " + username);
        }
    }

    //test
    public void autoLoadSellers(String name, String id, String phone, String email, String username, String password, String street, String city, String country, String shopName, String shopId, String shopAddress) {
        Seller seller = new Seller();
        seller.setName(name);
        seller.setId(id);
        seller.setPhone(phone);
        seller.setEmail(email);
        seller.setUserName(username);
        seller.setPassword(password);
        Address address = new Address(street, city, country);
        seller.setAddress(address);
        Shop shop = new Shop(shopName, shopId, shopAddress);
        seller.setShop(shop);
        sellers.add(seller);
        //System.out.println("Registration successful!");
    }
    //test

}
