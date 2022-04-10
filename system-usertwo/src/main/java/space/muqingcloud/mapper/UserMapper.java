package space.muqingcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import space.muqingcloud.entities.User;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectAll();

    User selectOne(@Param("id") Long id);

    int insert(User user);

    int update(User user);

    int delete(@Param("id") Long id);
}
