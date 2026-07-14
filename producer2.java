public class producer2 implements Runnable{
    private final Buffer buffer;
    public  producer2(Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run(){
        int even=2;
        try{
            while(true){
                synchronized (buffer){
                    while(buffer.list.size()== buffer.capacity){
                        System.out.println("list is full");
                        buffer.wait();
                    }
                    buffer.list.add(even);
                    System.out.println("produced 2=" + even);
                    even+=2;
                    buffer.notifyAll();
                }
                Thread.sleep(1000);
            }

        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("producer got intrupted");
            return;
        }
    }
}