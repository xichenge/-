package Dao;

import pojo.CountData;

import java.util.ArrayList;
import java.util.List;

public interface CountDataDao {
    public List<CountData> getData();
    public Integer updateData(CountData countData);
    public CountData getDateByTypeid(Integer typeid);
}
