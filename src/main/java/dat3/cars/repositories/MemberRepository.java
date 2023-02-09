package dat3.cars.repositories;

import dat3.cars.dto.MemberResponse;
import dat3.cars.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

  boolean existsByEmail(String email);
}
