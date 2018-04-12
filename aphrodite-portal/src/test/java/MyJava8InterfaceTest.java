/**
 * @ClassName:MyJava8InterfaceTest
 * @Author: yangyang.wang
 * @Date: 2018-04-09 19:43
 * @Version: 1.0
 * @Description: TODO
 **/
public class MyJava8InterfaceTest {

    public static void main(String[] args) {

        Test1.run2(); // test1 run2..... 接口中定义的静态方法直接调用
        Test2.run2(); // test2 run2.....

        Test test = new Test();
        test.show(); // test2 run1.....
        test.run1(); // test1 run1....
        //test.run2(); //编译不通过 当实现的多个接口中有相同签名的方法时，必须在实现类中通过重写方法解决冲突问题，否者无法通过编译，在重写的方法中可以通过 接口名.super.方法名(); 的方式显示调用需要的方法
        test.run3();

    }

}

class Test extends Test3 implements Test1,Test2{
    @Override
    public void show(){
        Test2.super.run1();
    }

    @Override
    public void run1() {
        Test1.super.run1();
    }

}


interface Test1{
    void show();
    default void run1(){
        System.out.println("test1 run1.... ");
    }
    static void run2(){
        System.out.println("test1 run2.....");
    }
}

interface Test2{
    void show();
    default void run1(){
        System.out.println("test2 run1.... ");
    }
    static void run2(){
        System.out.println("test2 run2.....");
    }

    default void run3(){
        System.out.println("Test2 run3.....");
    }
}

class Test3{
    public void run3(){
        System.out.println("test3 run3.....");
    }
}
