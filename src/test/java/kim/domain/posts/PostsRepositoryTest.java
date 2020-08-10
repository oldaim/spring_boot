package kim.domain.posts;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostRepository postsRepository;
    @After // junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
           // 보통은 배포 전 전체 테스트를 수행할때 테스트간 데이터 침범을 막기위해 사용합니다.
          //  여러 테스트를 동시에 진행하면 테스트용 데이터베이스인 H2에 데이터가 그대로 남아있어
          //  다음 테스트 실행시 테스트가 실패할수도 있음
    public void cleanup(){
        postsRepository.deleteAll();
    }
    @Test
    public void store(){
        String title="테스트 게시글";
        String content ="테스트 본문";

        postsRepository.save(posts.builder() //테이블 posts에 insert/update용 쿼리를 실행합니다.
                .title(title)                 // id값이 있다면 update가 ,없다면 insert 쿼리가 실행됩니다.
                .content(content)
                .author("dgk0911@gmail.com")
                .build());
        //when
        List<posts> postsList = postsRepository.findAll(); //테이블 posts에 있는 모든 데이터를 조회해오는 메소드 입니다.
        //then
        posts Posts =postsList.get(0);
        assertThat(Posts.getTitle()).isEqualTo(title);
        assertThat(Posts.getContent()).isEqualTo(content);
    }
}
