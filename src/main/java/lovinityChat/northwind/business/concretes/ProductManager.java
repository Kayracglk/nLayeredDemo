package lovinityChat.northwind.business.concretes;

import lovinityChat.northwind.business.abstracts.ProductService;
import lovinityChat.northwind.core.utilities.results.DataResult;
import lovinityChat.northwind.core.utilities.results.Result;
import lovinityChat.northwind.core.utilities.results.SuccessDataResult;
import lovinityChat.northwind.core.utilities.results.SuccessResult;
import lovinityChat.northwind.dataAccess.abstracts.ProductDao;
import lovinityChat.northwind.entities.concretes.Product;
import lovinityChat.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductManager implements ProductService {

    private final ProductDao productDao;

    @Autowired // Singleton
    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> GetAll() {
        return new SuccessDataResult<List<Product>>(productDao.findAll(), "Data Listed");
    }

    @Override
    public DataResult<List<Product>> GetAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent(), "Data Listed");
    }

    @Override
    public DataResult<List<Product>> GetAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        return new SuccessDataResult<List<Product>>(productDao.findAll(sort), "Data Listed");
    }

    @Override
    public Result Add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Data Added");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(productDao.getByProductName(productName), "Data Listed");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data Listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data Listed");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(productDao.getByCategory_CategoryIdIn(categories), "Data Listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameContains(productName), "Data Listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameStartsWith(productName), "Data Listed");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryID) {
        return new SuccessDataResult<List<Product>>(productDao.getByNameAndCategory(productName, categoryID), "Data Listed");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(productDao.getProductWithCategoryDetails(), "Data Listed");
    }
}
