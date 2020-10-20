package com.li.controller;

import com.li.domain.User;
import com.li.exception.SyException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Program: spring_mvc02
 * @ClassName: UserController
 * @Description:
 * @Author: li
 * @Create: 2019-08-02 13:39
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * @param
     * @Description: 返回值为String
     * @Author: li
     * @Create: 2019/8/2-13:39
     * @Return java.lang.String
     */
    @RequestMapping("/reString")
    public String reString(Model model) {
        System.out.println("String ...........");
        model.addAttribute("user", new User("li", "男", 12));
        return "success";
    }

    @RequestMapping("/reVoid")
    public void reVoid(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        System.out.println("Void ...........");
        //通过request 请求转发
        request.setAttribute("user2", new User("wang", "女", 12));
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        //通response 重定向
        response.sendRedirect("xxx.jsp");

        //通过 response 指定响应结果，例如响应 json 数据
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("json");
    }

    @RequestMapping("/reModelAndView")
    public ModelAndView reModelAndView() {
        /**
         ModelAndView mv = new ModelAndView();
         //设置跳转页面
         mv.setViewName("success");
         //将对象存入request域中
         mv.addObject("user3", new User("user3", "男", 14));
         return mv;
         */

        ModelAndView mv = new ModelAndView("success", "user3", new User("user3", "男", 14));
        return mv;
    }

    /**
     * @param
     * @Description: 使用关键字转发和重定向
     * @Author: li
     * @Create: 2019/8/2-19:39
     * @Return java.lang.String
     */
    @RequestMapping("forwardOrRedirect")
    public String forOrRe() {
        //请求转发
        return "forward:/WEB-INF/pages/success.jsp";

        //重定向
        // return "redirect:/index.jsp";
    }

    // @RequestMapping("/testAjax")
    // public void testAjax(@RequestBody User user){
    //     System.out.println(user);
    // }

    // @RequestMapping("/testAjax")
    // public @ResponseBody User testAjax(@RequestBody String body){
    //     System.out.println("成功执行。。。。。。。");
    //     return (User)JSONObject.toBean(JSONObject.fromObject(body), User.class);
    // }

    @RequestMapping("/testAjax")
    @ResponseBody
    public User testAjax(@RequestBody User user) {
        System.out.println("成功执行。。。。。。。");
        System.out.println(user);
        //模拟数据库 改值
        user.setName("wang");
        return user;
    }

    @RequestMapping("/testAjax2")
    @ResponseBody
    public User testAjax2(User user) {
        System.out.println("成功执行。。。。。。。");
        System.out.println(user);
        return user;
    }



    /**
     * @param request
     * @Description: 传统文件上传
     * @Author: li
     * @Create: 2019/8/3-15:29
     * @Return java.lang.String
     */
    @RequestMapping("/testFileUpload")
    public String testFileUpload(HttpServletRequest request) throws Exception {
        //查看表单是否为文件上传
        boolean content = ServletFileUpload.isMultipartContent(request);
        //不是文件上传格式
        if (!content) {
            return "error";
        }

        String path = request.getSession().getServletContext().getRealPath("/upload");
        Map<String, String> maps = new HashMap<>();

        File file = new File(path);

        if (!file.exists()) {
            file.mkdirs();
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析请求
        List<FileItem> fileItems = upload.parseRequest(request);

        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {
                //将表单的值存入map
                maps.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
            } else {
                String fileName = fileItem.getName();
                fileItem.write(new File(path, fileName));
            }
        }
        return "success";
    }


    /**
     * @param request
     * @param upload
     * @param user
     * @Description: springmvc 的文件上传
     * @Author: li
     * @Create: 2019/8/3-15:29
     * @Return java.lang.String
     */
    @RequestMapping("/testSpringFileUpload")
    public String testSpringFileUpload(HttpServletRequest request, MultipartFile upload, User user) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/upload");

        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        System.out.println(user);
        //生成唯一标志 uuid
        String s = UUID.randomUUID().toString();
        //输出 f6634f9f-2750-45f8-a583-d44b391795ff
        System.out.println(s);
        //替换uuid中的 -
        //输出 f6634f9f275045f8a583d44b391795ff
        System.out.println(s.replaceAll("-", ""));

        //获取文件名称
        String filename = s + upload.getOriginalFilename();
        //上传文件
        upload.transferTo(new File(path, filename));
        return "success";

    }

    /**
     * @param
     * @Description: 跨服务器的文件上传
     * @Author: li
     * @Create: 2019/8/3-15:30
     * @Return java.lang.String
     */
    @RequestMapping("/fileUpload")
    public String fileUpload(MultipartFile upload) throws IOException {
        String path = "http://localhost:9090/fileUpload/upload/";

        String filename = upload.getOriginalFilename();
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        filename = s + "_" + filename;

        //创建一个客户端
        Client client = Client.create();
        //建立连接
        WebResource resource = client.resource(path + filename);
        //上传资源
        resource.put(upload.getBytes());

        return "success";
    }

    @RequestMapping("/testException")
    public String testException() throws SyException {
        System.out.println("异常方法执行了。。。。。。。。。");

        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SyException("发生了异常。。。。。。。。");
        }
        return "success";
    }


    /**
     * @param
     * @Description: 测试ExceptionHandler注解
     * @Author: li
     * @Create: 2019/8/3-20:09
     * @Return java.lang.String
     */
    @RequestMapping("testExceptionHandler")
    public String testExceptionHandler() {
        int[] i = new int[2];

        System.out.println(i[2]);

        return "success";
    }


}
