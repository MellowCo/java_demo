package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        boolean multipartContent = ServletFileUpload.isMultipartContent(request);
        if (multipartContent) {
            FileItemFactory itemFactory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
            try {
                List<FileItem> items = fileUpload.parseRequest(request);
                for (FileItem item : items) {

                    if (item.isFormField()) {
                        if (item.getFieldName().equals("uname")) {
                            String name = item.getString();
                            System.out.println(name);
                        } else if (item.getFieldName().equals("upwd")) {
                            String pwd = item.getString();
                            System.out.println(pwd);
                        }
                    }else {
                        String fileName = item.getName();
                        //String path = request.getSession().getServletContext().getRealPath("upload");
                        String path = "I:\\web\\upload";
                        File file = new File(path,fileName);
                        item.write(file);
                        System.out.println(fileName+"上传成功！！！");
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
