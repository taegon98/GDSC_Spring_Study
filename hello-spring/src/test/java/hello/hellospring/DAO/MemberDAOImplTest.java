package hello.hellospring.DAO;

import hello.hellospring.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberDAOImplTest {
    MemberDAO memberDAO = new MemberDAOImpl();

    @Test
    void 회원가입() {
        Member member = new Member();
        member.setName("taegon");

        memberDAO.save(member);

        Member findMember = memberDAO.findById(member.getId()).get();
        Assertions.assertThat(findMember).isEqualTo(member);
    }
}