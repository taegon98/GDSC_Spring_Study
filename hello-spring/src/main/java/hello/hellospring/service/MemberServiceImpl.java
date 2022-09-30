package hello.hellospring.service;

import hello.hellospring.DAO.MemberDAO;
import hello.hellospring.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberDAO memberDAO;
   // MemberDAOImpl memberDAO = new MemberDAOImpl();

    @Override
    public Long join(Member member) {
        memberDAO.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

        memberDAO.save(member);
        return member.getId();
    }

    @Override
    public List<Member> findMembers() {
        return memberDAO.findAll();
    }
}
