package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    // Handles request at /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST}) // Use this for different request types
    public String helloWithQueryParam(@RequestParam String name, Model model) {  // Add Model object to pass data to template.
        String theGreeting = "Hello, " + name + "!";  // You can cut this line and add string value directly in () below.
        model.addAttribute("greeting", theGreeting);  // You can replace theGreeting w/ 'Hello, ' + name + '!' from line above.
        return "hello";     // Refactored this to return the name of the template "hello" from hello.html
    }

    // Handles request at /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!"); // DRY version w/ no theGreeting variable.
        return "hello";
    }

    // Handles request at /form  (or rather at localhost:8080/form)
    @GetMapping("form")  // ("form") requires you put <localhost:8080/form> If no ("form"), path defaults to / root <localhost:8080>
//    @ResponseBody  // Use to return literal String text. Otherwise, not needed w/ templates b/c string template name assumed.
    public String helloForm() {
        return "form";  //  the name of the form.html template file to tell it where to go to find the form html info.
    }

    // Handles request at /hello-names
    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> theNames = new ArrayList<>();
        theNames.add("LaunchCode");
        theNames.add("Java");
        theNames.add("JavaScript");
        model.addAttribute("names", theNames);
        return "hello-list";
    }
}
