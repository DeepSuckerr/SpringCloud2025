import com.wsj.UserProviderAlibaba9002;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;


@SpringBootTest(classes = UserProviderAlibaba9002.class) // <--- 指定主启动类
public class TestRedisTemplate {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void setString(){
        redisTemplate.opsForValue().set("uAge","100");

    }
    // 右压栈:后添加的对象排在后边
    @Test //List集合的存值 rightPush()
    public void testSetListValue1() {
        redisTemplate.opsForList().rightPush("nameList1", "刘备");
        redisTemplate.opsForList().rightPush("nameList1", "关羽");
        redisTemplate.opsForList().rightPush("nameList1", "ldk");

    }


    //显示右压栈集合
    @Test // List集合的取值
    public void testGetListValue1() {
        // List list =redisTemplate.opsForlist().range("nameList1"，0，10);
        List list = redisTemplate.opsForList().range("nameList1", 0, -1);
        System.out.println(list);
    }



    /**
     * 左压栈:先添加的对象排在后边
     */
    @Test //List集合的存值 leftPush()
    public void testSetValue2() {
        redisTemplate.opsForList().leftPush("nameList2", "刘备");
        redisTemplate.opsForList().leftPush("nameList2", "关羽");
        redisTemplate.opsForList().leftPush("nameList2", "张飞");

    }

    //删除健
    @Test // 删除List集合的键
    public void deleteKey() {
        redisTemplate.delete("nameList2");

    }

    @Test
    public void testIndex() {
        String name = (String) redisTemplate.opsForList().index("nameList2", 0);
        System.out.println(name);

    }

    @Test
    public void testHashSet() {
        redisTemplate.opsForList().leftPush("nameHash","name","唐僧");
        redisTemplate.opsForList().leftPush("nameHash","name", "孙悟空");
        redisTemplate.opsForList().leftPush("nameHash","name", "猪八戒");
        redisTemplate.opsForList().leftPush("nameHash","name", "沙和尚");

    }

    @Test  // 添加set集合数据
    public void setSetValue() {
        redisTemplate.opsForSet().add("nameset", "操作");

        redisTemplate.opsForSet().add("nameset", "刘备");

        redisTemplate.opsForSet().add("nameset", "孙权");
    }

    @Test //获取set集合指定key 的值
    public void getSetValue(){
        Set set = redisTemplate.opsForSet().members("nameset");
        System.out.println(set);
    }

    @Test //删除 set集合指定value 的值
    public void deleteValue(){
        redisTemplate.opsForSet().remove("nameset","孙权");
    }

    // 删除整个集合
    @Test // 删除set中指定key 的数据 清空集合
    public void deleteAllSet(){
        redisTemplate.delete("nameset");
    }

}
