package demo.dao;

import com.google.gson.Gson;
import demo.pojo.Book;
import demo.pojo.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {
    UserInfo queryUser(String name);
    UserInfo login(@Param("name") String name, @Param("password") String password);
    void register(@Param("name") String name, @Param("password") String password);
    Long updateUser(@Param("name") String name, @Param("url") String imgUrl);
    Long updateLike(@Param("name")String name, @Param("likeList")String likeList);
    String queryLike(String name);
}
