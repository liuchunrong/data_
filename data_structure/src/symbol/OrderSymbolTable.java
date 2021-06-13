package symbol;
//有序符号表，按key的大小顺序插入
public class OrderSymbolTable<Key extends Comparable<Key>,Value> {
    private Node head;
    private int N;
    public OrderSymbolTable(){
        this.head=new Node(null,null,null);
        this.N=0;
    }
    public int size(){
        return N;
    }
    public void put(Key key,Value value){
        Node pre=head;
        Node curr=head.next;
        while (curr!=null&&key.compareTo(curr.key)>0){
            pre=curr;
            curr=curr.next;
        }
        if (curr!=null&&key.compareTo(curr.key)==0){
            curr.value=value;
            return;
        }
        Node newNode=new Node(key,value,curr);
        pre.next=newNode;
        N++;
    }
    public void delete(Key key){
        Node n=head;
        while (n.next!=null){
            if (n.next.key.equals(key)){
                n.next=n.next.next;
                N--;
                return;
            }
            n=n.next;
        }
    }
    public Value get(Key key){
        Node n=head;
        while (n.next!=null){
            n=n.next;
            if (key.equals(n.key)){
                return n.value;
            }
        }
        return null;
    }
    private class Node{
        private Key key;
        private Value value;
        private Node next;
        public Node(Key key,Value value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }

    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> table = new OrderSymbolTable<>();
        table.put(1,"张三");
        table.put(3,"王五");
        table.put(4,"赵六");
        table.put(2,"李四");
//        System.out.println(table.head.next.next.value);

    }
}
