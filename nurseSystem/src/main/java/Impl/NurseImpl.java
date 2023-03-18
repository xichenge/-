package Impl;

import Dao.BaseDao;
import Dao.NurseDao;
import JDBC.DBUtil;
import pojo.Nurse;
import pojo.Order;
import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NurseImpl implements NurseDao {
    @Override
    public Nurse queryByE_mail(String e_mail) {

        Nurse nurse=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
            //获得数据库连接
            connection= DBUtil.getConnection();
            //定义sql语句
            String sql="select * from nurse where e_mail = ? and status= '1' ";
            //预编译
            preparedStatement= connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setString(1,e_mail);
            //执行查询，返回结果
            rs= preparedStatement.executeQuery();
            //判断并分析结果
            if(rs.next()){
                nurse=new Nurse();
                nurse.setId(rs.getInt("id"));
                nurse.setUsername(rs.getString("username"));
                nurse.setName(rs.getString("name"));
                nurse.setAge(rs.getInt("age"));
                nurse.setAddress(rs.getString("address"));
                nurse.setPhone(rs.getString("phone"));
                nurse.setE_mail(rs.getString("e_mail"));
                nurse.setPassword(rs.getString("password"));

                nurse.setStatus(String.valueOf(rs.getInt("status")));
                nurse.setGender(rs.getString("gender"));
                nurse.setMd5(rs.getString("md5"));
                nurse.setTypestatus(rs.getString("typestatus"));
                nurse.setPosition(rs.getString("position"));
                nurse.setPositiontype(rs.getInt("positiontype"));
                nurse.setSalary(rs.getInt("salary"));
            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            //关闭资源
            DBUtil.close(rs,preparedStatement,connection);
        }
        return nurse;

    }

    @Override
    public List<Nurse> get0Nurse() {
        String sql="select * from nurse where status=?";
        List<Object> params = new ArrayList<>();
        params.add("0");
        // 调用BaseDao
        List<Nurse> nurses = BaseDao.queryRows(sql, params, Nurse.class);
        return nurses;

    }

    @Override
    public List<Nurse> get1Nurse() {
        String sql="select * from nurse where status=?";
        List<Object> params = new ArrayList<>();
        params.add("1");
        // 调用BaseDao
        List<Nurse> nurses = BaseDao.queryRows(sql, params, Nurse.class);
        return nurses;
    }

    @Override
    public Integer ChangeNurse(Integer id) {
        //定义sql语句
        String sql="update nurse set status = '1' where id=?";
        //设置参数集合
        List<Object> params=new ArrayList<>();
        params.add(id);
        //调用BaseDao更新方法，返回受影响行数
        int row= BaseDao.executeUpdate(sql,params);
        return row;
    }

    @Override
    public Integer registerNurse(Nurse nurse) {
        Integer key = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            // 得到数据库连接
            connection = DBUtil.getConnection();
            // 定义 sql 语句
            String sql="insert into nurse(username,name,gender,age,address,phone,e_mail,self,password,md5,status,typestatus,position,positiontype,salary) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,8000)";
            // 先预编译
            pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // 设置参数
            pstmt.setString(1, nurse.getUsername());
            pstmt.setString(2, nurse.getName());
            pstmt.setString(3, nurse.getGender());
            pstmt.setInt(4, nurse.getAge());
            pstmt.setString(5, nurse.getAddress());
            pstmt.setString(6, nurse.getPhone());
            pstmt.setString(7, nurse.getE_mail());
            pstmt.setString(8, nurse.getSelf());
            pstmt.setString(9, nurse.getPassword());
            pstmt.setString(10, nurse.getMd5());
            pstmt.setString(11,"0");
            pstmt.setString(12,"1");
            pstmt.setString(13,nurse.getPosition());
            pstmt.setInt(14,nurse.getPositiontype());
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



//
//        // 先预编译
//        pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//        // 设置参数
    }

    @Override
    public Integer deleNurse(Integer id) {
       String sql="delete from nurse where id=?";
       List<Object>params=new ArrayList<>();
       params.add(id);
       int row=BaseDao.executeUpdate(sql,params);
       return row;
    }

    @Override
    public Integer cancelNurse(Integer id) {
//        System.out.println("dsdas");
        //定义sql语句
        String sql="update nurse set status = '0' where id=?";
        //设置参数集合
        List<Object> params=new ArrayList<>();
        params.add(id);
        //调用BaseDao更新方法，返回受影响行数
        int row= BaseDao.executeUpdate(sql,params);
        return row;
    }

    @Override
    public Nurse getNurseById(Integer id) {
        Nurse nurse=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
            //获得数据库连接
            connection= DBUtil.getConnection();
            //定义sql语句
            String sql="select * from nurse where id = ?";
            //预编译
            preparedStatement= connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setInt(1,id);
            //执行查询，返回结果
            rs= preparedStatement.executeQuery();
            //判断并分析结果
            if(rs.next()){
                nurse=new Nurse();
                nurse.setPassword(rs.getString("password"));
                nurse.setPhone(rs.getString("phone"));
                nurse.setUsername(rs.getString("username"));
                nurse.setGender(rs.getString("gender"));
                nurse.setName(rs.getString("name"));
                nurse.setMd5(rs.getString("md5"));
                nurse.setAge(rs.getInt("age"));
                nurse.setE_mail(rs.getString("e_mail"));
                nurse.setAddress(rs.getString("address"));
                nurse.setId(rs.getInt("id"));
                nurse.setTypestatus(rs.getString("typestatus"));
                nurse.setPosition(rs.getString("position"));
                nurse.setPositiontype(rs.getInt("positiontype"));
            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            //关闭资源
            DBUtil.close(rs,preparedStatement,connection);
        }
        return nurse;
    }

    @Override
    public Integer changeNurseData(Nurse nurse) {

        //定义sql语句
        String sql="update nurse set username=?,name=?,e_mail=?,gender=?,phone=?,age=?,position=?,positiontype=? where id=?";
        //设置参数集合
        List<Object> params=new ArrayList<>();
        params.add(nurse.getUsername());
        params.add(nurse.getName());
        params.add(nurse.getE_mail());
        params.add(nurse.getGender());
        params.add(nurse.getPhone());
        params.add(nurse.getAge());
        params.add(nurse.getPosition());
        params.add(nurse.getPositiontype());

        params.add(nurse.getId());
        //调用BaseDao更新方法，返回受影响行数
        int row= BaseDao.executeUpdate(sql,params);
        return row;

    }

    @Override
    public List<Nurse> findnurse(String context, String positiontype) {

        if("0".equals(positiontype))
        {
            String sql="select * from nurse where (name like concat ('%',?,'%') or gender like concat ('%',?,'%')) and status=1";
            List<Object> params = new ArrayList<>();
            params.add(context);
            params.add(context);
            List<Nurse> nurses = BaseDao.queryRows(sql, params, Nurse.class);
//            System.out.println(nurses);
            return nurses;
        }
        else
        {

            String sql="select * from nurse where (name like concat ('%',?,'%') or gender like concat ('%',?,'%')) and positiontype=? and status=1 ";
            List<Object> params = new ArrayList<>();
            params.add(context);
            params.add(context);
            params.add(positiontype);
            List<Nurse> nurses = BaseDao.queryRows(sql, params, Nurse.class);
//            System.out.println(nurses);
            return nurses;


        }




//        String sql="select * from nurse where status=?";
//        List<Object> params = new ArrayList<>();
//        params.add("1");
//        // 调用BaseDao
//        List<Nurse> nurses = BaseDao.queryRows(sql, params, Nurse.class);
//        return nurses;


    }

    @Override
    public Integer getAllNurseCount1() {
        String sql="select * from nurse where status=?";
        List<Object> params = new ArrayList<>();
        params.add("1");
        // 调用BaseDao
        List<Nurse> nurses = BaseDao.queryRows(sql, params, Nurse.class);
        return nurses.size();
    }

    @Override
    public List<Nurse> pagenurse1(Integer currentpage, Integer pagecount) {
        String sql="select * from nurse where status=? limit ?,?";
        List<Object> params = new ArrayList<>();
        params.add("1");
        params.add((currentpage-1)*pagecount);
        params.add(pagecount);
        // 调用BaseDao
        List<Nurse> nurses = BaseDao.queryRows(sql, params, Nurse.class);
        return  nurses;

    }

    @Override
    public Integer getAllNurseCount0() {
        String sql="select * from nurse where status=?";
        List<Object> params = new ArrayList<>();
        params.add("0");
        // 调用BaseDao
        List<Nurse> nurses = BaseDao.queryRows(sql, params, Nurse.class);
        return nurses.size();
    }

    @Override
    public List<Nurse> pagenurse0(Integer currentpage, Integer pagecount) {
        String sql="select * from nurse where status=? limit ?,?";
        List<Object> params = new ArrayList<>();
        params.add("0");
        params.add((currentpage-1)*pagecount);
        params.add(pagecount);
        // 调用BaseDao
        List<Nurse> nurses = BaseDao.queryRows(sql, params, Nurse.class);
        return  nurses;
    }
}
