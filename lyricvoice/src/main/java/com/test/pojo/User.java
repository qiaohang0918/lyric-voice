package com.test.pojo;

/**
 * @Aurher: QiaoHang
 * @Description:
 * @Data: 2019/9/12 8:20
 * @Modified By:
 */
public class User {

    public String name;
    public Integer age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User myinit(){
        System.out.println("user --- initing--- ");
        return new User();
    }

}
