package service;

import dao.CustomerDao;
import dao.impl.CustomerImpl;
import domain.Customer;

import java.util.List;

/**
 * @author FJianC
 */
public class CustomerService {

    private CustomerDao customerDao = new CustomerImpl();

    public void addCustomer(Customer customer) {
        //如果添加客户时，客户名称没填或者为纯空格，则添加失败
        String empty = " ";
        if ("".equals(customer.getName().replaceAll(empty, ""))) {
            return;
        }
        customerDao.addCustomer(customer);
    }

    public void editCustomer(Customer customer) {
        String empty = " ";
        if ("".equals(customer.getName().replaceAll(empty, ""))) {
            return;
        }
        customerDao.editCustomer(customer);
    }

    public void deleteCustomer(String id) {
        customerDao.deleteCustomer(id);
    }

    public List<Customer> findByName(String name) {
        return customerDao.findByName(name);
    }
}
