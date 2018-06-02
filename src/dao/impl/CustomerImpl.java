package dao.impl;

import dao.CustomerDao;
import domain.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author FJianC
 */
public class CustomerImpl implements CustomerDao {

    private QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());

    @Override
    public void addCustomer(Customer customer) {
        try {
            String sql = "insert into customer values(?, ?, ?, ?, ?)";
            Object[] params = {customer.getId(), customer.getName(), customer.getGender(),
                                customer.getPhone(), customer.getEmail()};
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCustomer(Customer customer) {
        try {
            String sql = "update customer set name=?, gender=?, phone=?, email=? where id=?";
            Object[] params = {customer.getName(), customer.getGender(),
                    customer.getPhone(), customer.getEmail(), customer.getId()};
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String id) {
        try {
            String sql = "delete from customer where id=?";
            Object[] params = {id};
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findAll() {
        try {
            String sql = "select * from customer";
            return queryRunner.query(sql, new BeanListHandler<>(Customer.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findByName(String name) {
        try {
            String sql = "select * from customer where name like ?";
            Object[] params = {"%" + name + "%"};
            return queryRunner.query(sql, new BeanListHandler<>(Customer.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer findById(String id) {
        try {
            String sql = "select * from customer where id=?";
            Object[] params = {id};
            return queryRunner.query(sql, new BeanHandler<>(Customer.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
