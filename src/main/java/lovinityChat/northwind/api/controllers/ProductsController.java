package lovinityChat.northwind.api.controllers;

import lovinityChat.northwind.business.abstracts.ProductService;
import lovinityChat.northwind.core.utilities.results.DataResult;
import lovinityChat.northwind.core.utilities.results.Result;
import lovinityChat.northwind.entities.concretes.Product;
import lovinityChat.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("getall")
    public DataResult<List<Product>> GetAll(
            @RequestParam(required = false) Integer pageNo, @RequestParam(required = false) Integer pageSize) {

        if (pageNo != null && pageSize != null) {
            return productService.GetAll(pageNo, pageSize);
        }
        return productService.GetAll();
    }

    @GetMapping("getAllSorted")
    public DataResult<List<Product>> GetAllSorted() {
        return productService.GetAllSorted();
    }

    @GetMapping("getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> GetProductWithCategoryDetails() {
        return productService.getProductWithCategoryDetails();
    }

    @PostMapping("add")
    public Result Add(@RequestBody Product product) {
        return productService.Add(product);
    }

    @GetMapping("getByProductName")
    public DataResult<Product> GetByProductName(@RequestParam String productName) {
        return productService.getByProductName(productName);
    }

    @GetMapping("getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName, int categoryId) {
        return productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return productService.getByProductNameContains(productName);
    }
}
