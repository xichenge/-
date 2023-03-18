package SqlTest;

import Dao.NurseDao;
import Dao.OrderDao;
import Impl.NurseImpl;
import Impl.OrderImpl;
import org.junit.Test;
import pojo.Nurse;
import pojo.Order;

public class sqlTest {
    @Test
    public void test1(){
        OrderDao orderDao=new OrderImpl();
        System.out.println(orderDao.pageorder(1,5));
    }
    @Test
    public void test2(){
        NurseDao nurseDao=new NurseImpl();
        System.out.println(nurseDao.getAllNurseCount1());
        System.out.println();
        System.out.println(nurseDao.pagenurse1(1,4));
    }

}
