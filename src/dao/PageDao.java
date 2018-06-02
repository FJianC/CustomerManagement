package dao;

import domain.Customer;

import java.util.List;

/**
 * @author FJianC
 */
public interface PageDao {

    /**
     * 获取客户的总数，返回一个totalRecord
     * @return int
     * */
    int getTotalRecord();

    /**
     * 查找应该显示在当前页数的客户，封装到一个list中
     * @param startIndex 跳过前startIndex个
     * @param pageSize （每页显示的个数）之后的pageSize个
     * @return list
     * */
    List<Customer> findAll(int startIndex, int pageSize);

}
