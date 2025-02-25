package com.example.users_service.application.dto;

import java.time.LocalDate;
import java.util.Objects;

public class UserRegistrationDTO {
    private String firstName;
    private String lastName;
    private String shippingAddress;
    private String email;
    private LocalDate birthDate;
    private String password;

    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(String firstName, String lastName, String shippingAddress, String email, LocalDate birthDate, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.shippingAddress = shippingAddress;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
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
        return "UserRegistrationDTO{" +
                "firstName='" + firstName + '\'' +
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
        UserRegistrationDTO that = (UserRegistrationDTO) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(shippingAddress, that.shippingAddress) &&
                Objects.equals(email, that.email) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, shippingAddress, email, birthDate, password);
    }
}
