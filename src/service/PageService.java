package service;

import dao.PageDao;
import dao.impl.PageImpl;
import domain.Customer;
import domain.PageBean;

import java.util.List;

/**
 * @author FJianC
 */
public class PageService {

    private PageDao pageDao = new PageImpl();

    public PageBean<Customer> findAll(int pageNum, int pageSize){
        int totalRecord = pageDao.getTotalRecord();
        PageBean<Customer> pageBean = new PageBean<>(pageNum, pageSize, totalRecord);
        List<Customer> data = pageDao.findAll(pageBean.getStartIndex(), pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }

}
