package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") //url 뒤에 연결해서 치는것은 getmapping
    public String createForm() {
        return "members/createMemberForm"; //templates 가서 해당 html파일 찾기
    }

    //회원 컨트롤러에서 회원을 실제 등록하는 기능
    @PostMapping(value = "/members/new") //data를 form안에 넣어서 전달할때는 postmapping
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/"; //회원가입 후 홈화면으로 돌리기
    }

    //회원 컨트롤러에서 조회 기능
    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
