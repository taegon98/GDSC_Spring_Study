package hello.hellospring.service;

import hello.hellospring.entity.Member;

import java.util.List;

public interface MemberService {
    Long join(Member member);
    List<Member> findMembers();
}
