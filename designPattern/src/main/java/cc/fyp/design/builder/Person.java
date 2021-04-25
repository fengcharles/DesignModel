package cc.fyp.design.builder;

import java.util.Date;
import java.util.List;

/**
 *
 * 复习设计模式 建造者模式
 *
 * 需要注意以下几点。
 * 1、原实体类需要实现全参的构造方法
 * 2、构建Builder匿名类
 * 3、builder匿名类需要实现生成各个参数的方法
 * 4、builder匿名类需要提供一个返回原实体类的方法。
 * @author von
 * @description:
 * @date 2020/12/11 09:31
 */
public class Person {


    private String name;

    private String sex;

    private int age;

    private Date birthday;

    private List<String> tags;

    public Person(String name, String sex, int age, Date birthday, List<String> tags) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", tags=" + tags +
                '}';
    }

    public static PersonBuilder builder(){
        return new PersonBuilder();
    }

    /**
     * 以下是构造器
     */
    public static class PersonBuilder{

        private String name;

        private String sex;

        private int age;

        private Date birthday;

        private List<String> tags;

        PersonBuilder(){}

        public PersonBuilder name(String name){
            this.name = name;
            return this;
        }

        public PersonBuilder age(Integer age){
            this.age = age;
            return this;
        }

        public PersonBuilder sex(String sex){
            this.sex = sex;
            return this;
        }

        public PersonBuilder birthday(Date birthday){
            this.birthday = birthday;
            return this;
        }

        public PersonBuilder tags(List<String> tags){
            this.tags = tags;
            return this;
        }

        public Person build(){
            return new Person(this.name,this.sex,this.age,this.birthday,this.tags);
        }
    }

}
