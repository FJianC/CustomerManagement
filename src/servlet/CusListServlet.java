package servlet;

import domain.Customer;
import domain.PageBean;
import service.CustomerService;
import service.PageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CusListServlet", urlPatterns = {"/cuslist"})
public class CusListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        /**
         * 在没有实现分页功能时的代码段
         * CustomerService customerService = new CustomerService();
         * List<Customer> list = customerService.findAll();
         * request.setAttribute("cusList", list);
         * */


        String pageNumStr = request.getParameter("pageNum");
        int pageNum = Integer.parseInt(pageNumStr);
        int pageSize = 15;
        PageService pageService = new PageService();
        PageBean<Customer> pageBean = pageService.findAll(pageNum, pageSize);

        /**
         * 实现搜索功能，将查找后的数据封装到pageBean
         * 同时对查找后的数据实现分页功能
         * */
        String searchName = request.getParameter("searchName");
        if (searchName != null) {
            CustomerService customerService = new CustomerService();
            List<Customer> list = customerService.findByName(searchName);
            if (list.size() > 0) {
                pageBean = new PageBean<>(pageNum, pageSize, list.size());
                int count = pageBean.getStartIndex();
                while (count > 0) {
                    list.remove(0);
                    count--;
                }
                while (list.size() > pageSize) {
                    list.remove(pageSize);
                }
                pageBean.setData(list);
            } else {
                searchName = null;
            }
        }

        request.setAttribute("searchName", searchName);
        request.setAttribute("pageBean", pageBean);

        request.getRequestDispatcher("/index.jsp").forward(request, response);



    }
}
