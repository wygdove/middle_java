package example.oom;

/**
 * @Title: JavaVMStackSOF
 * @Description:
 * @VM_Args: -Xss128k
 * @Result: java.lang.StackOverflowError
 */
public class JavaVMStackSOF {

    private static int stackLength=1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF test=new JavaVMStackSOF();
        try {
            test.stackLeak();
        }catch(Throwable e) {
            System.out.println(stackLength);
            throw e;
        }
    }

}
