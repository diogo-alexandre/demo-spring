package com.example.demospring.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPER(3),
    DELIVERED(4),
    CANCELED(5);

    private final int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus order : OrderStatus.values()) {
            if (order.getCode() == code) return order;
        }

        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
