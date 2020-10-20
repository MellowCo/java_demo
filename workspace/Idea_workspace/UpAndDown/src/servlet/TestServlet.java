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
import java.util.Iterator;
import java.util.List;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean content = ServletFileUpload.isMultipartContent(request);

        if (content) {
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> items = fileUpload.parseRequest(request);
                Iterator<FileItem> iterator = items.iterator();
                while (iterator.hasNext()){
                    FileItem item = iterator.next();
                    if (item.isFormField()) {
                        if (item.getFieldName().equals("uname")) {
                            System.out.println(item.getString());
                        } else {
                            System.out.println(item.getString());
                        }
                    } else {
                        String path = "I:\\web\\upload";
                        String fileName = item.getName();

                        File file = new File(path, fileName);
                        item.write(file);
                        System.out.println("aaaaaaaaaaaa");
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}
