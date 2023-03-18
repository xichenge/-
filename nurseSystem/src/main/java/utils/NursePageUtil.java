package utils;

import pojo.Nurse;

import java.util.List;

public class NursePageUtil {
    private PageBeanUtils pageBeanUtils;
    private List<Nurse>nurseList;

    public NursePageUtil(PageBeanUtils pageBeanUtils, List<Nurse> nurseList) {
        this.pageBeanUtils = pageBeanUtils;
        this.nurseList = nurseList;
    }

    public NursePageUtil() {
    }

    public PageBeanUtils getPageBeanUtils() {
        return pageBeanUtils;
    }

    public void setPageBeanUtils(PageBeanUtils pageBeanUtils) {
        this.pageBeanUtils = pageBeanUtils;
    }

    public List<Nurse> getNurseList() {
        return nurseList;
    }

    public void setNurseList(List<Nurse> nurseList) {
        this.nurseList = nurseList;
    }

    @Override
    public String toString() {
        return "NursePageUtil{" +
                "pageBeanUtils=" + pageBeanUtils +
                ", nurseList=" + nurseList +
                '}';
    }
}
