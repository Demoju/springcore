package com.demoju.springcore.member;

import com.demoju.springcore.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService = null;

    @BeforeEach
    void BeforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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