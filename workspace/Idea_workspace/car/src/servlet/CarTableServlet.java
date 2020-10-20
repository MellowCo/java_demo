package servlet;

import entity.Car;
import net.sf.json.JSONArray;
import service.CarServicesImpl;
import service.ICarServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.util.List;

@WebServlet("/CarTableServlet")
public class CarTableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int limit = Integer.parseInt(request.getParameter("limit"));
        int page = Integer.parseInt(request.getParameter("page"))-1;

        ICarServices ics = new CarServicesImpl();
        List<Car> cars = ics.queryCarByLimit(page * limit, limit);


        JSONArray js = JSONArray.fromObject(cars);
//        PageContext pg =javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
//
//        JspWriter jw = pg.getOut();
//        jw.print(js);

        String layjs = "{ \"code\": "+0+",\"msg\":\"\"" + ",\"count\":" + 10+ ",\"data\":" + js.toString() + "}";
        response.getWriter().print(layjs);


        System.out.println(layjs);

}
}
