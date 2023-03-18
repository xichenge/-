package Dao;

import pojo.User;

import java.util.List;

public interface UserDao {
    public User queryUserByE_mail(String e_mail);
    public Integer addUser(User user);
    public List<User> getAlluser();
    public Integer deleUser(Integer id);
    public Integer changeUserData(User user);
    public User checkUser(String username,String e_mail);
    public Integer changgePassword(User user);
    public Integer getAllUserCount();
    public List<User>pageuser(Integer currentpage,Integer pagecount);
}
