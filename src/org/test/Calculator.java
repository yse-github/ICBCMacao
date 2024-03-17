package org.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 计算器类，用于计算购物车最终金额
 */
public class Calculator {

    //购物车，用于保存顾客所挑选的水果
    private List<Fruit> shoppingCart = new ArrayList<>();
    //优惠券集合
    private List<Coupon> couponList = new ArrayList<>();
    //计算得到的最终金额
    private BigDecimal result = new BigDecimal(0);

    public Calculator() {
    }

    public Calculator(List<Fruit> shoppingCart, List<Coupon> couponList, BigDecimal result) {
        this.shoppingCart = shoppingCart;
        this.couponList = couponList;
        this.result = result;
    }

    public List<Fruit> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<Fruit> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    /**
     * 校验传入数据正确性，水果斤数是否为整数
     */
    public void validData(List<Fruit> shoppingCart) {
        if (shoppingCart == null || shoppingCart.size() == 0) {
            throw new RuntimeException("购物车列表为空，请添加商品后进行计算");
        }
        for (Fruit fruit : shoppingCart) {
            if (fruit == null) {
                throw new RuntimeException("请正确添加水果");
            }
            if (fruit.getFruitAmount() < 0 ) {
                throw new RuntimeException("请正确添加水果数量，水果数量为大于等于0的整数");
            }
            try {
                Integer fruitAmount = Integer.valueOf(fruit.getFruitAmount());
            }catch (Exception e) {
                throw new RuntimeException("请正确添加水果数量，水果数量为大于等于0的整数");
            }
        }

    }

    /**
     * 添加水果商品到购物车
     */
    public void addToShoppingCart(List<Fruit> shoppingCart) {
        validData(shoppingCart);
        this.shoppingCart.addAll(shoppingCart);
    }

    public void addToCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }


    /**
     * 计算总金额
     */
    public void calculateResult() {
        //校验水果斤数是否为大于等于0的整数
        validData(this.shoppingCart);
        //计算购物车中每类水果累加金额
        for (Fruit fruit : this.shoppingCart) {
            this.result = this.result.add(fruit.getFruitPrice().multiply(fruit.getFruitDiscount()).multiply(BigDecimal.valueOf(fruit.getFruitAmount())));
        }
        //计算优惠券是否满足使用条件，得到最终金额
        BigDecimal tempResult = this.result;
        for (Coupon coupon : this.couponList) {
            if (coupon.isStackableFlag() && tempResult.compareTo(coupon.getAvailableConditions()) >= 0) {
                this.result =  this.result.subtract(coupon.getDiscountAmount());
            }
        }
        this.result = this.result.setScale(2, RoundingMode.HALF_UP);
        System.out.println("购物车总金额是" + this.result);
    }

    /**
     * 清空购物车
     */
    public void clearShoppingCar() {
        this.shoppingCart.clear();
        this.couponList.clear();
        this.result = new BigDecimal(0);
    }
}
