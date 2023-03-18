package pojo;

public class User {
    private Integer id;
    private String username;
    private String name;
    private String password;
    private String e_mail;
    private String gender;
    private String phone;
    private String address;
    private Integer age;
    private String md5;
    private String typestatus;


    public User() {
    }

    public User(Integer id, String username, String name, String password, String e_mail, String gender, String phone, String address, Integer age, String md5, String typestatus) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.e_mail = e_mail;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.md5 = md5;
        this.typestatus = typestatus;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getTypestatus() {
        return typestatus;
    }

    public void setTypestatus(String typestatus) {
        this.typestatus = typestatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", md5='" + md5 + '\'' +
                ", typestatus='" + typestatus + '\'' +
                '}';
    }
}
