package Impl;

import Dao.AdminDao;
import JDBC.DBUtil;
import pojo.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminImpl implements AdminDao {
    @Override
    public Admin queryAdminByE_mail(String e_mail) {
        Admin admin=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try{
            connection= DBUtil.getConnection();
            String sql="select * from admin where e_mail=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,e_mail);
            rs= preparedStatement.executeQuery();
            if(rs.next()){
                admin=new Admin();
                admin.setPassword(rs.getString("password"));
                admin.setUsername(rs.getString("username"));
                admin.setMd5(rs.getString("md5"));
                admin.setE_mail(rs.getString("e_mail"));
                admin.setId(rs.getInt("id"));
                admin.setTypestatus(rs.getString("typestatus"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,preparedStatement,connection);
        }
        return admin;
    }
}
