package hello.hellospring.service;

import hello.hellospring.DAO.MemberDAOImpl;
import hello.hellospring.entity.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    MemberService memberService = new MemberServiceImpl(new MemberDAOImpl());
    
    @Test
    void 회원가입() {
        Member member = new Member();
        member.setName("taegon");

        Long memberId = memberService.join(member);

        assertThat(member.getId()).isEqualTo(memberId);
    }

    @Test
    void 중복회원검증() {
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("taegon");
        member2.setName("taegon");

        memberService.join(member1);

        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }
}