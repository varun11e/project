public class Consumer implements Runnable {
    private final Buffer buffer;
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (buffer) {
                    while (buffer.consumerTurn==false) {
                        buffer.wait();
                    }
                    while (!buffer.list.isEmpty()) {
                        int value = buffer.list.removeFirst();
                        int value1 = buffer.list.removeFirst();
                        System.out.println("Consumed = " + value);
                        System.out.println("Consumed = " + value1);
                    }
                    buffer.consumerTurn= false;
                    buffer.producer1Turn=true;


                    buffer.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer interrupted.");
            return;
        }
    }
}