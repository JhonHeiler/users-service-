package com.example.users_service.domain.model;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String shippingAddress;
    private String email;
    private LocalDate birthDate;
    private String password;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String shippingAddress, String email, LocalDate birthDate, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.shippingAddress = shippingAddress;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(shippingAddress, user.shippingAddress) &&
                Objects.equals(email, user.email) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, shippingAddress, email, birthDate, password);
    }
}
