package com.demoju.springcore;

import com.demoju.springcore.member.Grade;
import com.demoju.springcore.member.Member;
import com.demoju.springcore.member.MemberService;
import com.demoju.springcore.member.MemberServiceImpl;
import com.demoju.springcore.order.Order;
import com.demoju.springcore.order.OrderService;
import com.demoju.springcore.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();;
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "demoju", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "Success", 20000);

        System.out.println("ORDER : " + order.toString());
        System.out.println("ORDER Ca: " + order.calculatePrice());

    }
}
