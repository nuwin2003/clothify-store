package entity;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int supId;
    String name;
    String email;
    String contactNumber;

    public SupplierEntity() {
    }

    public SupplierEntity(int supId, String name, String email, String contactNumber) {
        this.supId = supId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public int getSupId() {
        return supId;
    }

    public void setSupId(int supId) {
        this.supId = supId;
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
