package com.demoju.springcore.order;

import com.demoju.springcore.member.Grade;
import com.demoju.springcore.member.Member;
import com.demoju.springcore.member.MemberService;
import com.demoju.springcore.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "demoju", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId, "Success", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}