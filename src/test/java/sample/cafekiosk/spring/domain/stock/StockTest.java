package sample.cafekiosk.spring.domain.stock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StockTest {

    @DisplayName("재고의 수량이 제공된 수량보다 작은지 확인한다.")
    @Test
    void isQuantityLessThan() {
        //given
        Stock stock = Stock.create("001", 1);
        int quantity = 2;

        //when
        boolean quantityLessThan = stock.isQuantityLessThan(quantity);

        //then
        assertThat(quantityLessThan).isTrue();
    }

    @DisplayName("재고를 주어진 개수만큼 차감할 수 있다")
    @Test
    void deductQuantity() {
        //given
        Stock stock = Stock.create("001", 1);
        int deductQuantity = 1;

        //when
        stock.deductQuantity(deductQuantity);

        //then
        assertThat(stock.getQuantity()).isEqualTo(0);
    }

    @DisplayName("재고보다 많은 수량으로 차감시도하는 경우 예외가 발생한다.")
    @Test
    void deductQuantity2() {
        //given
        Stock stock = Stock.create("001", 1);
        int deductQuantity = 2;

        //when  //then
        assertThatThrownBy(() -> stock.deductQuantity(deductQuantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차감할 재고 수량이 없습니다");
    }


}