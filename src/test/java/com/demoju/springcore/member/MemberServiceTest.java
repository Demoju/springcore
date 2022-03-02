package com.demoju.springcore.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    public void join() {
        //given
        Member member = new Member(1L, "leeminju", Grade.VIP);

        //when
        memberService.join(member);
        Member returnMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(returnMember);
    }

}