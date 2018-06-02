package dao.impl;

import dao.PageDao;
import domain.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author FJianC
 */
public class PageImpl implements PageDao {

    private QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());

    @Override
    public int getTotalRecord() {
        try {
            String sql = "select count(*) from customer";
            Object[] params = {};
            Long numLong = queryRunner.query(sql, new ScalarHandler<>(), params);
            return numLong.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Customer> findAll(int startIndex, int pageSize) {
        try {
            String sql = "select * from customer limit ?, ?";
            Object[] params = {startIndex, pageSize};
            return queryRunner.query(sql, new BeanListHandler<>(Customer.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
