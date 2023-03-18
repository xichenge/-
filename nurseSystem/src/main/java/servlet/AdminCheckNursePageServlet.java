package servlet;

import Dao.NurseDao;
import Impl.NurseImpl;
import com.alibaba.fastjson.JSON;
import pojo.Nurse;
import utils.NursePageUtil;
import utils.PageBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminchecknurse")
public class AdminCheckNursePageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        Integer currentpage = Integer.valueOf(req.getParameter("currentpage"));//获取当前页
//        System.out.println("current:"+currentpage);
        NurseDao nurseDao=new NurseImpl();
        Integer totalpage = nurseDao.getAllNurseCount0();//获取总数量
        PageBeanUtils pageBeanUtils=new PageBeanUtils(currentpage,15,totalpage);//分页工具类

        List<Nurse> nurses=nurseDao.pagenurse0(pageBeanUtils.getCurrentPage(),15);

        NursePageUtil nursePageUtil=new NursePageUtil(pageBeanUtils,nurses);
        String json= JSON.toJSONString(nursePageUtil);
//        System.out.println(json);
        resp.getWriter().println(json);
    }
}
