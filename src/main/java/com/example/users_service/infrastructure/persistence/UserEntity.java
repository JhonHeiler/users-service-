package com.example.users_service.infrastructure.persistence;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombres", nullable = false, length=100)
    private String firstName;

    @Column(name="apellidos", nullable = false, length=100)
    private String lastName;

    @Column(name="direccion_envio", nullable = false, length=255)
    private String shippingAddress;

    @Column(name="email", nullable = false, unique = true, length=100)
    private String email;

    @Column(name="fecha_nacimiento", nullable = false)
    private LocalDate birthDate;

    @Column(name="password", nullable = false, length=255)
    private String password;

    // Constructor sin argumentos
    public UserEntity() {}

    // Constructor con todos los campos
    public UserEntity(Long id, String firstName, String lastName, String shippingAddress, String email, LocalDate birthDate, String password) {
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
        return "UserEntity{" +
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
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(shippingAddress, that.shippingAddress) &&
                Objects.equals(email, that.email) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, shippingAddress, email, birthDate, password);
    }
}
