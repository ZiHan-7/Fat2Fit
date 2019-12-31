package fat2fit.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * PublicController
 */
@RestController
public class PublicController {

    @GetMapping(value="/")
    String index() {
        return "Hello world";
    }
}
   
