//package org.redoy;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person {
    static ArrayList<Person> customers = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    ArrayList<Order> orders = new ArrayList<>();

    public void register() {
        Customer customer = new Customer();
        try {
            System.out.println("\n\n\n\t\t\t\t\tRegister Customer");
            System.out.println("\t\t\t\t\t-----------------");
            System.out.print("\n\n\t\t\t\tEnter Customer's Name: ");
            customer.setName(input.nextLine());
            System.out.print("\t\t\t\tEnter Customer's ID: ");
            customer.setId(input.nextLine());
            System.out.print("\t\t\t\tEnter Customer's Phone: ");
            customer.setPhone(input.nextLine());
            System.out.print("\t\t\t\tEnter Customer's Email: ");
            customer.setEmail(input.nextLine());
            System.out.print("\t\t\t\tEnter Customer's Username: ");
            customer.setUserName(input.nextLine());
            System.out.print("\t\t\t\tEnter Customer's Password: ");
            customer.setPassword(input.nextLine());
            System.out.print("\t\t\t\tEnter Customer's Street: ");
            String street = input.nextLine();
            System.out.print("\t\t\t\tEnter Customer's City: ");
            String city = input.nextLine();
            System.out.print("\t\t\t\tEnter Customer's Country: ");
            String country = input.nextLine();
            Address address = new Address(street, city, country);
            customer.setAddress(address);
            customers.add(customer);
            System.out.println("\n\t\t\t\tRegistration successful!");
        } catch (Exception e) {
            System.out.println("\n\t\t\t\tThere was a problem registering the seller: " + e);
        }
    }
    public void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("\n\n\t\t\t\tNo sellers registered yet.");
            return;
        }
        System.out.printf("\n\n\t\t\t\t%-15s %-10s %-25s %-20s %-30s\n", "Name", "ID", "Email", "Username", "Address");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Person customer : customers) {
            Address address = customer.getAddress();
            String fullAddress = (address != null) ? address.displayAddress() : "Not Provided";
            System.out.printf("\t\t\t\t%-15s %-10s %-25s %-20s %-30s\n",
                    customer.getName(), customer.getId(), customer.getEmail(), customer.getUserName(),
                    fullAddress);
        }
    }

    //test
    public boolean login(String inputUsername, String inputPassword, boolean flag) {
        boolean found = false;
        for (Person customer : customers) {
            if (customer.getUserName().equals(inputUsername) && customer.getPassword().equals(inputPassword)) {
                System.out.println("\n\n\t\t\t\tLogin successful!");
                System.out.println("\n\t\t\t\tWelcome, " + customer.getName() + "!");
                flag = true;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\n\t\t\t\tLogin failed. Username or password is incorrect.");
        }
        return flag;
    }
    //test
}
