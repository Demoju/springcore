package com.demoju.springcore;

import com.demoju.springcore.discount.DiscountPolicy;
import com.demoju.springcore.discount.FixDiscountPolicy;
import com.demoju.springcore.discount.RateDiscountPolicy;
import com.demoju.springcore.member.MemberRepository;
import com.demoju.springcore.member.MemberService;
import com.demoju.springcore.member.MemberServiceImpl;
import com.demoju.springcore.member.MemoryMemberRepository;
import com.demoju.springcore.order.OrderService;
import com.demoju.springcore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
