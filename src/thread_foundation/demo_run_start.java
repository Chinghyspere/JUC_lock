package thread_foundation;
/*
 *
 *     @author Qmh
 *
 *   Yuan Li Bug Zhen Ai Sheng Ming
 */



/*
*
* Thread中start()和run()的区别 :
*
* */



class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+" is running");
    }
}

public class demo_run_start {

    public static void main (String[] args){
        Thread mythread=new MyThread("mythread");

        System.out.println(Thread.currentThread().getName()+" call mythread.run()");
        mythread.run();

        System.out.println(Thread.currentThread().getName()+" call mythread.start()");
        mythread.start();
    }


}


/*
    main call mythread.run()
        main is running
        main call mythread.start()
        mythread is running*/
