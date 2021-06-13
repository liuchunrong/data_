package linear.linked_list;

import java.util.Iterator;
//单向链表API设计
public class LinkList<T> implements Iterable<T>{
    private Node head;
    private int N;
    public LinkList(){
        this.head=new Node(null,null);
        this.N=0;
    }
    public void clear(){
        head.next=null;
        this.N=0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int length(){
        return N;
    }
    public T get(int i){
        Node node=head.next;
        for (int index=0;index<i;index++){
            node=node.next;
        }
        return node.item;
    }
    public void insert(T t){
        Node node=head;
        while (node.next!=null){
            node=node.next;
        }
        Node newNode=new Node(t,null);
        node.next=newNode;
        N++;
    }
    public void insert(int i,T t){
        Node pre=head;
        for (int index=0;index<=i-1;index++){
            pre=pre.next;
        }
        Node curr=pre.next;
        Node node=new Node(t,curr);
        pre.next=node;
    }
    public T remove(int i){
        Node pre=head;
        for (int index=0;index<=i-1;index++){
            pre=pre.next;
        }
        Node curr=pre.next;
        Node nextNode=curr.next;
        pre.next=nextNode;

        N--;
        return curr.item;

    }
    public int indexOf(T t){
        Node node=head;
        for (int i=0;node.next!=null;i++){
            node=node.next;
            if (node.item.equals(t)){
                return i;
            }
        }
        return -1;
    }
    public void reverse(){
        if (isEmpty()){
            return;
        }
        reverse(head.next);
    }
    public Node reverse(Node curr){
        if (curr.next==null){
            head.next=curr;
            return curr;
        }
        Node pre=reverse(curr.next);
        pre.next=curr;
        curr.next=null;
        return curr;
    }
    @Override
    public Iterator<T> iterator() {
        return new lIterator();
    }
    private class lIterator implements Iterator{
        private Node n;
        public lIterator(){
            n=head;
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
        LinkList<String> list = new LinkList<>();
        list.insert("l1");
        list.insert("l2");
        list.insert("l3");
//        System.out.println(list.get(1));
        String s1 = list.remove(1);
//        System.out.println(s1);
        for (String s:list){
            System.out.println(s);
        }
//        list.reverse();
//        for (String s:list){
//            System.out.println(s);
//        }
    }
}
