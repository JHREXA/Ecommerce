package ECommerce.Sale.service;

import ECommerce.Sale.dto.CartDTO;
import ECommerce.Sale.model.Sale;
import ECommerce.Sale.repository.ICartAPI;
import ECommerce.Sale.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements ISaleService{

    @Autowired
    private ISaleRepository repository;

    @Autowired
    private ICartAPI cartAPI;

    @Override
    public void saveSale(Sale sale) {
        this.repository.save(sale);
    }

    @Override
    public List<Sale> findAllSales() {
        return this.repository.findAll();
    }

    @Override
    public Sale findSaleById(Long idSale) {
        return this.repository.findById(idSale).orElse(null);
    }

    @Override
    public CartDTO findCartSale(Long idSale) {
        return this.cartAPI.findCartSale(idSale);
    }

    @Override
    public void deleteSaleById(Long idSale) {
        this.repository.deleteById(idSale);
    }

    @Override
    public void editSale(Long idSale, Sale sale) {
        Sale currentSale = this.findSaleById(idSale);

        if(currentSale != null){
            currentSale.setDate(sale.getDate());
            currentSale.setIdCart(sale.getIdCart());

            this.saveSale(currentSale);
        }
    }
}
