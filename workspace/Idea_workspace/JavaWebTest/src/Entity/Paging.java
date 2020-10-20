package Entity;

import java.util.List;

public class Paging {
    private int dataCount; //数据总数
    private int pageCount; //总页数
    private List<StudentEntity> students; //数据集合
    private int pageSize; //页面大小
    private int currentPage; //当前页

    public Paging() {
    }

    public Paging(int dataCount, List<StudentEntity> students, int pageSize, int currentPage) {
        this.dataCount = dataCount;
        this.students = students;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.pageCount = dataCount % pageSize == 0 ? dataCount / pageSize : dataCount / pageSize+1;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
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
}
