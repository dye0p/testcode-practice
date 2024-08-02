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
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderSerivce {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderResponse creatOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbesrs = request.getProductNumber();

        //중복제거된 products를 조회
        List<Product> duplicateProducts = findProductsBy(productNumbesrs);

        Order order = Order.create(duplicateProducts, registeredDateTime);
        Order savedOrder = orderRepository.save(order);

        return OrderResponse.of(savedOrder);
    }

    private List<Product> findProductsBy(List<String> productNumbesrs) {
        List<Product> products = productRepository.findAllByProductNumberIn(productNumbesrs);

        //productNumber를 key로 product를 찾을 수 있는 Map 생성
        Map<String, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getProductNumber, p -> p));

        //productNumbers를 순회하면서 중복된 duplicateProducts 리스트 생성
        return productNumbesrs.stream()
                .map(productMap::get)
                .toList();
    }
}
