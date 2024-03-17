package org.test;

import java.math.BigDecimal;

/**
 * 水果类，用于表示水果实体
 */
public class Fruit {

    //水果名称
    private String fruitName;
    //水果原价
    private BigDecimal fruitPrice;
    //水果折扣
    private BigDecimal fruitDiscount;
    //水果数量
    private int fruitAmount;

    public Fruit() {
    }

    public Fruit(String fruitName, BigDecimal fruitPrice, BigDecimal fruitDiscount, int fruitAmount) {
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
        this.fruitDiscount = fruitDiscount;
        this.fruitAmount = fruitAmount;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public BigDecimal getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(BigDecimal fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public BigDecimal getFruitDiscount() {
        return fruitDiscount;
    }

    public void setFruitDiscount(BigDecimal fruitDiscount) {
        this.fruitDiscount = fruitDiscount;
    }

    public int getFruitAmount() {
        return fruitAmount;
    }

    public void setFruitAmount(int fruitAmount) {
        this.fruitAmount = fruitAmount;
    }
}
