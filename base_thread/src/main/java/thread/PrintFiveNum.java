package thread;

/**
 * @Title: PrintFiveNum
 * @Description: 用五个线程，顺序打印数字1~无穷大，其中每5个数字为1组，如下：其中id代表线程的id
 *               id   1   2   3   4   5
 *               no   1   2   3   4   5
 *               no   6   7   8   9   10
 *               no   11  12  13  14  15
 *               no   ..  ..  ..  ..  ..
 *
 *
 */
public class PrintFiveNum {
    public static void main(String[] args) {
        PrintFiveNumThread printFiveNumThread=new PrintFiveNumThread();
        Thread t1=new Thread(printFiveNumThread,"1");
        Thread t2=new Thread(printFiveNumThread,"2");
        Thread t3=new Thread(printFiveNumThread,"3");
        Thread t4=new Thread(printFiveNumThread,"4");
        Thread t5=new Thread(printFiveNumThread,"5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    static final Object obj=new Object();
    static int num=1;

    static class PrintFiveNumThread implements Runnable {
        @Override
        public void run() {
            synchronized(obj) {
                while(true) {
                    String threadName=Thread.currentThread().getName();
                    int threadNum=num%5==0?5:num%5;
                    if(Integer.parseInt(threadName)==threadNum) {
                        System.out.print("Thread-"+threadName+"\t");
                        for(int i=1;i<=5;i++) {
                            System.out.print((num*5-5+i)+(i==5?"\n":"\t"));
                        }
                        num++;
                    }
                    try {
                        Thread.sleep(500L);
                        obj.notifyAll();
                        obj.wait();
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
