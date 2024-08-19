package sample.cafekiosk.spring.api.service.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sample.cafekiosk.spring.IntegrationTestSupport;
import sample.cafekiosk.spring.domain.product.ProductRepository;

import static org.assertj.core.api.Assertions.assertThat;

class ProductNumberFactoryTest extends IntegrationTestSupport {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductNumberFactory productNumberFactory;

    @DisplayName("상품이 하나도 없는경우 신규 상품의 상품 번호는 001 이다.")
    @Test
    void createNextProductNumber() {
        //given //when
        String nextProductNumber = productNumberFactory.createNextProductNumber();

        //then
        assertThat(nextProductNumber).isEqualTo("001");

    }





}