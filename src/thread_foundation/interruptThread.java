package thread_foundation;
/*
 *
 *     @author Qmh
 *
 *   Yuan Li Bug Zhen Ai Sheng Ming
 */

// Demo1.java的源码


/*通常，我们通过“中断”方式终止处于“阻塞状态”的线程。
	当线程由于被调用了sleep(), wait(), join()等方法而进入阻塞状态；若此时调用线程的interrupt()将线程的中断标记设为true。
	由于处于阻塞状态，中断标记会被清除，同时产生一个InterruptedException异常。将InterruptedException放在适当的为止就能终止线程，形式如下：*/


/*
public class interruptThread
{

        public static void main(String[] args) {
            try {
                Thread t1 = new interruptThread.MyThread("t1");  // 新建“线程t1”
                System.out.println(t1.getName() +" ("+t1.getState()+") is new.");

                t1.start();                      // 启动“线程t1”
                System.out.println(t1.getName() +" ("+t1.getState()+") is started.");

                // 主线程休眠300ms，然后主线程给t1发“中断”指令。
                Thread.sleep(300);
                t1.interrupt();
                System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");

                // 主线程休眠300ms，然后查看t1的状态。
                Thread.sleep(300);
                System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                int i=0;
                while (!isInterrupted()) {
                    Thread.sleep(100); // 休眠100ms
                    i++;
                    System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");
            }
        }
    }
}
*/





/*通常，我们通过“标记”方式终止处于“运行状态”的线程。其中，包括“中断标记”和“额外添加标记”。
	通过“中断标记”终止线程。*/


public class interruptThread {

    public static void main(String[] args) {
        try {
            Thread t1 = new MyThread("t1");  // 新建“线程t1”
            System.out.println(t1.getName() +" ("+t1.getState()+") is new.");

            t1.start();                      // 启动“线程t1”
            System.out.println(t1.getName() +" ("+t1.getState()+") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令。
            Thread.sleep(300);
            t1.interrupt();
            System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");

            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);
            System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i=0;
            while (!isInterrupted()) {
                try {
                    Thread.sleep(100); // 休眠100ms
                } catch (InterruptedException ie) {
                    System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");
                }
                i++;
                System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);
            }
        }
    }
}
