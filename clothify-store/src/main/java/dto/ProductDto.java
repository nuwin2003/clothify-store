package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    String prodId;
    String name;
    double unitPrice;
    int qtyOnHand;
    String type;
}
