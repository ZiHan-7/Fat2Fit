import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PublicController {
    @GetMapping(value="/")
    String index() {
        return "Hello world";
    }
}