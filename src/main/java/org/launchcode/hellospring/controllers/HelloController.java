package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")  // NOTE: should normally delete the extra "hello" paths from methods below to remove redundancy, but kept to "see it."
public class HelloController {

    // Now lives at /hello/hello
    // Handles request at path </hello>
//    @GetMapping("hello")
//    public String hello( ) {
//        return "Hello, Spring!";
//    }

    // Now lives at /hello/goodbye
    // Handles request at path </goodbye>
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Now lives at /hello/hello?name=LaunchCode    (or whatever query param you enter)
    // Handles request of the form /hello?name=LaunchCode
    // Must comment off lines 13-17 above to work here b/c cannot have 2 different controllers at same path ("hello")
//    @GetMapping("hello")     // USE this for GET request methods if don't need both (things default to GET if not stated)
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    // Use this for different request types
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // // Now lives at /hello/hello/{name}   {name} = whatever we type in... /LaunchCode
    // Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

//    Now lives at /hello/form
//    @GetMapping("form")
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

    //    Now lives at /hello/form
    @GetMapping("form") // ("form") requires you put <localhost:8080/form> If no ("form"), path defaults to / root <localhost:8080>
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form method = 'post' action = 'hello'>" +   // submit a POST request to /hello by adding method='post'
                "<input type = 'text' name = 'name'/>" +
//                "<input type = 'text' name = 'name'/>" +     // can duplicate input/name line for addn'l name/entry field.
                "<input type = 'submit' value = 'Greet me!'/>" +
                "</form>" +
                "</body>" +
                "</html";
    }

}
