package com.demoju.springcore.order;

import com.demoju.springcore.discount.DiscountPolicy;
import com.demoju.springcore.discount.FixDiscountPolicy;
import com.demoju.springcore.member.Member;
import com.demoju.springcore.member.MemberService;
import com.demoju.springcore.member.MemberServiceImpl;

public class OrderServiceImpl implements OrderService {

    private final MemberService memberService = new MemberServiceImpl();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberService.findMember(memberId);

        //할인 정책을 적용하고
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
