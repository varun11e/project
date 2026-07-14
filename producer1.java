public class producer1 implements Runnable{
    private final Buffer buffer;
    public  producer1(Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run(){
        int odd=1;
        try{
            while(true){
                synchronized (buffer){
                    while(buffer.list.size()== buffer.capacity){
                        System.out.println("list is full");
                        buffer.wait();
                    }
                    buffer.list.add(odd);
                    System.out.println("produced 1=" + odd);
                    odd+=2;
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