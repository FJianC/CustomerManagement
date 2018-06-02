package domain;

/**
 * @author FJianC
 */
public class Customer {

    /**
     * 客户id，主键自增
     * */
    private String id;

    /**
     * 客户名称，varchar[50]
     * */
    private String name;

    /**
     * 客户性别，varchar[20]
     * */
    private String gender;

    /**
     * 客户电话，varchar[50]
     * */
    private String phone;

    /**
     * 客户邮箱，varchar[50]
     * */
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
