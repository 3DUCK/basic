package com.example.basic.boundedContext.member.controller;

import com.example.basic.boundedContext.base.reData.RsData;
import com.example.basic.boundedContext.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController() {
        memberService = new MemberService();
    }


    @GetMapping("/member/login")
    @ResponseBody
    public RsData login(String username, String password) {

        return memberService.tryLogin(username, password);

    }

}
