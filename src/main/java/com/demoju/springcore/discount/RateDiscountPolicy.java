package com.demoju.springcore.discount;

import com.demoju.springcore.member.Grade;
import com.demoju.springcore.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountRateAmount = 10; //10% 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountRateAmount / 100 ;
        } else {
            return 0;
        }
    }
}
