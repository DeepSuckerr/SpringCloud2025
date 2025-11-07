import com.wsj.UserProviderAlibaba9002;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;


@SpringBootTest(classes = UserProviderAlibaba9002.class) // <--- 指定主启动类
public class TestRedis {
    @Test
        public void test(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("javaTeacherName","李达康");
        jedis.close();
    }
}
