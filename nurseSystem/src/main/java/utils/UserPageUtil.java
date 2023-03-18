package utils;

import pojo.User;

import java.util.List;

public class UserPageUtil {
    private PageBeanUtils pageBeanUtils;
    private List<User>userList;

    public UserPageUtil(PageBeanUtils pageBeanUtils, List<User> userList) {
        this.pageBeanUtils = pageBeanUtils;
        this.userList = userList;
    }

    public UserPageUtil() {
    }

    public PageBeanUtils getPageBeanUtils() {
        return pageBeanUtils;
    }

    public void setPageBeanUtils(PageBeanUtils pageBeanUtils) {
        this.pageBeanUtils = pageBeanUtils;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "UserPageUtil{" +
                "pageBeanUtils=" + pageBeanUtils +
                ", userList=" + userList +
                '}';
    }
}
