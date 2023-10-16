package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    int prodId;
    String name;
    double unitPrice;
    int qtyOnHand;
    String type;
}
