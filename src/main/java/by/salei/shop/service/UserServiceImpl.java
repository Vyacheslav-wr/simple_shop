package by.salei.shop.service;

import by.salei.shop.dao.api.UserDao;
import by.salei.shop.dto.UserDto;
import by.salei.shop.entity.User;
import by.salei.shop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createNewUser(UserDto userDto) {

        User user = User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .status(userDto.getStatus())
                .build();

        userDao.save(user);
    }
}
