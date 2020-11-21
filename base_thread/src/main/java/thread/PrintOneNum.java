package thread;

/**
 * @Title: PrintOneNum
 * @Description: 使用两个线程，交替计数到100
 */
public class PrintOneNum {
    private static void print(Object o){System.out.println(o);}

    public static void main(String[] args) {
        PrintOneNumThread t1=new PrintOneNumThread();
        PrintOneNumThread t2=new PrintOneNumThread();
        t1.start();
        t2.start();
    }


    static int count=1;
    static Object obj=new Object();

    static class PrintOneNumThread extends Thread {
        public void run() {
            try {
                synchronized(obj) {
                    while(count<=100) {
                        print(Thread.currentThread().getName()+"=="+count++);
                        obj.notifyAll();
                        obj.wait();
                    }
                    obj.notifyAll();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

}
