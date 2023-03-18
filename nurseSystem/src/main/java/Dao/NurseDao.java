package Dao;

import pojo.Nurse;
import pojo.User;

import java.util.List;

public interface NurseDao {
    public Nurse queryByE_mail(String e_mail);
    public List<Nurse> get0Nurse();
    public List<Nurse>get1Nurse();
    public Integer ChangeNurse(Integer id);
    public Integer registerNurse(Nurse nurse);
    public Integer deleNurse(Integer id);
    public Integer cancelNurse(Integer id);
    public Nurse getNurseById(Integer id);
    public Integer changeNurseData(Nurse nurse);
    public List<Nurse>findnurse(String context,String positiontype);
    public Integer getAllNurseCount1();
    public List<Nurse>pagenurse1(Integer currentpage,Integer pagecount);
    public Integer getAllNurseCount0();
    public List<Nurse>pagenurse0(Integer currentpage,Integer pagecount);
}
