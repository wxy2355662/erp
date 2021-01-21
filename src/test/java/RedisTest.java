import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTest extends BaseTest{
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void demo(){

        //redisTemplate.opsForValue().set("name1","zs");
//
//        Boolean aBoolean = redisTemplate.hasKey("0:0:0:0:0:0:0:1");
//        System.out.println(aBoolean);

//        Ataff hashKey =(Ataff)redisTemplate.opsForValue().get("0:0:0:0:0:0:0:1");
//        System.out.println(hashKey);

        redisTemplate.delete("0:0:0:0:0:0:0:1");

//
//        Boolean bBoolean = redisTemplate.hasKey("0:0:0:0:0:0:0:1");
//        System.out.println(bBoolean);

    }

}
