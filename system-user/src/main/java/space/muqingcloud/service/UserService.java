package space.muqingcloud.service;

import space.muqingcloud.entities.User;

import java.util.List;

public interface UserService {
    List<User> selectAll();

    User selectOne(Long id);

    int insert(User user);

    int update(User user);

    int delete(Long id);
}
