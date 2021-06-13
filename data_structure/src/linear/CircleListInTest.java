package linear;
//快慢指针----找到有环链表入口问题
public class CircleListInTest {
    public static void main(String[] args) {
        Node<String> first = new Node<>("aa", null);
        Node<String> second = new Node<>("bb", null);
        Node<String> third= new Node<>("cc", null);
        Node<String> fourth = new Node<>("dd", null);
        Node<String> fifth = new Node<>("ee", null);
        Node<String> six = new Node<>("ff", null);
        Node<String> seven = new Node<>("gg", null);
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=six;
        six.next=seven;

        seven.next=third;

        Node<String> entrance=getEntrance(first);
        System.out.println("first链表中环的入口节点元素为："+entrance.item);
    }

    public static Node<String> getEntrance(Node<String> first) {
        Node fast=first;
        Node slow=first;
        Node temp=null;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast.equals(slow)){
                temp=first;
                continue;
            }
            if (temp!=null){
                temp=temp.next;
                if (temp.equals(slow)){
                    break;
                }
            }

        }
        return temp;
    }


    private static class Node<T>{
        private T item;
        private Node next;
        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }
}
