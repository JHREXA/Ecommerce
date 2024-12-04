package ECommerce.Product.controller;

import ECommerce.Product.model.Product;
import ECommerce.Product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService service;

    @PostMapping("/create")
    public String createProduct(@RequestBody Product product){
        this.service.saveProduct(product);

        return "Product created successfully";
    }

    @GetMapping("/getall")
    public List<Product> getAllProducts(){
       return this.service.findAllProducts();
    }

    @GetMapping("/find")
    public Product findProductById(@RequestParam Long idProduct){
        return this.service.findProductById(idProduct);
    }

    @GetMapping("")
    public List<Product> findCartProducts(@RequestParam Long idCart){
       return this.service.findCartProducts(idCart);
    }

    @DeleteMapping("/delete")
    public String deleteProductById(@RequestParam Long idProduct){
        this.service.deleteProduct(idProduct);

        return "Product deleted successfully";
    }

    @PutMapping("/edit")
    public String editProductById(@RequestParam Long idProduct, Product product){
        this.service.editProduct(idProduct,product);

        return "Product edited successfully";
    }
}
