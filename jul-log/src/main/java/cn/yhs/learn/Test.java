package cn.yhs.learn;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.getClass().getName());// 获取全类名
        System.out.println(t.getClass().getCanonicalName());
        System.out.println(t.getClass().getTypeName());
        System.out.println(t.getClass().getSimpleName());
    }
}
