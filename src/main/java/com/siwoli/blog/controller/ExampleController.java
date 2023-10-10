package com.siwoli.blog.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ExampleController {
    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model) {
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("siwoli");
        examplePerson.setAge(4);
        examplePerson.setHobbies(List.of("운동", "독서"));

        //"person"이라는 키로 Person객체를 모델 객체에 저장
        model.addAttribute("person", examplePerson);
        model.addAttribute("today", LocalDate.now());
        
        return "example";//example.html라는 뷰 조회
    }

    @Setter
    @Getter
    class Person {
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }
}
