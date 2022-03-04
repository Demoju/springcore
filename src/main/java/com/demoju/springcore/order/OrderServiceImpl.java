package com.demoju.springcore.order;

import com.demoju.springcore.discount.DiscountPolicy;
import com.demoju.springcore.discount.RateDiscountPolicy;
import com.demoju.springcore.member.Member;
import com.demoju.springcore.member.MemberRepository;
import com.demoju.springcore.member.MemberService;
import com.demoju.springcore.member.MemberServiceImpl;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        //할인 정책을 적용하고
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
