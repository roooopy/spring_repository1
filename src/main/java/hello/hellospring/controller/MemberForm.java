package hello.hellospring.controller;

public class MemberForm {
    private String name; //createMemberForm.html 의 name이 매칭되어서 들어옴
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
