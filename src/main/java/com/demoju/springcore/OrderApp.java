package com.demoju.springcore;

import com.demoju.springcore.member.Grade;
import com.demoju.springcore.member.Member;
import com.demoju.springcore.member.MemberService;
import com.demoju.springcore.member.MemberServiceImpl;
import com.demoju.springcore.order.Order;
import com.demoju.springcore.order.OrderService;
import com.demoju.springcore.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "demoju", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "Success", 10000);
        System.out.println("ORDER : " + order.toString());
        System.out.println("ORDER Ca: " + order.calculatePrice());

    }
}
