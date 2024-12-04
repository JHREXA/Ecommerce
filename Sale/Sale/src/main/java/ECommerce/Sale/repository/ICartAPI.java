package ECommerce.Sale.repository;

import ECommerce.Sale.dto.CartDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "Cart")
@CircuitBreaker(name = "Cart", fallbackMethod = "fallbackFindCart")
@Retry(name = "Cart")
public interface ICartAPI {
    @GetMapping("/cart")
    public CartDTO findCartSale(@RequestParam("idSale") Long idSale);


    default CartDTO fallbackFindCart (Long idSale, Throwable throwable){
        CartDTO errorCart = new CartDTO(0L, 0.0, 0L);
        return errorCart;
    }
}
