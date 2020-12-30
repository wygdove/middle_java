package thread;

/**
 * @Title: PrintAZ
 * @Description: 两个线程交替打印 ABABABAB ，一个打印A，一个打印B，要求：① A、B必须交替出现；② 每打印一个B，Sleep 100ms
 * @Code:
 */
public class PrintAB {
    private static final Object lockObj=new Object();
    private static int num=0;

    static class PrintABThread implements Runnable {
        public void run() {
            synchronized(lockObj) {
                while(true) {
                    if(num%2==0) {
                        System.out.println("A");
                    }else {
                        System.out.println("B");
                        try {
                            Thread.sleep(1000);
                        }catch(Exception e) {}
                    }
                    num++;
                    lockObj.notifyAll();
                    try {
                        lockObj.wait();
                    }catch(Exception e) {}
                }
            }
        }
    }


    public static void main(String[] args) {
        PrintABThread abThread=new PrintABThread();
        Thread aThread=new Thread(abThread);
        Thread bThread=new Thread(abThread);
        aThread.start();
        bThread.start();
    }
}
