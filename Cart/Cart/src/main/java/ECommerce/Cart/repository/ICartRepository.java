package ECommerce.Cart.repository;

import ECommerce.Cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface ICartRepository extends JpaRepository<Cart,Long> {

    @Query("SELECT c FROM Cart WHERE c.idSale = :idSale")
    Cart findCartSale(@RequestParam ("idSale") Long idSale);
}
