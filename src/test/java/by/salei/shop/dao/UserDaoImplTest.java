package by.salei.shop.dao;

import by.salei.shop.dao.api.UserDao;
import by.salei.shop.entity.User;
import by.salei.shop.entity.UserStatus;
import by.salei.shop.starter.Starter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest(classes = {Starter.class})
@RunWith(SpringRunner.class)
public class UserDaoImplTest {

    @Autowired
    UserDao userDao;

    @Test
    public void createNewUser(){

        User user = User.builder()
                .login("login")
                .password("pass")
                .role(1L)
                .status(UserStatus.UNBLOCKED)
                .build();

        userDao.save(user);

        Optional<User> user1 = userDao.getById(6L);

        Assertions.assertNotEquals(Optional.empty(), user1);
    }
}
