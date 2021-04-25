package cc.fyp.test.lambda;

/**
 * @author von
 * @description:
 * @date 2020/12/15 16:56
 */
public class Main {

    public static void main(String[] args) {

        getInterface().printArgs("12312");

        new Thread(() -> System.out.print("hello world!")).start();

    }

    public static NormalInterface getInterface(){

        return args -> {
            System.out.println(args);
            return args;
        };
    }

    public static SingleInterface getSingleInterface(){
        return (q)-> {
            System.out.println("asdfBB");
            return  "single";
        };
    }

}
