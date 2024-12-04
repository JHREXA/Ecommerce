package ECommerce.Product.service;

import ECommerce.Product.model.Product;

import java.util.List;

public interface IProductService {

    void saveProduct(Product product);

    Product findProductById(Long idProduct);

    List<Product> findAllProducts();

    void deleteProduct(Long idProduct);

    void editProduct(Long idProduct, Product product);

    List<Product> findCartProducts(Long idCart);
}
