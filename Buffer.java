import java.util.LinkedList;

public class Buffer {

    LinkedList<Integer> list = new LinkedList<>();
    final int capacity =  2;
    boolean producer1Turn = true;
    boolean producer2Turn = false;
    boolean consumerTurn = false;


}