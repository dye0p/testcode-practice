package sample.cafekiosk.spring.api.controller.order.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class OrderCreateRequest {

    private List<String> productNumber;

    @Builder
    public OrderCreateRequest(List<String> productNumber) {
        this.productNumber = productNumber;
    }
}
