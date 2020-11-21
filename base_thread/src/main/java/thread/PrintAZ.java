package thread;

/**
 * @Title: PrintAZ
 * @Description: 用三个线程，顺序打印字母A-Z，输出结果是1A 2B 3C 1D 2E…打印完毕最后输出一个Ok。
 * @Code: 打印顺序可以，但线程顺序随机。
 */
public class PrintAZ {
    private static void print(Object o){System.out.println(o);}

    public static void main(String[] args) {
        PrintAZThread t1=new PrintAZThread();
        PrintAZThread t2=new PrintAZThread();
        PrintAZThread t3=new PrintAZThread();
        t1.start();
        t2.start();
        t3.start();
    }
    private static volatile int cnt=0;
    private static volatile Object object=new Object();

    static class PrintAZThread extends Thread {
        public void run() {
            synchronized(object) {
                while(cnt<27) {
                    for(int i=0;i<3;i++) {
                        if(cnt>=26) {
                            print("ok");
                            cnt++;
                            break;
                        }else {
                            print(Thread.currentThread().getName()+"=="+(cnt+1)+(char)('A'+cnt));
                            cnt++;
                        }
                    }
                    object.notifyAll();
                    try {
                        object.wait();
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notifyAll();
            }
        }
    }


}
