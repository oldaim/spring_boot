package kim;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(controllers =Hellocontroller.class)

public class HelloControllerTest {
  @Autowired// 스프링이 관리하는 빈(Bean)을 주입 받습니다.
  private MockMvc mvc;
  @Test
    public void hello가_리턴된다() throws Exception{
      String hello ="hello";
      mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));

  }
}
