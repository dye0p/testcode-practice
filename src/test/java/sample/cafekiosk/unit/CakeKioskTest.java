package sample.cafekiosk.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.cafekiosk.unit.beverage.Americano;
import sample.cafekiosk.unit.beverage.Latte;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CakeKioskTest {

    @Test
    void add_menual_test() {
        CakeKiosk cakeKiosk = new CakeKiosk();
        cakeKiosk.add(new Americano());

        System.out.println(">>> 담긴 음료수 : " + cakeKiosk.getBeverages().size());
        System.out.println(">>> 담긴 음료 : " + cakeKiosk.getBeverages().get(0).getName());
    }

    @DisplayName("음료를 1개 추가하면 주문목록에 담긴다")
    @Test
    void add() {
        CakeKiosk cakeKiosk = new CakeKiosk();
        cakeKiosk.add(new Americano());

        assertThat(cakeKiosk.getBeverages()).hasSize(1);
        assertThat(cakeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    void addSeveralBeverages() {
        CakeKiosk cakeKiosk = new CakeKiosk();
        Americano americano = new Americano();

        //해피 케이스
        cakeKiosk.add(americano, 2);

        assertThat(cakeKiosk.getBeverages().get(0)).isEqualTo(americano);
        assertThat(cakeKiosk.getBeverages().get(1)).isEqualTo(americano);
    }

    @Test
    void addZeroBeverages() {
        CakeKiosk cakeKiosk = new CakeKiosk();
        Americano americano = new Americano();

        //예외 케이스
        assertThatThrownBy(() -> cakeKiosk.add(americano, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음료는 1잔 이상 주문 하실 수 있습니다");
    }

    @Test
    void remove() {
        CakeKiosk cakeKiosk = new CakeKiosk();
        Americano americano = new Americano();

        cakeKiosk.add(americano);
        assertThat(cakeKiosk.getBeverages()).hasSize(1);

        //제거 테스트
        cakeKiosk.remove(americano);
        assertThat(cakeKiosk.getBeverages()).isEmpty();
    }

    @Test
    void clear() {
        CakeKiosk cakeKiosk = new CakeKiosk();

        Americano americano = new Americano();
        Latte latte = new Latte();

        cakeKiosk.add(americano);
        cakeKiosk.add(latte);
        assertThat(cakeKiosk.getBeverages()).hasSize(2);

        //제거 테스트
        cakeKiosk.clear();
        assertThat(cakeKiosk.getBeverages()).isEmpty();
    }

    @DisplayName("주문목록에 담긴 상품들의 총 가격을 계산할 수 있다.")
    @Test
    void calculateTotalPrice() {
        //given
        CakeKiosk cakeKiosk = new CakeKiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();

        cakeKiosk.add(americano);
        cakeKiosk.add(latte);

        //when
        int totalPrice = cakeKiosk.calculateTotalPrice();

        //then
        assertThat(totalPrice).isEqualTo(8500);
    }

    @Test
    void createOrderWithCurrentTime() {
        CakeKiosk cakeKiosk = new CakeKiosk();
        Americano americano = new Americano();
        cakeKiosk.add(americano);

        //경계값 테스트
        Order order = cakeKiosk.createOrder(LocalDateTime.of(2024, 7, 23, 10, 0));

        assertThat(order.getBeverages()).hasSize(1);
        assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    void createOrderOutSideOpenTime() {
        CakeKiosk cakeKiosk = new CakeKiosk();
        Americano americano = new Americano();
        cakeKiosk.add(americano);

        //경계값 예외 테스트
        assertThatThrownBy(() -> cakeKiosk.createOrder(LocalDateTime.of(2024, 7, 23, 9, 59)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문 시간이 아닙니다. 관리자에게 문의하세요.");
    }
}