package cn.dev33.satoken.spring;

public class TestBean {
    private String name;

    public TestBean(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public TestBean() {
    }

    private Integer age;

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
}
