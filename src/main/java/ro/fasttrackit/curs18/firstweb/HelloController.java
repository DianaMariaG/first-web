package ro.fasttrackit.curs18.firstweb;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hello") //zice la ce raspunde controller

public class HelloController {
    @GetMapping
    String sayHello() {
        System.out.println("calling sayHello");
        return "Hello";
    }

    @GetMapping("persons")
    List<Person> getPersons() {
        return List.of(
                new Person("ana",33),
                new Person("Dana",14)
        );
    }

    @GetMapping("/persons/{personId}")
    Person getPerson(@PathVariable int personId, @RequestParam(required = false) String name) {
        return new Person(name == null ? "Shoni" : name, personId);
    }
}
record Person(String name, int age){
}

