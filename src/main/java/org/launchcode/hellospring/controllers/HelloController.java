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

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello") // Use this for different request types
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
//                "<form action='hello'>" +   // submit a default GET request to /hello w/ no method= declared.
//                "<input type='text' name='name'>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html";
//    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +   // submit a POST request to /hello by adding method='post'
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html";
    }
}