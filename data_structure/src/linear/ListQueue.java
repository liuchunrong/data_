package linear;
//队列API实现----基于链表
import java.util.Iterator;

public class ListQueue<T> implements Iterable<T>{
    private Node head;
    private Node last;
    private int N;

    public ListQueue(){
        this.head=new Node(null,null);
        this.last=null;
        this.N=0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }

    public void enqueue(T item){
        if (last==null){
            last=new Node(item,null);
            head.next=last;
        }else {
            Node oldLast=last;
            last=new Node(item,null);
            oldLast.next=last;
        }
        N++;
    }
    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        Node oldFirst=head.next;
        head.next=oldFirst.next;
        N--;
        if (isEmpty()){
            last=null;
        }
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }
    public class QIterator implements Iterator{
        private Node n;
        public QIterator(){
            this.n=head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }
    private class Node{
        private T item;
        private Node next;
        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }


    public static void main(String[] args) {

        ListQueue<String> queue=new ListQueue<>();
        queue.enqueue("aa");
        queue.enqueue("bb");
        queue.enqueue("cc");
        queue.enqueue("dd");

        for (String s : queue) {
            System.out.println(s);
        }

        String q = queue.dequeue();
        System.out.println("出队列的元素是："+q);
        System.out.println("剩余的元素个数："+queue.size());
    }
}
