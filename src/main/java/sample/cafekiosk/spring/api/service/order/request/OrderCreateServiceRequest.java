package sample.cafekiosk.spring.api.service.order.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class OrderCreateServiceRequest {

    private List<String> productNumber;

    @Builder
    public OrderCreateServiceRequest(List<String> productNumber) {
        this.productNumber = productNumber;
    }
}
