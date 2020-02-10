package deverour.mapper;
import deverour.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginMapper {

    @Select("select * from user where username=#{userName}")
    public List<User> findPassWord(User user);

    @Select("select * from user where username = #{username} and password = #{password}")
    public User findUserByUsernameAndPassword(User user);
}


