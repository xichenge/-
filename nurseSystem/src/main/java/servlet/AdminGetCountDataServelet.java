package servlet;

import Dao.CountDataDao;
import Impl.CountDataImpl;
import com.alibaba.fastjson.JSON;
import pojo.CountData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/admingetdata")
public class AdminGetCountDataServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        CountDataDao countDataDao=new CountDataImpl();
        List<CountData>countDataList=countDataDao.getData();

        List<String>typenames=new ArrayList<>();
        List<Integer>nums=new ArrayList<>();
        for(CountData countData:countDataList)
        {
            typenames.add(countData.getTypename());
            nums.add(countData.getNum());
        }
//        System.out.println("dsadsad");
        Map map = new HashMap<String,Object>();
        map.put("typenames",typenames);
        map.put("nums",nums);
//        System.out.println(map);
        String json=null;
        json= JSON.toJSONString(map);
//        System.out.println(json);
        resp.getWriter().println(json);

    }
}
