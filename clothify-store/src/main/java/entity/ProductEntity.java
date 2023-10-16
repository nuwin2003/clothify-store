package entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String prodId;
    String name;
    double unitPrice;
    int qtyOnHand;
    String type;

    public ProductEntity() {
    }

    public ProductEntity(String prodId, String name, double unitPrice, int qtyOnHand, String type) {
        this.prodId = prodId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
        this.type = type;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
