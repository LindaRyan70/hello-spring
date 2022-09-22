package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    // Handles request at path </hello>
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello( ) {
//        return "Hello, Spring!";
//    }

    // Handles request at path </goodbye>
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye( ) {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    // Must comment off lines 13-17 above to work here b/c cannot have 2 different controllers at same path ("hello")

//    @GetMapping("hello")     // USE this for GET request methods if don't need both (things default to GET if not stated)

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST}) // Use this for different request types
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form method = 'get' action = 'hello'>" +  // submits GET request to /hello (default is GET if <method=> omitted)
//                "<input type = 'text' name = 'name'/>" +
//                "<input type = 'submit' value = 'Greet me!'/>" +
//                "</form>" +
//                "</body>" +
//                "</html";
//    }

    @GetMapping("form")  // ("form") requires you put <localhost:8080/form> If no ("form"), path defaults to / root <localhost:8080>
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form method = 'post' action = 'hello'>" +   // submit a POST request to /hello by adding method='post'
                "<input type = 'text' name = 'name'/>" +
                "<input type = 'submit' value = 'Greet me!'/>" +
                "</form>" +
                "</body>" +
                "</html";
    }
}