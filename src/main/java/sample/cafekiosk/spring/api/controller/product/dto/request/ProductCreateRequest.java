package sample.cafekiosk.spring.api.controller.product.dto.request;

import lombok.Builder;
import lombok.Getter;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.ProductType;

@Getter
public class ProductCreateRequest {

    private ProductType type;
    private ProductSellingStatus sellingStatus;
    private String name;
    private int price;

    @Builder
    public ProductCreateRequest(String name, int price, ProductSellingStatus sellingStatus, ProductType type) {
        this.name = name;
        this.price = price;
        this.sellingStatus = sellingStatus;
        this.type = type;
    }

    public Product toEntity(String nextProductNumber) {
        return Product.builder()
                .type(type)
                .name(name)
                .price(price)
                .sellingStatus(sellingStatus)
                .productNumber(nextProductNumber)
                .build();
    }
}
