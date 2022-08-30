package cn.cvzhanshi.wechatpush;

import cn.cvzhanshi.wechatpush.config.Pusher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WechatpushApplicationTests {

    @Test
    void contextLoads() {
//        Pusher.push();
        Pusher.pushevening();
    }

}
