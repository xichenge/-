package servlet;

import Dao.NurseDao;
import Impl.NurseImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.Nurse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/upload")
public class UploadImageServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("sdsadsa");
        //图片存放路径
        String path="F:\\nurseSystem\\src\\main\\webapp\\nurseimage";
        System.out.println(path);
        String fn=null;

        DiskFileItemFactory factory=new DiskFileItemFactory();
        //设置临时工厂
//        System.out.println(factory);
        ServletFileUpload sfu=new ServletFileUpload(factory);
        sfu.setHeaderEncoding("UTF-8");  //处理中文问题
        sfu.setSizeMax(1024*1024);   //限制文件大小

        try {
            List<FileItem> fileItems= sfu.parseRequest(request); //解码请求 得到所有表单元素
            System.out.println(fileItems);
            for (FileItem fi : fileItems) {//遍历所有的表单元素
                //有可能是 文件，也可能是普通文字
                if (fi.isFormField()) { //这个选项是 文字
                    System.out.println("表单值为："+fi.getString());
                }else{
                    // 是文件
                    //获取图片后缀名
                    String format=fi.getName().substring(fi.getName().indexOf("."), fi.getName().length());
                    //图片命名
                    fn= UUID.randomUUID().toString().replaceAll("-", "")+format;
                    System.out.println("文件名是："+fn);  //文件名
                    // fn 是可能是这样的 c:\abc\de\tt\fish.jpg

                    
                    fi.write(new File(path,fn));

                    System.out.println();
                    HttpSession session=request.getSession();
                    Nurse nurse = (Nurse) session.getAttribute("user");

//                    System.out.println("nurseimage:"+);
                    nurse.setSelf("nurseimage/"+fn);
                   session.setAttribute("user",nurse);


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
