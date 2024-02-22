package com.learningjspring.course.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static OrderStatus valeuOf(int code) {
        for(OrderStatus v : OrderStatus.values()) {
            if(v.getCode() == code) {
                return v;
            }
        }
        throw new IllegalArgumentException("ERROR! Invalid code!");
    }
}
