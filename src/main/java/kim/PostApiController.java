package kim;
import kim.dto.PostsResponseDto;
import kim.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.posts.PostsService;


@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;
    @PostMapping("/api/v1/posts/{id}")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }
}
