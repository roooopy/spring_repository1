package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //웹어플리케이션에서 /hello가 들어오면, 이 메서드 호출!
    public String hello(Model model){ //data는 model을 넘기면서, templates 폴더 안에 있는 hello파일 실행시켜
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    } // http://localhost:8080/hello-mvc?name=spring!!!!! 이런 get 방식으로 파라미터 넘겨줘야함

    @GetMapping("hello-string")
    @ResponseBody //http body부에 return부 내용을 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); //responsebody -> 객체가 왔네..json 방식으로 응답하자
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name; //key는 name
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }
}
