package tree;
//红黑树是一种平衡树，是2-3查找树的简单实现
/*
红黑树的特点
（1）每个节点或者是黑色，或者是红色。
（2）根节点是黑色。
（3）每个叶子节点（NIL）是黑色。 [注意：这里叶子节点，是指为空(NIL或NULL)的叶子节点！]
（4）如果一个节点是红色的，则它的子节点必须是黑色的。
（5）从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。
 */

import javax.management.NotificationFilter;
import java.awt.event.KeyEvent;

public class RedBlackTree<Key extends Comparable<Key>,Value> {
    private static final boolean RED = true;
    private static final boolean BLACK=false;
    private Node root;
    private int N;

    private boolean isRed(Node x){
        if (x==null){
            return false;
        }
        return x.color==RED;
    }
    private Node rotateLeft(Node h){
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=h.color;
        h.color=RED;
        return x;
    }
    private Node rotateRight(Node h){
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=h.color;
        h.color=RED;
        return x;
    }
    private void flipColor(Node h){
        h.color=RED;
        h.left.color=BLACK;
        h.right.color=BLACK;
    }
    public void put(Key key,Value value){
        root=put(root,key,value);
        root.color=BLACK;
    }
    public Node put(Node h,Key key,Value value){
        if (h==null){
            N++;
            return new Node(key,value,null,null,RED);
        }
        int cmp=key.compareTo(h.key);
        if (cmp>0){
            h.right=put(h.right,key,value);
        }else if (cmp<0){
            h.left=put(h.left,key,value);
        }else {
            h.value=value;
        }
        if (!isRed(h.left)&&isRed(h.right)){
            h=rotateLeft(h);
        }
        if (isRed(h.left)&&isRed(h.left.left)){
            h=rotateRight(h);
        }
        if (isRed(h.left)&&isRed(h.right)){
            flipColor(h);
        }
        return h;
    }
    public Value get(Key key){
        return get(root,key);
    }
    public Value get(Node x,Key key){
        if (x==null){
            return null;
        }
        int cmp=key.compareTo(x.key);
        if (cmp>0){
            return get(x.right,key);
        }else if (cmp<0){
            return get(x.left,key);
        }else {
            return x.value;
        }
    }
    public int size(){
        return N;
    }
    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private boolean color;
        public Node(Key key,Value value,Node left,Node right,boolean color){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
            this.color=color;
        }
    }

    public static void main(String[] args) {
        RedBlackTree<Integer,String> tree=new RedBlackTree<>();
        tree.put(4,"二哈");
        tree.put(1,"张三");
        tree.put(3,"李四");
        tree.put(5,"王五");
        System.out.println(tree.size());
        tree.put(1,"老三");
        System.out.println(tree.get(1));
        System.out.println(tree.size());
    }
}
