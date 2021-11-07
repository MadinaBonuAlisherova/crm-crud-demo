package com.crm.crud.demo.Customer;


import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "inn")
    private String inn;

    @Column(name = "passport_id")
    private String passportId;

    public Customer() {
    }

    public Customer(String name, String status, String email, String phoneNumber, String address, String inn, String passportId) {
        this.name = name;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.inn = inn;
        this.passportId = passportId;
    }

    public Customer(String name, String status, String email, String phoneNumber, String address, String inn) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.inn = inn;
        this.passportId = passportId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", inn='" + inn + '\'' +
                ", passportId='" + passportId + '\'' +
                '}';
    }
}
