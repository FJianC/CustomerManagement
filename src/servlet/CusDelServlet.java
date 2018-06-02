package servlet;

import service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author FJianC
 */
@WebServlet(name = "CusDelServlet", urlPatterns = {"/cusdel"})
public class CusDelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String[] ids = request.getParameterValues("item");
        if (ids != null) {
            CustomerService customerService = new CustomerService();
            for (String id : ids) {
                try {
                    customerService.deleteCustomer(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        request.getRequestDispatcher("/cuslist").forward(request, response);
    }
}
