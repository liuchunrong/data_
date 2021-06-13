package linear;

import java.util.Iterator;

//栈API实现----基于链表
public class ListStack<T> implements Iterable<T>{
    private Node head;
    private int N;
    public ListStack(){
        this.head=new Node(null,null);
        this.N=0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void push(T item){
        Node newNode=new Node(item,null);
        Node curr=head.next;
        head.next=newNode;
        newNode.next=curr;
        N++;
    }

    public T pop(){
        Node curr=head.next;
        if (curr==null){
            return null;
        }
        head.next=curr.next;
        N--;
        return curr.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    public class SIterator implements Iterator{
        private Node n;
        public SIterator(){
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
        ListStack<String> stack=new ListStack<String>();
        stack.push("aa");
        stack.push("bb");
        stack.push("cc");
        stack.push("dd");

        for (String s:stack){
            System.out.println(s);
        }

        String pop = stack.pop();
        System.out.println("弹出的元素是"+pop);
        System.out.println("剩余元素个数为："+stack.size());
    }
}

