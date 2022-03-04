package com.demoju.springcore;

import com.demoju.springcore.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {


    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "leeminju", Grade.VIP);

        memberService.join(member);

        Member returnMember = memberService.findMember(1L);

        System.out.println("Member Name : " + member.getName());
        System.out.println("Result Member Name : " + returnMember.getName());
    }
}
