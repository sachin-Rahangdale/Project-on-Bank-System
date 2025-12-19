package model;

import util.IdGenerator;

public class User {
    private String userId;
    private String mobileNo;
    private String name;
    private String address;
    private String email;
    IdGenerator id = new IdGenerator();


    public User(String mobileNo, String name, String address, String email) {
        this.mobileNo = mobileNo;
        this.name = name;
        this.address = address;
        this.email = email;
        this.userId= id.generateUserId();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
               ", userId='" + userId + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
