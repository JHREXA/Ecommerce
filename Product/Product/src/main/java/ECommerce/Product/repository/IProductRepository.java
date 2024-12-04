package ECommerce.Product.repository;

import ECommerce.Product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product WHERE p.idCart = :idCart")
    List<Product>findCartProducts(@RequestParam ("idCart") Long idCart);
}
