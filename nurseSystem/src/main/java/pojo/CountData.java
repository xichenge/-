package pojo;

public class CountData {
    private Integer typeid;
    private String typename;
    private Integer num;


    public CountData() {
    }

    public CountData(Integer typeid, String typename, Integer num) {
        this.typeid = typeid;
        this.typename = typename;
        this.num = num;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "CountData{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                ", num=" + num +
                '}';
    }
}
