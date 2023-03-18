package Impl;

import Dao.BaseDao;
import Dao.CountDataDao;
import JDBC.DBUtil;
import pojo.CountData;
import pojo.Nurse;
import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarOutputStream;

public class CountDataImpl implements CountDataDao {

    @Override
    public List<CountData> getData() {
        String sql="select * from countdata";
        List<Object> params = new ArrayList<>();

        // 调用BaseDao
        List<CountData> countDataList = BaseDao.queryRows(sql, params, CountData.class);
        System.out.println(countDataList);
        return  countDataList;
    }

    @Override
    public Integer updateData(CountData countData) {
        //定义sql语句
        String sql="update countdata set num=? where typeid=?";
        //设置参数集合
        List<Object> params=new ArrayList<>();
        params.add(countData.getNum());
        params.add(countData.getTypeid());
        //调用BaseDao更新方法，返回受影响行数
        int row= BaseDao.executeUpdate(sql,params);
        return row;
    }

    @Override
    public CountData getDateByTypeid(Integer typeid) {

        CountData countData=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
            //获得数据库连接
            connection= DBUtil.getConnection();
            //定义sql语句
            String sql="select * from countdata where typeid = ?";
            //预编译
            preparedStatement= connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setInt(1,typeid);
            //执行查询，返回结果
            rs= preparedStatement.executeQuery();
            //判断并分析结果
            if(rs.next()){
                countData=new CountData();
              countData.setNum(rs.getInt("num"));
              countData.setTypename(rs.getString("typename"));
              countData.setTypeid(rs.getInt("typeid"));
            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            //关闭资源
            DBUtil.close(rs,preparedStatement,connection);
        }
        return countData;
    }

}
