package org.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * main方法测试类
 */
public class Test {

    //苹果
    public static final String APPLE = "apple";
    //草莓
    public static final String STRAWBERRY = "strawberry";
    //芒果
    public static final String MANGO = "mango";

    public static void main(String[] args) {


        /**
         * 1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
         * 现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
         * 请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        Calculator calculator = new Calculator();
        List<Fruit> shoppingCart = new ArrayList<>();
        List<Coupon> couponList = new ArrayList<>();
        shoppingCart.add(new Fruit(APPLE, new BigDecimal(8), new BigDecimal(1), 5));
        shoppingCart.add(new Fruit(STRAWBERRY, new BigDecimal(13), new BigDecimal(1), 5));
        calculator.addToShoppingCart(shoppingCart);
        calculator.calculateResult();
        /**
         * 2、超市增加了一种水果芒果，其定价为 20 元/斤。
         * 现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
         * 请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        calculator.clearShoppingCar();
        shoppingCart.add(new Fruit(MANGO, new BigDecimal(20), new BigDecimal(1), 5));
        calculator.addToShoppingCart(shoppingCart);
        calculator.calculateResult();
        /**
         * 3、超市做促销活动，草莓限时打 8 折。
         * 现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
         * 请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        calculator.clearShoppingCar();
        shoppingCart.clear();
        shoppingCart.add(new Fruit(APPLE, new BigDecimal(8), new BigDecimal(1), 5));
        shoppingCart.add(new Fruit(STRAWBERRY, new BigDecimal(13), new BigDecimal(0.8), 5));
        shoppingCart.add(new Fruit(MANGO, new BigDecimal(20), new BigDecimal(1), 5));
        calculator.addToShoppingCart(shoppingCart);
        calculator.calculateResult();
        /**
         * 4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
         * 现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
         * 请编写函数，对于 D 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        calculator.clearShoppingCar();
        shoppingCart.clear();
        shoppingCart.add(new Fruit(APPLE, new BigDecimal(8), new BigDecimal(1), 5));
        shoppingCart.add(new Fruit(STRAWBERRY, new BigDecimal(13), new BigDecimal(0.8), 5));
        shoppingCart.add(new Fruit(MANGO, new BigDecimal(20), new BigDecimal(1), 5));
        couponList.add(new Coupon(new BigDecimal(100), new BigDecimal(10), true));
        calculator.addToCouponList(couponList);
        calculator.addToShoppingCart(shoppingCart);
        calculator.calculateResult();
    }

}
