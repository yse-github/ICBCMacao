package org.test;

import java.math.BigDecimal;

/**
 * 优惠券类
 */
public class Coupon {

    //可用条件（满足使用条件的最低金额）
    private BigDecimal availableConditions;
    //优惠金额（所能在总价基础上减去的金额）
    private BigDecimal discountAmount;
    //是否可叠加
    private boolean StackableFlag;

    public Coupon() {
    }

    public Coupon(BigDecimal availableConditions, BigDecimal discountAmount, boolean stackableFlag) {
        this.availableConditions = availableConditions;
        this.discountAmount = discountAmount;
        StackableFlag = stackableFlag;
    }

    public BigDecimal getAvailableConditions() {
        return availableConditions;
    }

    public void setAvailableConditions(BigDecimal availableConditions) {
        this.availableConditions = availableConditions;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public boolean isStackableFlag() {
        return StackableFlag;
    }

    public void setStackableFlag(boolean stackableFlag) {
        StackableFlag = stackableFlag;
    }
}
