

public class prodcons {

     static void main(String[] args) {

        Buffer buffer = new Buffer();
        Thread p1=new Thread(new producer1(buffer));
        Thread p2=new Thread(new producer2(buffer));
        Thread p3=new Thread(new consumer(buffer));

        p1.start();
        p2.start();
        p3.start();
    }
}