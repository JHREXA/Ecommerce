package ECommerce.Sale.service;

import ECommerce.Sale.dto.CartDTO;
import ECommerce.Sale.model.Sale;

import java.util.List;

public interface ISaleService {

    void saveSale(Sale sale);

    List<Sale> findAllSales();

    Sale findSaleById(Long idSale);

    CartDTO findCartSale(Long idSale);

    void deleteSaleById(Long idSale);

    void editSale(Long idSale, Sale sale);
}
