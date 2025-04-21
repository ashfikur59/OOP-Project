//package org.redoy;

public class Cart {
    String productId;
    String productName;
    double productPrice;
    String productDescription;
    int productQuantity;
    String inputUserName;
    String shopName;

    Cart(String productId, String productName, double productPrice, String productDescription, int productQuantity, String inputUserName,String shopName) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.inputUserName = inputUserName;
        this.shopName = shopName;
    }
    Cart() {
    }
}
