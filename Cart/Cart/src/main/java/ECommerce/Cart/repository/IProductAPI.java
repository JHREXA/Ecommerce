package ECommerce.Cart.repository;

import ECommerce.Cart.dto.ProductDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "Product")
@CircuitBreaker(name = "Product", fallbackMethod = "fallbackFindCartProducts")
@Retry(name = "Product")
public interface IProductAPI {

    @GetMapping("/products")
    List<ProductDTO> findCartProducts(@RequestParam ("idCart") Long idCart);

    default List<ProductDTO> fallbackFindCartProducts(Long idCart, Throwable throwable){
        List<ProductDTO> errorList = new ArrayList<>();
        errorList.add(new ProductDTO(0L,"error","error",0.0, 0L));
        return errorList;
    }
}
