package lovinityChat.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithCategoryDto {
    private int productId;
    private String productName;
    private String categoryName;
}
