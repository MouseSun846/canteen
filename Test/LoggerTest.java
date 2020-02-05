import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/4 21:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LoggerTest.class)
public class LoggerTest {
   private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
   @Test
   public void test(){

       logger.info("info---");
       logger.error("error---");
       logger.debug("debug---");
       logger.warn("warn---");
    }
}
