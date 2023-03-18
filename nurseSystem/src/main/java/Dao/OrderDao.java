package Dao;



import com.sun.org.apache.xpath.internal.operations.Or;
import pojo.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> getAllorder();
    public Integer deleOrder(Integer id);
    public Integer addOrder(Order order);
    public List<Order> getOrderBy_Userid(Integer userid);
    public List<Order> getOrderby_Nurseid(Integer nurseid);
    public List<Order> findorder(String context,String position,Integer userid);

    public int getAllOrderCount();//所有的订单

    public List<Order>pageorder(Integer currentpage,Integer pagecount);//显示所有的菜单

    public List<Order>findorder_Bynurseid(String context,Integer nurseid);//根据护工id进行模糊查找

    public List<Order>findorder_Bynurseid_page(String context,Integer nurseid,Integer currentpage,Integer pagecount);

    public List<Order>findorder_Byuserid(String context,Integer userid,Integer typeposition);//根据护工id进行模糊查找

    public List<Order>pageordernurse(Integer currentpage,Integer pagecount,Integer nurseid);





}
