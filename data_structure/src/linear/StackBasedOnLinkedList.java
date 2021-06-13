package linear;

public class StackBasedOnLinkedList {
    private Node head;
    public StackBasedOnLinkedList(){
        this.head=null;
    }
    public boolean push(Object data) {
        Node newNode = new Node(data, head);
        head=newNode;
        return true;
    }

    public Object pop(){
        if (head==null){
            return null;
        }
        Node topNode=head;
        head=topNode.next;
        topNode.next=null;
        return topNode.data;
    }
    private class Node{
        private Object data;
        private Node next;
        public Node(Object data,Node next){
            this.data=data;
            this.next=next;
        }
        public Object getData(){
            return data;
        }
    }


    public static void main(String[] args) {
        StackBasedOnLinkedList stack=new StackBasedOnLinkedList();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println("第"+(i+1)+"次入栈，入栈的值为："+i);
        }

        for (int i = 0; i < 6; i++) {
            Object pop = stack.pop();
            System.out.println("取出的结果："+pop);
        }
    }
}
