package dat3.cars.config;

import dat3.cars.entity.Member;
import dat3.cars.repositories.MemberRepository;
import jakarta.persistence.Entity;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeveloperData implements ApplicationRunner {


  MemberRepository memberRepository;

  public DeveloperData(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  private final String passwordUsedByAll = "test12";


  @Override
  public void run(ApplicationArguments args) throws Exception {
    Member m1 = new Member("member1", passwordUsedByAll, "memb1@a.dk", "Kurt", "Wonnegut", "Lyngbyvej 2", "Lyngby", "2800");
    Member m2 = new Member("member2", passwordUsedByAll, "aaa@dd.dk", "Hanne", "Wonnegut", "Lyngbyvej 2", "Lyngby", "2800");
    m1.setFavoriteCarColors(List.of("black", "white"));
    m2.setFavoriteCarColors(List.of("black", "yellow"));
    Map map = new HashMap<String, String>();
    map.put("mobile", "1234");
    map.put("mobiel2", "123123");
    m1.setPhones(map);

    memberRepository.save(m1);
    memberRepository.save(m2);
  }


}
