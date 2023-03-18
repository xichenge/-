package Impl;


import Dao.BaseDao;
import Dao.UserDao;
import JDBC.DBUtil;
import pojo.Order;
import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements UserDao {
    @Override
    public User queryUserByE_mail(String e_mail) {
        User user=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
            //获得数据库连接
            connection= DBUtil.getConnection();
            //定义sql语句
            String sql="select * from user where e_mail = ?";
            //预编译
            preparedStatement= connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setString(1,e_mail);
            //执行查询，返回结果
            rs= preparedStatement.executeQuery();
            //判断并分析结果
            if(rs.next()){
                user=new User();
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setUsername(rs.getString("username"));
                user.setGender(rs.getString("gender"));
                user.setName(rs.getString("name"));
                user.setMd5(rs.getString("md5"));
                user.setAge(rs.getInt("age"));
                user.setE_mail(rs.getString("e_mail"));
                user.setAddress(rs.getString("address"));
                user.setId(rs.getInt("id"));
                user.setTypestatus(rs.getString("typestatus"));
            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            //关闭资源
            DBUtil.close(rs,preparedStatement,connection);
        }
        return user;
    }

    @Override
    public Integer addUser(User user) {
        Integer key = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            // 得到数据库连接
            connection = DBUtil.getConnection();
            // 定义 sql 语句
            String sql = "insert into user(username,name,password,e_mail,gender,phone,address,age,md5,typestatus) VALUES (?,?,?,?,?,?,?,?,?,?)";
            // 先预编译
            pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // 设置参数
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getE_mail());
            pstmt.setString(5, user.getGender());
            pstmt.setString(6, user.getPhone());
            pstmt.setString(7, user.getAddress());
            pstmt.setInt(8, user.getAge());
            pstmt.setString(9, user.getMd5());
            pstmt.setString(10, "0");
            // 执行更新 返回受影响的行数
            int row = pstmt.executeUpdate();
            // 判段受影响的行数
            if (row > 0) {
                // 获取主键 返回主键结果集
                resultSet = pstmt.getGeneratedKeys();
                // 得到主键的值
                if (resultSet.next()) {
                    key = resultSet.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.close(resultSet, pstmt, connection);
        }
        System.out.println(key);
        return  key;
    }

    @Override
    public List<User> getAlluser() {
        String sql="select * from user";
        List<Object> params = new ArrayList<>();

        // 调用BaseDao
        List<User> users = BaseDao.queryRows(sql, params, User.class);
        return  users;
    }

    @Override
    public Integer deleUser(Integer id) {
        // 定义 sql语句
        String sql = "delete from user where id = ?";
        // 设置参数集合
        List<Object> params = new ArrayList<>();
        params.add(id);
        // 调用BaseDao
        int row = BaseDao.executeUpdate(sql, params);
        return row;
    }

    @Override
    public Integer changeUserData(User user) {
        //定义sql语句
        String sql="update user set username=?,name=?,e_mail=?,gender=?,phone=?,age=? where id=?";
        //设置参数集合
        List<Object> params=new ArrayList<>();
        params.add(user.getUsername());
        params.add(user.getName());
        params.add(user.getE_mail());
        params.add(user.getGender());
        params.add(user.getPhone());
        params.add(user.getAge());
        params.add(user.getId());
        //调用BaseDao更新方法，返回受影响行数
        int row= BaseDao.executeUpdate(sql,params);
        return row;
    }

    @Override
    public User checkUser(String username, String e_mail) {
        User user=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
            //获得数据库连接
            connection= DBUtil.getConnection();
            //定义sql语句
            String sql="select * from user where e_mail =? and username=?  ";
            //预编译
            preparedStatement= connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setString(1,e_mail);
            preparedStatement.setString(2,username);
            //执行查询，返回结果
            rs= preparedStatement.executeQuery();
            //判断并分析结果
            if(rs.next()){
                user=new User();
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setUsername(rs.getString("username"));
                user.setGender(rs.getString("gender"));
                user.setName(rs.getString("name"));
                user.setMd5(rs.getString("md5"));
                user.setAge(rs.getInt("age"));
                user.setE_mail(rs.getString("e_mail"));
                user.setAddress(rs.getString("address"));
                user.setId(rs.getInt("id"));
                user.setTypestatus(rs.getString("typestatus"));
            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            //关闭资源
            DBUtil.close(rs,preparedStatement,connection);
        }
        return user;
    }

    @Override
    public Integer changgePassword(User user) {
        //定义sql语句
        String sql="update user set password=?,md5=? where id=?";
        //设置参数集合
        List<Object> params=new ArrayList<>();
        params.add(user.getPassword());
        params.add(user.getMd5());
        params.add(user.getId());
        //调用BaseDao更新方法，返回受影响行数
        int row= BaseDao.executeUpdate(sql,params);
        return row;
    }

    @Override
    public Integer getAllUserCount() {
        String sql="select * from user";
        List<Object> params = new ArrayList<>();

        // 调用BaseDao
        List<User> users = BaseDao.queryRows(sql, params, User.class);
        return  users.size();
    }

    @Override
    public List<User> pageuser(Integer currentpage, Integer pagecount) {
        String sql="select * from user limit ?, ?";
        List<Object> params = new ArrayList<>();
        params.add((currentpage-1)*pagecount);
        params.add(pagecount);
        // 调用BaseDao
        List<User> users = BaseDao.queryRows(sql, params, User.class);
        return  users;
    }

}
