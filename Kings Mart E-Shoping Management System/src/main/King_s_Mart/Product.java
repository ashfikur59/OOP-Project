//package org.redoy;

public class Product {
    String productId;
    String productName;
    double productPrice;
    String productDescription;
    int productQuantity;
    String inputUserName;

    Product(){}
    public Product(String productName,String productId, double productPrice,int productQuantity, String productDescription,String inputUserName) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.inputUserName = inputUserName;
    }

}
