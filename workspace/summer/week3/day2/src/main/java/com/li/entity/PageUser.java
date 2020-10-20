package com.li.entity;

import java.util.List;

/**
 * @author li
 * @version 1.0
 * @ClassName PageUser
 * @date 2019/7/17 19:42
 */
public class PageUser<T> {
    private int currentPage;
    private int totalCount;
    private int totalPage;
    private int pageSize;
    private List<T> list;

    public PageUser(int currentPage, int totalCount,int pageSize,List<T> list) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.totalPage = totalCount % pageSize == 0 ? totalCount/pageSize : totalCount/pageSize +1;
        this.list = list;
    }

    public PageUser() {
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
