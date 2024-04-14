package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원이 저장소에 저장
    Optional<Member> findById(Long id); //null대신 optional로 감싸기 , 저장소에서 값 찾아오기
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 지금까지 저장된 모든 회원리스트 반환
}
