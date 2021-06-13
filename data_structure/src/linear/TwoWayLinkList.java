package linear;

import java.util.Iterator;

//双向链表API实现
//java中的LinkedList就是基于双向链表实现
public class TwoWayLinkList<T> implements Iterable<T>{

    private class Node{
        private T item;
        private Node pre;
        private Node next;
        public Node(T item,Node pre, Node next){
            this.item=item;
            this.pre=pre;
            this.next=next;
        }
    }

    private Node head;
    private Node last;
    private  int N;
    public TwoWayLinkList(){
        this.head=new Node(null,null,null);
        this.last=null;
        this.N=0;
    }
    public void clear(){
        this.head.next=null;
        this.last=null;
        this.N=0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public T getFirst(){
        if (isEmpty()){
            return  null;
        }
        return head.next.item;
    }
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.item;
    }
    public int length(){
        return N;
    }
    public T get(int i){
        Node n=head.next;
        for (int index=0;index<i;index++){
            n=n.next;
        }
        return n.item;
    }
    public void insert(T t){
        if (isEmpty()){
            Node newNode=new Node(t,head,null);
            last=newNode;
            head.next=last;
        }else {
            Node oldLast=last;
            Node newNode=new Node(t,oldLast,null);
            oldLast.next=newNode;
            last=newNode;
        }
        N++;
    }
    public void insert(int i,T t){
        Node pre=head;
        for (int index=0;index<i;i++){
            pre=pre.next;
        }
        Node curr=pre.next;
        Node newNode=new Node(t,pre,curr);
        pre.next=newNode;
        curr.pre=newNode;
        N++;
    }
    public T remove(int i){
        Node pre=head;
        for (int index=0;index<i;i++){
            pre=pre.next;
        }
        Node curr=pre.next;
        Node next=curr.next;
        pre.next=next;
        next.pre=pre;
        return curr.item;
    }
    public int indexOf(T t){
        Node n=head;
        for (int i=0;n.next!=null;i++){
            n=n.next;
            if (n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new tIterator();
    }
    private class tIterator implements Iterator{
        private Node n;
        public tIterator(){
            n=head;
        }
        @Override
        public boolean hasNext() {
            return head.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }
}
