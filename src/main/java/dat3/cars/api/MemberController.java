package dat3.cars.api;

import dat3.cars.dto.MemberRequest;
import dat3.cars.dto.MemberResponse;
import dat3.cars.entity.Member;
import dat3.cars.services.MemberService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
class MemberController {

  MemberService memberService;

  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  //ADMIN ONLY
  @GetMapping
  List<MemberResponse> getMembers(){

    return memberService.getMembers(false);
  }

  //ADMIN ???
  @GetMapping(path = "/{username}")
  MemberResponse getMemberById(@PathVariable String username) throws Exception {return null;}

  //ANONYMOUS - NEW MEMBERS AND ADMIN
  //@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @PostMapping
  MemberResponse addMember(@RequestBody dat3.cars.dto.MemberRequest body){
    return memberService.addMember(body);
  }

  //MEMBER ???
  @PutMapping("/{username}")
  ResponseEntity<Boolean> editMember(@RequestBody MemberRequest body, @PathVariable String username){
    return null;
  }

  //ADMIN ????
  @PatchMapping("/ranking/{username}/{value}")
  void setRankingForUser(@PathVariable String username, @PathVariable int value) {}

  // Security ????
  @DeleteMapping("/{username}")
  void deleteMemberByUsername(@PathVariable String username) {}

  @Getter
  @Setter
  @NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
  public class MemberRequest {
    String username;
    String email;
    String password;
    String firstName;
    String lastName;
    String street;
    String city;
    String zip;

    public static Member getMemberEntity(MemberRequest m){
      return new Member(m.username,m.getPassword(),m.getEmail(), m.firstName, m.lastName,m.getStreet(), m.getCity(), m.getZip());
    }

    // Member to MemberRequest conversion
    public MemberRequest(Member m){
      this.username = m.getUsername();
      this.password = m.getPassword();
      this.email = m.getEmail();
      this.street = m.getStreet();
      this.city = m.getCity();
      this.zip = m.getZip();
    }
  }




}
