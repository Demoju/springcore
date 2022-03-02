package com.demoju.springcore;

import com.demoju.springcore.member.*;

public class MemberApp {


    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "leeminju", Grade.VIP);

        memberService.join(member);

        Member returnMember = memberService.findMember(1L);

        System.out.println("Member Name : " + member.getName());
        System.out.println("Result Member Name : " + returnMember.getName());
    }
}
