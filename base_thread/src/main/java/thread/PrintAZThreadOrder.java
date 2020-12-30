package thread;

/**
 * @Title: PrintAZ
 * @Description: 用三个线程，顺序打印字母A-Z，输出结果是1A 2B 3C 1D 2E…打印完毕最后输出一个Ok。
 * @Code: 打印顺序可以，线程顺序可以。
 */
public class PrintAZThreadOrder {
    private static void print(Object o){System.out.println(o);}

    public static void main(String[] args) {
        PrintAZThread t1=new PrintAZThread();
        PrintAZThread t2=new PrintAZThread();
        PrintAZThread t3=new PrintAZThread();
        t1.setName("0");
        t2.setName("1");
        t3.setName("2");
        t1.start();
        t2.start();
        t3.start();
    }
    private static int cnt=0;
    private static final Object object=new Object();

    static class PrintAZThread extends Thread {
        @Override
        public void run() {
            synchronized(object) {
                String threadName=Thread.currentThread().getName();
                while(cnt<27) {
                    if(Integer.parseInt(threadName)==(cnt%3)) {
                        if(cnt>=26) {
                            print(threadName+"==ok");
                            cnt++;
                            break;
                        }else {
                            print(threadName+"=="+(cnt+1)+(char)('A'+cnt));
                            cnt++;
                        }
                    }
                    object.notifyAll();
                    try {
                        object.wait();
                    }catch(Exception e) {
                        print(e.getCause().toString());
                    }
                }
                object.notifyAll();
            }
        }
    }


}
