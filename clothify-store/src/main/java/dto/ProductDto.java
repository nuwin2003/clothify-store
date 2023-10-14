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
    int unitPrice;
    int qtyOnHand;
    String type;
}
