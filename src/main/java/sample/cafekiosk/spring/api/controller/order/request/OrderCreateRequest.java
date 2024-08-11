package sample.cafekiosk.spring.api.controller.order.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class OrderCreateRequest {

    @NotEmpty(message = "상품 번호 리스트는 필수 입니다.")
    private List<String> productNumber;

    @Builder
    public OrderCreateRequest(List<String> productNumber) {
        this.productNumber = productNumber;
    }
}
