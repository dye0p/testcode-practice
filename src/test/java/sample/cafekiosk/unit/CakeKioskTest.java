package sample.cafekiosk.unit;

import org.junit.jupiter.api.Test;
import sample.cafekiosk.unit.beverage.Americano;

class CakeKioskTest {

    @Test
    void add() {
        CakeKiosk cakeKiosk = new CakeKiosk();

        cakeKiosk.add(new Americano());

        System.out.println(">>> 담긴 음료수 : " + cakeKiosk.getBeverages().size());
        System.out.println(">>> 담긴 음료 : " + cakeKiosk.getBeverages().get(0).getName() );
    }

}