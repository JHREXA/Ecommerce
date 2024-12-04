package ECommerce.Sale.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private Long idCart;
    private Double totalAmount;
    private Long idSale;
}
