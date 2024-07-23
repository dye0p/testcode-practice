package sample.cafekiosk.unit;

import org.junit.jupiter.api.Test;
import sample.cafekiosk.unit.beverage.Americano;
import sample.cafekiosk.unit.beverage.Latte;

import static org.assertj.core.api.Assertions.assertThat;

class CakeKioskTest {

    @Test
    void add_menual_test() {
        CakeKiosk cakeKiosk = new CakeKiosk();
        cakeKiosk.add(new Americano());

        System.out.println(">>> 담긴 음료수 : " + cakeKiosk.getBeverages().size());
        System.out.println(">>> 담긴 음료 : " + cakeKiosk.getBeverages().get(0).getName() );
    }

    @Test
    void add() {
        CakeKiosk cakeKiosk = new CakeKiosk();
        cakeKiosk.add(new Americano());

        assertThat(cakeKiosk.getBeverages()).hasSize(1);
        assertThat(cakeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
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

}