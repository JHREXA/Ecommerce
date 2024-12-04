package ECommerce.Cart.service;

import ECommerce.Cart.dto.ProductDTO;
import ECommerce.Cart.model.Cart;
import ECommerce.Cart.repository.ICartRepository;
import ECommerce.Cart.repository.IProductAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService{

    @Autowired
    private ICartRepository repository;

    @Autowired
    private IProductAPI productAPI;

    @Override
    public void saveCart(Cart cart) {
        this.repository.save(cart);
    }

    @Override
    public List<Cart> findAllCarts() {
        return this.repository.findAll();
    }

    @Override
    public Cart findCartById(Long idCart) {
        return this.repository.findById(idCart).orElse(null);
    }

    @Override
    public void deleteCartById(Long idCart) {
        this.repository.deleteById(idCart);
    }

    @Override
    public void editCart(Long idCart, Cart cart) {
        Cart currentCart = this.findCartById(idCart);

        if(currentCart != null){
            currentCart.setTotalAmount(cart.getTotalAmount());
            this.saveCart(currentCart);
        }
    }

    @Override
    public List<ProductDTO> findCartProducts(Long idCart) {
        return this.productAPI.findCartProducts(idCart);
    }

    @Override
    public Cart findCartBySaleId(Long idSale) {
        return this.repository.findCartSale(idSale);
    }
}
