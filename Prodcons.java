public class Prodcons {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Thread p1 = new Thread(new Producer1(buffer));
        Thread p2 = new Thread(new Producer2(buffer));
        Thread c = new Thread(new Consumer(buffer));

        p1.start();
        p2.start();
        c.start();
    }
}