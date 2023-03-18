package pojo;

public class Nurse {
    private Integer id;
    private String username;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String phone;
    private String e_mail;
    private String self;//放图片的位置
    private String position;
    private String password;
    private String md5;
    private String status;
    private String typestatus;
    private Integer positiontype;
    private Integer salary;

    public Nurse() {
    }

    public Nurse(Integer id, String username, String name, String gender, Integer age, String address, String phone, String e_mail, String self, String position, String password, String md5, String status, String typestatus, Integer positiontype, Integer salary) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.e_mail = e_mail;
        this.self = self;
        this.position = position;
        this.password = password;
        this.md5 = md5;
        this.status = status;
        this.typestatus = typestatus;
        this.positiontype = positiontype;
        this.salary = salary;
    }

    public Integer getPositiontype() {
        return positiontype;
    }

    public void setPositiontype(Integer positiontype) {
        this.positiontype = positiontype;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypestatus() {
        return typestatus;
    }

    public void setTypestatus(String typestatus) {
        this.typestatus = typestatus;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", self='" + self + '\'' +
                ", position='" + position + '\'' +
                ", password='" + password + '\'' +
                ", md5='" + md5 + '\'' +
                ", status='" + status + '\'' +
                ", typestatus='" + typestatus + '\'' +
                ", positiontype=" + positiontype +
                ", salary=" + salary +
                '}';
    }
}
