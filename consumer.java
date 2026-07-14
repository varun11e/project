public class consumer implements Runnable {
    private final Buffer buffer;
    public consumer(Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (buffer) {
                    while (buffer.list.size() < 2) {
                        System.out.println("2 items needed");
                        buffer.wait();
                    }
                    int value = buffer.list.removeFirst();
                    int value1 = buffer.list.removeFirst();
                    System.out.println("Consumed = " + value);
                    System.out.println("Consumed = " + value1);
                    buffer.notifyAll();
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer interrupted. Shutting down.");
            return;
        }
    }}