package demo.service;

import com.google.gson.Gson;
import demo.dao.UserMapper;
import demo.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserInfo getUser(String name){
        return userMapper.queryUser(name);
    }
    public UserInfo login(String name,String pw){
        return userMapper.login(name,pw);
    }
    public void register(String name,String pw){
        userMapper.register(name,pw);
    }
    public Long update(String name,String imgurl){
        return userMapper.updateUser(name,imgurl);
    }
    public Long updateLike(String name, String likeList){
        return userMapper.updateLike(name,likeList);
    }
    public String queryLike(String name){
        return userMapper.queryLike(name);
    }
}

/*    @Autowired
    private demo.dao.userDao userDao;

    public UserInfo queryUser(String name){
//        System.out.println("Service query: "+name);
        return userDao.queryUser(name);
    }
    public UserInfo getUser(String name, String pw){
//        System.out.println("Service get:  "+name+" : "+pw);
        return userDao.getUser(name,pw);
    }
    public UserInfo putUser(String name, String pw){
//        System.out.println("Service put:  "+name+" : "+pw);
        return userDao.putUser(name,pw);
    }
    public int updateUser(String name,String url){
//        System.out.println("Service update: "+name+" : "+ url);
        return userDao.updateUser(name,url);
    }

    public void setUserDao(demo.dao.userDao userDao) {
        this.userDao = userDao;
    }

    public demo.dao.userDao getUserDao() {
        return userDao;
    }*/
