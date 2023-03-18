package pojo;

public class Order {
   private Integer id;
   private Integer userid;
   private Integer nurseid;
   private String ordertime;
   private String position;
   private String context;

    public Order() {
    }

    public Order(Integer id, Integer userid, Integer nurseid, String ordertime, String position, String context) {
        this.id = id;
        this.userid = userid;
        this.nurseid = nurseid;
        this.ordertime = ordertime;
        this.position = position;
        this.context = context;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getNurseid() {
        return nurseid;
    }

    public void setNurseid(Integer nurseid) {
        this.nurseid = nurseid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userid=" + userid +
                ", nurseid=" + nurseid +
                ", ordertime='" + ordertime + '\'' +
                ", position='" + position + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
