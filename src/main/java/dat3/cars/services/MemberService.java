package dat3.cars.services;


import dat3.cars.dto.MemberRequest;
import dat3.cars.dto.MemberResponse;
import dat3.cars.entity.Member;
import dat3.cars.repositories.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

  MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public MemberResponse findMemberByUsername(String userName){
   Member member = memberRepository.findById(userName).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Member with this username does not exist"));
   MemberResponse memberResponse = new MemberResponse(member, true);
    return memberResponse;
  }

  public List<MemberResponse> getMembers(boolean includeAll) {
    List<Member> members = memberRepository.findAll();
   /* List<MemberResponse> memberResponses = new ArrayList<>();
    for (Member m: members){
      MemberResponse mr = new MemberResponse(m, true);
      memberResponses.add(mr);
    }*/
List<MemberResponse> memberResponses = members.stream().map(m->new MemberResponse(m, includeAll)).toList();
    return memberResponses;
  }

  public MemberResponse addMember(MemberRequest memberRequest){
    //Later you should add error checks --> Missing arguments, email taken etc.
    if(memberRepository.existsById(memberRequest.getUsername())){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Member with this ID already exist");
    }
    if(memberRepository.existsByEmail(memberRequest.getEmail())){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Member with this Email already exist");
    }





    Member newMember = MemberRequest.getMemberEntity(memberRequest);
    newMember = memberRepository.save(newMember);

    return new MemberResponse(newMember, false);
  }

  public ResponseEntity<Boolean> updateMember(MemberRequest body, String username){
    Member mtoUpdate = memberRepository.findById(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    mtoUpdate.setFirstName(body.getFirstName());
    mtoUpdate.setLastName(body.getLastName());

    return new ResponseEntity<Boolean>(true, HttpStatus.OK);
  }




}
