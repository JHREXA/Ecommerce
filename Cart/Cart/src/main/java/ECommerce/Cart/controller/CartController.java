package ECommerce.Cart.controller;

import ECommerce.Cart.dto.ProductDTO;
import ECommerce.Cart.model.Cart;
import ECommerce.Cart.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService service;

    @GetMapping("/findall")
    public List<Cart> findAllCarts(){
        return this.service.findAllCarts();
    }

    @GetMapping("/findone")
    public Cart findCartById(@RequestParam Long idCart){
        return this.service.findCartById(idCart);
    }

    @GetMapping("/products")
    public List<ProductDTO> findCartProducts(@RequestParam Long idCart){
       return this.service.findCartProducts(idCart);
    }

    @GetMapping("")
    public Cart findCartBySaleId(@RequestParam Long idSale){
        return this.service.findCartBySaleId(idSale);
    }

    @PostMapping("/create")
    public String createCart(@RequestBody Cart cart){
        this.service.saveCart(cart);

        return "Cart created successfully";
    }

    @DeleteMapping("/delete")
    public String deleteCartById(@RequestParam Long idCart){
        this.service.deleteCartById(idCart);

        return "Cart deleted successfully";
    }

    @PutMapping("/edit")
    public String editCart(@RequestParam Long idCart, Cart cart){
        this.service.editCart(idCart, cart);

        return "Cart edited successfully";
    }
}
