package space.muqingcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import space.muqingcloud.entities.User;
import space.muqingcloud.mapper.UserMapper;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMainOperationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSearchAll() {
        List<User> userList = userMapper.selectAll();
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void testSearchOne() {
        User user = userMapper.selectOne(1L);
        System.out.println(user);
    }

    @Test
    public void testInsertOne() {
        User user = new User("mumu", "123456", "muqingcloud@gmail.com", new Date(), new Date());
        int i = userMapper.insert(user);
        System.out.println(user);
        System.out.println(i);
    }

    @Test
    public void testUpdateOne() {
        User user = new User(3L, "lyonmu", "123456", "muqingcloud@gmail.com", new Date(), new Date());
        int i = userMapper.update(user);
        System.out.println(user);
        System.out.println(i);
    }

    @Test
    public void testDeleteOne() {
        int i = userMapper.delete(3L);
        System.out.println(i);
    }
}
