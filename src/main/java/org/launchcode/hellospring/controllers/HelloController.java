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

    // Handles request at path </goodbye>     Turned off b/c not needed for this practice video.
//    @GetMapping("goodbye")
//    @ResponseBody
//    public String goodbye( ) {
//        return "Goodbye, Spring!";
//    }

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

    // Handles request at /form  (or rather at localhost:8080/form)
    @GetMapping("form")  // ("form") requires you put <localhost:8080/form> If no ("form"), path defaults to / root <localhost:8080>
//    @ResponseBody     // Do not need this when you use templates! It will ASSUME you want
    public String helloForm() {
        return "form";  //  the name of the form.html template file to tell it where to go to find the form html info.
    }
}
