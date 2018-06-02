package servlet;

import domain.Customer;
import domain.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import service.PageService;
import util.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author FJianC
 * 用于自动生成客户数据
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into customer(name,gender,phone,email) values(?,?,?,?)";
        //num 生成num条数据
        int num = 1000;
        for (int i = 1; i <= num; i++) {
            Object[] params = {i, "男", i, i};
            try {
                queryRunner.update(sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        int pageNum = 1;
        int pageSize = 5;
        PageService pageService = new PageService();
        PageBean<Customer> pageBean = pageService.findAll(pageNum, pageSize);
        request.setAttribute("pageBean", pageBean);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
