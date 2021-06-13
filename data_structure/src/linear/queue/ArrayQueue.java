package linear.queue;
//队列--先进先出
//用数组实现队列--顺序队列
import java.util.Arrays;

public class ArrayQueue {
    private int size;
    private Object[] elements;
    private int DEFAULT_CAPACITY=10;
    private int head;
    private int tail;
    private int MAX_ARRAY_SIZE=Integer.MAX_VALUE-8;
    public ArrayQueue(){
        elements=new Object[DEFAULT_CAPACITY];
        initPointer(0,0);
    }
    public ArrayQueue(int capacity){
        elements=new Object[capacity];
        initPointer(0,0);
    }
    private void initPointer(int head,int tail){
        this.head=head;
        this.tail=tail;
    }

    public boolean enqueue(Object element){
        ensureCapacityHelper();
        elements[tail++]=element;
        size++;
        return true;
    }
    public void ensureCapacityHelper(){
        if (tail==elements.length){
            if (head==0){
                grow(elements.length);
            }else {
                for (int i=head;i<tail;i++){
                    elements[i-head]=elements[i];
                }
                initPointer(0,tail-head);
            }
        }
    }
    public void grow(int oldCapacity){
        int newCapacity=oldCapacity+(oldCapacity>>1);
        if (newCapacity-oldCapacity<0){
            newCapacity=DEFAULT_CAPACITY;
        }
        if (newCapacity-MAX_ARRAY_SIZE>0){
            newCapacity=hugeCapacity(newCapacity);
        }
        elements= Arrays.copyOf(elements,newCapacity);
    }
    public int hugeCapacity(int newCapacity){
        return (newCapacity>MAX_ARRAY_SIZE)?Integer.MAX_VALUE:newCapacity;
    }
    public Object dequeue(){
        if (head==tail){
            return null;
        }
        Object obj = elements[head++];
        size--;
        return obj;
    }
    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue(4);
        queue.enqueue("itcast1");
        queue.enqueue("itcast2");
        queue.enqueue("itcast3");
        queue.enqueue("itcast4");
        queue.enqueue("itcast5");
        queue.enqueue("itcast6");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue("itcast7");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
