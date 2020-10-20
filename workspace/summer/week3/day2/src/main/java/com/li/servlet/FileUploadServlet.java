package com.li.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
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

/**
 * @author li
 * @version 1.0
 * @ClassName FileUploadServlet
 * @date 2019/7/18 9:19
 */
@WebServlet("/fileUploadServlet")
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/upload");

        File file = new File(path);

        if(!file.isDirectory() && !file.exists()){
            file.mkdir();
        }

        Boolean flag = ServletFileUpload.isMultipartContent(request);

        if(flag){
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> items = upload.parseRequest(request);
                for (FileItem item : items) {
                    if(!item.isFormField()){
                        String filename = item.getName();
                        if(filename.equals("")|| filename == null){
                            request.setAttribute("msg","文件为空");
                            request.getRequestDispatcher("fileResult.jsp").forward(request, response);
                            return;
                        }
                        File fileUp = new File(path,filename);
                        item.write(fileUp);
                    }
                }
                request.setAttribute("msg","文件上传成功");
                request.getRequestDispatcher("fileResult.jsp").forward(request, response);
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
