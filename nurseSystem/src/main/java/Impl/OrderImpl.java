package Impl;

import Dao.BaseDao;
import Dao.OrderDao;
import JDBC.DBUtil;
import pojo.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderImpl implements OrderDao {
    @Override
    public List<Order> getAllorder() {
        String sql="select * from `order` " ;
        List<Object> params = new ArrayList<>();

        // 调用BaseDao
        List<Order> orders = BaseDao.queryRows(sql, params, Order.class);

        return  orders;
    }

    @Override
    public Integer deleOrder(Integer id) {
        // 定义 sql语句
        String sql = "delete from `order` where id = ?";
        // 设置参数集合
        List<Object> params = new ArrayList<>();
        params.add(id);
        // 调用BaseDao
        int row = BaseDao.executeUpdate(sql, params);
        return row;

    }

    @Override
    public Integer addOrder(Order order) {
        Integer key = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            // 得到数据库连接
            connection = DBUtil.getConnection();
            // 定义 sql 语句
            String sql = "insert into `order`(userid,nurseid,ordertime,position ) VALUES (?,?,?,?)";
            // 先预编译
            pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // 设置参数
            pstmt.setInt(1,order.getUserid());
            pstmt.setInt(2,order.getNurseid());
            pstmt.setString(3,order.getOrdertime());
            pstmt.setString(4,order.getPosition());

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
    public List<Order> getOrderBy_Userid(Integer userid) {
        String sql="select * from `order` where userid=?";
        List<Object> params = new ArrayList<>();
        params.add(userid);
        // 调用BaseDao
        List<Order> orders = BaseDao.queryRows(sql, params, Order.class);
        return  orders;

    }

    @Override
    public List<Order> getOrderby_Nurseid(Integer nurseid) {

        System.out.println("nurseid:"+nurseid);
        String sql="select * from `order` where nurseid=?";
        List<Object> params = new ArrayList<>();
        params.add(nurseid);
        // 调用BaseDao
        List<Order> orders = BaseDao.queryRows(sql, params, Order.class);

        return  orders;
    }

    @Override
    public List<Order> findorder(String context, String position,Integer userid) {
        if("0".equals(position)){
            System.out.println("dssdad");
            String sql="select * from `order`  where ( ordertime like concat ('%',?,'%')) and userid=? ";
            List<Object> params = new ArrayList<>();
            params.add(context);params.add(userid);
            List<Order> orders = BaseDao.queryRows(sql, params, Order.class);
            System.out.println(orders);
            return  orders;
        }
        else
        {
            String sql="select * from `order`  where (ordertime like concat  ('%',?,'%') and position=?) and userid=?";
            List<Object> params = new ArrayList<>();
            params.add(context); params.add(position); params.add(userid);
            List<Order> orders = BaseDao.queryRows(sql, params, Order.class);
            System.out.println(orders);
            return  orders;
        }
    }

    @Override
    public int getAllOrderCount() {
        String sql="select * from `order` " ;
        List<Object> params = new ArrayList<>();

        // 调用BaseDao
        List<Order> orders = BaseDao.queryRows(sql, params, Order.class);
//        System.out.println(orders.size());
        return orders.size();
    }

    @Override
    public List<Order> pageorder(Integer currentpage,Integer pagecount) {
        String sql="select * from `order` limit ?, ?";
        List<Object> params = new ArrayList<>();
        params.add((currentpage-1)*pagecount);
        params.add(pagecount);
        // 调用BaseDao
        List<Order> orders = BaseDao.queryRows(sql, params, Order.class);
        return  orders;
    }

    @Override
    public List<Order> findorder_Bynurseid(String context, Integer nurseid) {

        String sql="select * from `order`  where (ordertime like concat  ('%',?,'%') ) and nurseid=?";
        List<Object> params = new ArrayList<>();
        params.add(context); params.add(nurseid);
        List<Order> orders = BaseDao.queryRows(sql, params, Order.class);
        return  orders;
    }

    @Override
    public List<Order> findorder_Bynurseid_page(String context, Integer nurseid, Integer currentpage, Integer pagecount) {
        String sql="select * from `order`  where (ordertime like concat  ('%',?,'%') ) and nurseid=? limit ?,?";
        List<Object> params = new ArrayList<>();
        params.add(context); params.add(nurseid);    params.add((currentpage-1)*pagecount); params.add(pagecount);

        List<Order> orders = BaseDao.queryRows(sql, params, Order.class);
        return  orders;
    }

    @Override
    public List<Order> findorder_Byuserid(String context, Integer userid, Integer typeposition) {
        return null;
    }

    @Override
    public List<Order> pageordernurse(Integer currentpage, Integer pagecount, Integer nurseid) {
        String sql="select * from `order` where nurseid=? limit ?, ? ";
        List<Object> params = new ArrayList<>();
        params.add(nurseid);
        params.add((currentpage-1)*pagecount);
        params.add(pagecount);

        // 调用BaseDao
        List<Order> orders = BaseDao.queryRows(sql, params, Order.class);
        return  orders;
    }


}
