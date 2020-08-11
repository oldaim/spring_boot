package kim.dto;

import kim.domain.posts.posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content =entity.getContent();
        this.author=entity.getAuthor();
    }
}
