package entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String empId;
    String empName;
    String email;
    String contactNumber;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String empId, String empName, String email, String contactNumber) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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
