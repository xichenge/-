package utils;

import pojo.Order;

import java.util.List;

public class OrderPageUtil {
    private PageBeanUtils pageBeanUtils;
    private List<Order> orderList;

    public OrderPageUtil(PageBeanUtils pageBeanUtils, List<Order> orderList) {
        this.pageBeanUtils = pageBeanUtils;
        this.orderList = orderList;
    }

    public PageBeanUtils getPageBeanUtils() {
        return pageBeanUtils;
    }

    public void setPageBeanUtils(PageBeanUtils pageBeanUtils) {
        this.pageBeanUtils = pageBeanUtils;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "OrderPageUtil{" +
                "pageBeanUtils=" + pageBeanUtils +
                ", orderList=" + orderList +
                '}';
    }
}
