package lovinityChat.northwind.business.abstracts;

import lovinityChat.northwind.core.utilities.results.DataResult;
import lovinityChat.northwind.core.utilities.results.Result;
import lovinityChat.northwind.entities.concretes.Product;
import lovinityChat.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> GetAll();
    DataResult<List<Product>> GetAll(int pageNo, int pageSize);
    DataResult<List<Product>> GetAllSorted();
    Result Add(Product product);

    DataResult<Product> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);
    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryID);
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
