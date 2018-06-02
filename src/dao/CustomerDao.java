package dao;

import domain.Customer;

import java.util.List;

/**
 * @author FJianC
 */
public interface CustomerDao {

    /**
     * 添加客户信息接口
     * @param customer
     * */
    void addCustomer(Customer customer);

    /**
     * 修改客户信息接口
     * @param customer
     * */
    void editCustomer(Customer customer);

    /**
     * 通过id删除客户信息接口
     * @param id
     * */
    void deleteCustomer(String id);

    /**
     * 查找数据库全部的客户，封装到一个List中
     * @return list
     * */
    List<Customer> findAll();

    /**
     * 通过客户名称查找客户信息，支持模糊查找
     * @param name
     * @return list
     * */
    List<Customer> findByName(String name);

    /**
     * 通过id查找客户信息，返回一个对象
     * @param id
     * @return customer
     * */
    Customer findById(String id);

}
