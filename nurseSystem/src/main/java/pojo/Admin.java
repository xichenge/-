package pojo;

public class Admin {
    private Integer id;
    private String username;
    private String password;
    private String  e_mail;
    private String md5;
    private String typestatus;

    public Admin() {
    }

    public Admin(Integer id, String username, String password, String e_mail, String md5, String typestatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.e_mail = e_mail;
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
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", md5='" + md5 + '\'' +
                ", typestatus='" + typestatus + '\'' +
                '}';
    }
}
