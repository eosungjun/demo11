package com.example.demo11.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo11.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

    //로그인 페이지로 이동 
    @GetMapping("/login")
    public void getMethodName() {
        
    }
    
    //로그인 처리
    @PostMapping("/loginAction")
    public String postMethodName(MemberDto member) {
       
       log.info("id:"+member.getId());
       log.info("pw:"+member.getPw()); 
        //member/loginAction 
        log.info("/member/loginAction");
        return "/member/login";
    }
    






}
