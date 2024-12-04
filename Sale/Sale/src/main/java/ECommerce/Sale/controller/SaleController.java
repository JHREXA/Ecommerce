package ECommerce.Sale.controller;

import ECommerce.Sale.model.Sale;
import ECommerce.Sale.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private ISaleService service;

    @PostMapping("/create")
    public String saveSale(@RequestBody Sale sale){
        this.service.saveSale(sale);

        return "Sale done successfully";
    }

    @GetMapping("/findall")
    public List<Sale> findAllSales(){
        return this.service.findAllSales();
    }

    @GetMapping("/find")
    public Sale findSaleById(@RequestParam Long idSale){
        return this.service.findSaleById(idSale);
    }
}
