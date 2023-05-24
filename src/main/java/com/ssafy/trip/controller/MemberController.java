package com.ssafy.trip.controller;

import com.ssafy.trip.domain.member.Member;
import com.ssafy.trip.dto.request.*;
import com.ssafy.trip.dto.response.MemberLoginResponseDto;
import com.ssafy.trip.exception.BusinessException;
import com.ssafy.trip.exception.MaliciousAccessException;
import com.ssafy.trip.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/regist")
    public ResponseEntity<String> regist(@RequestBody MemberRegistRequestDto memberRegistRequestDto) {

        try {
            String userid = memberRegistRequestDto.getUserId();
            String userpwd = memberRegistRequestDto.getUserPwd();
            String username = memberRegistRequestDto.getUserName();
            String useremail = memberRegistRequestDto.getUserEmail();

            Member member = new Member(userid, username, useremail, 5, null);
            System.out.println(member.getUserId());
            memberService.regist(member, userpwd); // service로 보내 salt값으로 넣으러 간다

            System.out.println(member.getUserId() + " " + member.getUserPwd());
        } catch (Exception e){ // 예외처리 세분화 예정
                // 예외처리 전략
                return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request,
                                        HttpServletResponse response,
                                        @RequestBody MemberLoginRequestDto memberLoginRequestDto) {

        try {
            Member member = memberService.login(memberLoginRequestDto.getUserId(),memberLoginRequestDto.getUserPwd());

            if (member != null) {
                MemberLoginResponseDto memberLoginResponseDto = new MemberLoginResponseDto(
                        member.getUserId(),member.getUserName()
                );
                HttpSession session = request.getSession(true);
                session.setAttribute("userId",member.getUserId());
                Cookie cookie = new Cookie("userId",member.getUserId());
                cookie.setPath("/");
                Cookie cookie2 = new Cookie("userName",member.getUserName());
                cookie2.setPath("/");
                response.addCookie(cookie);
                response.addCookie(cookie2);
                return ResponseEntity.ok("success");
            }
        } catch(MaliciousAccessException e) {
            throw new MaliciousAccessException();
        }

        return ResponseEntity.ok("fail");
    }

    @GetMapping("logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            System.out.println(session.getId());
            session.invalidate();
            return ResponseEntity.ok().build();
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/duplicateId")
    public ResponseEntity<String> duplicateId(@RequestBody MemberDuplicateIdRequestDto memberDuplicateIdRequestDto) {

        if(memberService.duplicateId(memberDuplicateIdRequestDto.getUserId())) {
            return ResponseEntity.ok("Duplicate");
        }

        else {
            return ResponseEntity.ok("notDuplicate");
        }

    }
    @PostMapping("/duplicateName")
    public ResponseEntity<String> duplicateName(@RequestBody MemberDuplicateNameRequestDto memberDuplicateNameRequestDto) {

        if(memberService.duplicateName(memberDuplicateNameRequestDto.getUserName())) {
            return ResponseEntity.ok("Duplicate");
        }

        else {
            return ResponseEntity.ok("notDuplicate");
        }

    }
    @PostMapping("/duplicateEmail")
    public ResponseEntity<String> duplicateEmail(@RequestBody MemberDuplicateEmailRequestDto memberDuplicateEmailRequestDto) {

        if(memberService.duplicateEmail(memberDuplicateEmailRequestDto.getUserEmail())) {
            return ResponseEntity.ok("Duplicate");
        }

        else {
            return ResponseEntity.ok("notDuplicate");
        }

    }

}

/*

Git branch feature/member/
Git checkout feature/member/
Git add.
Git commit -m “메시지”
Git push
(복사)
git push --set-upstream origin feature/member/login

 */