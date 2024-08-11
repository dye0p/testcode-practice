package sample.cafekiosk.spring.api.controller.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.ProductType;

@Getter
@NoArgsConstructor
public class ProductCreateRequest {

    @NotNull(message = "상품 타입은 필수 입니다.")
    private ProductType type;

    @NotNull(message = "상품 판매 상태는 필수 입니다.")
    private ProductSellingStatus sellingStatus;

    @NotBlank(message = "상품 이름은 필수 입니다.")
    private String name;

    @Positive(message = "상품 가격은 양수여야 합니다.")
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
