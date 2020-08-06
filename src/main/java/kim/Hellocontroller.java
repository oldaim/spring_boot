package kim;
import kim.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줍니다.
public class Hellocontroller {
    @GetMapping("/hello/dto") // HTTP 메서드인 GET의 요청을 받을수 있는 API를 만들어 줍니다.
    public String hello(){
        return "hello";
    }
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}
