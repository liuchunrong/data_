package linear.queue;
//用链表实现队列--链式队列
public class LinkedListQueue {
    private int size;
    private Node head;
    private Node tail;
    public LinkedListQueue(){
        head=null;
        tail=null;
    }
    public boolean enqueue(Object data){
        Node newNode=new Node(data,null);
        if (tail==null){
            tail=newNode;
            head=newNode;
        }
        else {
            tail.next=newNode;
            tail=newNode;
        }
        size++;
        return true;
    }
    public Object dequeue(){
        if (head==null){
            return null;
        }
        Object data=head.data;
        head=head.next;
        if (head==null){
            tail=null;
        }
        size--;
        return data;
    }

    public int getSize() {
        return size;
    }

    private static class Node{
        private Object data;
        private Node next;
        public Node(Object data,Node next){
            this.data=data;
            this.next=next;
        }
    }


    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        System.out.println(queue.dequeue());
        queue.enqueue("itcast1");
        queue.enqueue("itcast2");
        queue.enqueue("itcast3");
        queue.enqueue("itcast4");
        queue.enqueue("itcast5");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue("itcast6");
        queue.enqueue("itcast7");
        queue.enqueue("itcast8");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
