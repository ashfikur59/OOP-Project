//package org.redoy;

public abstract class Person implements Account {
    private String name;
    private String id;
    private String email;
    private String userName;
    private String password;
    private String phone;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person(String name, String id, String email, String userName, String password, String phone, Address address) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean login(String inputUsername,String inputPassword,boolean flag) {
        return flag;
    }

    public void register() {
    }

    public void setShop(Shop shop) {
    }
}

