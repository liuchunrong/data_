package symbol;
//符号表
public class SymbolTable<Key,Value> {
    private Node head;
    private int N;
    public SymbolTable(){
        this.head=new Node(null,null,null);
        this.N=0;
    }

    public void put(Key key,Value value){
        Node n=head;
        while (n.next!=null){
            n=n.next;
            if (n.key.equals(key)){
                n.value=value;
                return;
            }
        }
        Node newNode=new Node(key,value,null);
        Node oldFirst=head.next;
        newNode.next=oldFirst;
        head.next=newNode;
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
    public int size(){
        return N;
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
        SymbolTable<Integer, String> table = new SymbolTable<>();
        table.put(1,"张三");
        table.put(2,"李四");
        table.put(3,"王五");
        System.out.println("当前符号表中的元素个数为："+table.size());
        table.put(2,"赵四");
        System.out.println("替换完毕后元素个数为："+table.size());
        System.out.println("替换完毕后2对应的值为："+table.get(2));
        table.delete(2);
        System.out.println("删除完毕后个数为："+table.size());

    }
}
