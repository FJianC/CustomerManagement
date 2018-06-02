package servlet;

import domain.Customer;
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
@WebServlet(name = "CusAddServlet", urlPatterns = {"/cusadd"})
public class CusAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Customer customer = new Customer();
        customer.setName(name);
        customer.setGender(gender);
        customer.setPhone(phone);
        customer.setEmail(email);

        CustomerService customerService = new CustomerService();
        try {
            customerService.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/cuslist").forward(request, response);

    }
}
