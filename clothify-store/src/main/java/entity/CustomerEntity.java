package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")

public class CustomerEntity {

    @Id
    String customerId;
    String name;
    String email;
    String contactNumber;

    public CustomerEntity(String customerId, String name, String email, String contactNumber) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public CustomerEntity() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
