//package org.redoy;

public class Admin extends Person {
    @Override
    public boolean login(String inputUsername, String inputPassword, boolean flag) {
        boolean found = false;

        String adminUserName = "redoy";
        String adminPassword = "1491";
        String AdminFullName = "Ashraful Islam Redoy";
        if (adminUserName.equals(inputUsername) && adminPassword.equals(inputPassword)) {
            System.out.println("\n\n\n\t\t\t\tLogin successful!");
            // System.out.println("Welcome, Admin>> " + AdminFullName + " <<!");
            System.out.printf("\n\t\t\t\t\tWelcome, Admin>>\u001B[1m\u001B[32m \"%s\" \u001B[0m", AdminFullName);
            flag = true;
            found = true;
        }
        if (!found) {
            System.out.println("\n\n\t\t\t\tLogin failed. Username or password is incorrect.");
        }
        return flag;
    }
}
