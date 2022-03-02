package com.demoju.springcore.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
