package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Lives at /hello?name=name (enter any word for = name as a query param)
    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Lives at /hello/name  (enter any word as path param)
    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // Lives at /hello/form
//    @GetMapping("form")
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
//                "<input type = 'text' name = 'name' >" +
//                "<input type = 'submit' value = 'Greet Me!' >" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }


    //  Chapter 10.5 Exercises - Modify helloForm() method.
    /* Modify your HelloController class to display a form on a GET request that asks the user
    for both their name and the language they would like to be greeted in. Include at least 5 languages,
    with English being the default.  */

    // Lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action = 'hello' method = 'post'>" + // submit a POST request to /hello
                            "<input type = 'text' name = 'name' >" +
                            "<select id='language' name='language'>" +
                                "<option value='english'>English</option>" +
                                "<option value='french'>French</option>" +
                                "<option value='italian'>Italian</option>" +
                                "<option value='spanish'>Spanish</option>" +
                                "<option value='german'>German</option>" +
                            "</select>" +
                            "<input type = 'submit' value = 'Greet Me!' >" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }


    //  Chapter 10.5 Exercises Adding New Code for when user submits the form via a POST method.
    /* When the user submits the form (via a POST request), they should be greeted in the selected language. */

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == "") {   // Book solution code (name == null), does not work/print the default "World".
            name = "World";
        }
        return createMessage(name, language);
    }

    //  Chapter 10.5 Exercises Adding New Code for when user submits the form via a POST method.
    /* Include a new public static method, createMessage, in the HelloController that takes a name as well as
    a language string. Based on the language string, you’ll display the proper greeting. */

    public static String createMessage(String n, String l) {

        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("german")) {
            greeting = "Hallo";
        }

        return greeting + " " + n;
    }


}