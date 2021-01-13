package jvm.stringpool;

/**
 * @Title: TestStr
 * @Description:
 */
public class TestStr {
    String s="计算机技术";

    public static void main(String[] args) {
        String str=new StringBuilder("计算机").append("技术").toString();
//        str.intern();
//        System.out.println(str==str.intern());
        System.out.println(new TestStr().s==str);
        System.out.println(new TestStr().s==str.intern());
    }

}
