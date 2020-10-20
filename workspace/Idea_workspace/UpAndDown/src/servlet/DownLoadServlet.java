package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet("/DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String fileName = request.getParameter("fileName");

        response.addHeader("content-Type", "application/octet-stream");
        response.addHeader("content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));

        InputStream is = request.getServletContext().getResourceAsStream("rs/图片.pdf");
        OutputStream os = response.getOutputStream();
        byte[] datas = new byte[1024 * 20];
        int len = -1;
        while ((len=is.read(datas))!=-1){
            os.write(datas,0,len);
        }
        os.flush();
        os.close();
        is.close();
    }
}
