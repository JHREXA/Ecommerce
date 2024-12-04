package ECommerce.Product.service;

import ECommerce.Product.model.Product;
import ECommerce.Product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository repository;

    @Override
    public void saveProduct(Product product) {
        this.repository.save(product);
    }

    @Override
    public Product findProductById(Long idProduct) {
        return this.repository.findById(idProduct).orElse(null);
    }

    @Override
    public List<Product> findAllProducts() {
        return this.repository.findAll();
    }

    @Override
    public void deleteProduct(Long idProduct) {
        this.repository.deleteById(idProduct);
    }

    @Override
    public void editProduct(Long idProduct, Product product) {
        Product currentProduct = this.findProductById(idProduct);

        if(currentProduct != null){
            currentProduct.setName(product.getName());
            currentProduct.setBrand(product.getBrand());
            currentProduct.setPrice(product.getPrice());
            this.repository.save(currentProduct);
        }
    }

    @Override
    public List<Product> findCartProducts(Long idCart) {
        return this.repository.findCartProducts(idCart);
    }
}
