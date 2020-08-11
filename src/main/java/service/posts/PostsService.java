package service.posts;
import kim.domain.posts.PostRepository;
import kim.domain.posts.posts;
import kim.dto.PostsResponseDto;
import kim.dto.PostsSaveRequestDto;
import kim.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service

public class PostsService {
  private final PostRepository postRepository;

  @Transactional
    public Long save(PostsSaveRequestDto requestDto){
      return postRepository.save(requestDto.toEntity()).getId();
  }
    public Long update(Long id, PostsUpdateRequestDto requestDto){
       posts Posts =postRepository.findById(id).orElseThrow(()->new
               IllegalArgumentException("해당 게시글이 없습니다. id=" +id));
       Posts.update(requestDto.getTitle(),requestDto.getContent());
       return id;
    }
    public PostsResponseDto findById (long id){
      posts entity = postRepository.findById(id).orElseThrow(()-> new
              IllegalArgumentException("해당 게시글이 없습니다. id="+id));
      return new PostsResponseDto(entity);

    }
}
