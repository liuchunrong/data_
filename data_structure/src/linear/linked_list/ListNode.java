package linear.linked_list;
//单链表翻转
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
    public ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}

class Solution{
    public ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode nextTemp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        ListNode node = new Solution().reverseList(head);
        System.out.println(node.val);
    }
}
