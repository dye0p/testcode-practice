package sample.cafekiosk.spring.api.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.cafekiosk.spring.api.controller.order.request.OrderCreateRequest;
import sample.cafekiosk.spring.api.service.order.response.OrderResponse;
import sample.cafekiosk.spring.domain.order.Order;
import sample.cafekiosk.spring.domain.order.OrderRepository;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderSerivce {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderResponse creatOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumber = request.getProductNumber();

        List<Product> products = productRepository.findAllByProductNumberIn(productNumber);

        Order order = Order.create(products, registeredDateTime);
        Order savedOrder = orderRepository.save(order);

        return OrderResponse.of(savedOrder);
    }


}
