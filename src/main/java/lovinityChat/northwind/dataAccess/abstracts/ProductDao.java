package lovinityChat.northwind.dataAccess.abstracts;

import lovinityChat.northwind.entities.concretes.Product;
import lovinityChat.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> { // Integer is product's primary key
    Product getByProductName(String productName);

    // Nested property kullanarak category.categoryId üzerinden
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

    // String işlemleri
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);

    // Custom JPQL Query
    @Query("SELECT p FROM Product p WHERE p.productName = :productName AND p.category.categoryId = :categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryID);
    // select * from products where product_name = ... and category_id = ...

    @Query("SELECT new lovinityChat.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) FROM Category c inner join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
    // SELECT p.productId, p.productName, c.categoryId FROM Category c inner join Product p on c.categoryId = p.categoryId
}
