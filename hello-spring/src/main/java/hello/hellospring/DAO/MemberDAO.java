package hello.hellospring.DAO;

import hello.hellospring.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberDAO {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
