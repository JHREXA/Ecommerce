package ECommerce.Cart.service;

import ECommerce.Cart.dto.ProductDTO;
import ECommerce.Cart.model.Cart;

import java.util.List;

public interface ICartService {

    void saveCart(Cart cart);

    List<Cart> findAllCarts();

    Cart findCartById(Long idCart);

    void deleteCartById(Long idCart);

    void editCart(Long idCart, Cart cart);

    List<ProductDTO> findCartProducts(Long idCart);

    Cart findCartBySaleId(Long idSale);
}
