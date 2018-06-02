package domain;

import java.util.List;

/**
 * @author FJianC
 */
public class PageBean<T> {

    /**
     * pageNum     当前页，从请求传过来
     * pageSize    每页显示的数据条数
     * totalRecord 总记录条数，查询数据库得到的数据
     * totalPage   总页数，通过totalRecord和pageSize计算得到
     * startIndex  开始的索引值，数据库语句 limit startIndex，pageSize；
     * data        将每页要显示的数据放到list集合中
     * startPage   分页栏显示的开始页数
     * endPage     分页栏显示的结束页数
     * */
    private int pageNum;
    private int pageSize;
    private int totalRecord;
    private int totalPage;
    private int startIndex;
    private List<T> data;
    private int startPage;
    private int endPage;

    public PageBean(int pageNum, int pageSize, int totalRecord) {
        this.pageNum  = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        /**
         * 计算总页数，如果不能整除说明还有多余的数据，则增加一页
         * */
        this.totalPage = totalRecord / pageSize;
        if (totalRecord % pageSize != 0) {
            this.totalPage = totalRecord / pageSize + 1;
        }

        /**
         * 计算开始的索引值
         * */
        this.startIndex = (pageNum - 1) * pageSize;

        /**
         * page 分页栏显示的页数
         * 如果 总页数 小于等于 分页数 则开始页数为 1 尾页数为 总页数
         * 如果 总页数 大于 分页数
         *      则开始页数为 当前页数-分页数/2 尾页数为 当前页数+分页数/2
         *      如果 计算后的开始页数小于等于 0
         *           则说明当前页数是第一页或者接近第一页
         *           开始页为 1，尾页为分页数
         *      如果 计算后的尾页数 大于 总页数
         *           则说明当前页在最后一页或者接近最后一页
         *           开始页为 总页数-分页数，尾页为 总页数
         * */
        int page = 5;
        if (this.totalPage <= page) {
            this.startPage = 1;
            this.endPage = this.totalPage;
        } else {
            this.startPage = pageNum - page / 2;
            this.endPage = pageNum + page / 2;

            if (startPage <= 0) {
                this.startPage = 1;
                this.endPage = page;
            }
            if (endPage > this.totalPage) {
                this.startPage = this.totalPage - page;
                this.endPage = this.totalPage;
            }
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
}
