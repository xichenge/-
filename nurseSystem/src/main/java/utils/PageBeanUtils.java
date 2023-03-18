package utils;

public class PageBeanUtils {
    private int prePage;//上一页
    private int nextPage;//下一页
    private int firstPage=1;//.0首页
    private int lastPage;//尾页
    private int currentPage;//当前页
    private int pageSize;//每页显示条数
    private int totalPage;//总页数

    public PageBeanUtils(int currentPage, int pageSize, int totalPage) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
//        System.out.println(currentPage);
        //计算获得总页数(尾数)
        this.totalPage=this.lastPage=(int)Math.ceil((double)totalPage/pageSize);
        System.out.println(totalPage);

        //防止当前页小于1
        this.currentPage=Math.max(currentPage,1);
        //防止当前页不可以大于总页数
        this.currentPage=Math.min(this.totalPage,this.currentPage);
        //设置上一页，上一页不可以小于1
        this.prePage=Math.max(this.currentPage-1,1);
        //设置下一页，下一不能大于总页数
        this.nextPage=Math.min(this.currentPage+1,this.totalPage);

    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageBeanUtils{" +
                "prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                '}';
    }
}
