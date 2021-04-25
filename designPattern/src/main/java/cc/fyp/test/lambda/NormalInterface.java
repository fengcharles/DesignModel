package cc.fyp.test.lambda;


/**
 * 定义一个普通的接口，接口只有一个方法需要实现
 * @author von
 */
public interface NormalInterface {

    static String printStatic() {
        System.out.println("static");
        return "static";
    }

    default void print(String a){
        System.out.println(a);
    }

    String printArgs(String args);


}
