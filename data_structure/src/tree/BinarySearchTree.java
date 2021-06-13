package tree;

import java.util.ArrayDeque;
import java.util.Queue;

//构建二叉查找树
public class BinarySearchTree {
    Node parent;

    public boolean put(int value){
        if (parent==null){
            parent=createNode(value);
            return true;
        }
        Node pt=parent;
        while (pt!=null){
            if (pt.value>value){
                if (pt.left==null){
                    pt.left=createNode(value);
                    return true;
                }
                pt=pt.left;
            }else if (value>pt.value){
                if (pt.right==null){
                    pt.right=createNode(value);
                    return true;
                }
                pt=pt.right;
            }
        }
        return false;
    }
    public Node find(int value){
        while (parent!=null){
            if (parent.value>value){
                parent=parent.left;
            }else if (parent.value<value){
                parent=parent.right;
            }else {
                return parent;
            }
        }
        return parent;
    }

    public void delete(int value){
        Node p=parent;
        Node p_parent=null;
        while (p!=null){
            if (p.value>value){
                p_parent=p;
                p=p.left;
            }else if (p.value<value){
                p_parent=p;
                p=p.right;
            }else {
                break;
            }
        }
        if (p==null){
            return;
        }
        if (p.left!=null && p.right!=null){
            Node rTree=p.right;
            Node rTree_p=p;
            while (rTree.left!=null){
                rTree_p=rTree;
                rTree=rTree.left;
            }
            p.value=rTree.value;
            p=rTree;
            p_parent=rTree_p;
        }
        Node child=null;
        if (p.right!=null){
            child=p.right;
        }else if (p.left!=null){
            child=p.left;
        }else {
            child=null;
        }
        if (p_parent==null){
            parent=null;
        } else if (p_parent.left==p){
            p_parent.left=child;
        }else {
            p_parent.right=child;
        }
    }
    public Node getMax(){
        if (parent==null){
            return null;
        }
        Node p=parent;
        while (p.right!=null){
            p=p.right;
        }
        return p;
    }
    public Node getMin(){
        if (parent==null){
            return null;
        }
        Node p=parent;
        while (p.left!=null){
            p=p.left;
        }
        return p;
    }
    public void preOrder(Node node){
        if (node==null){
            return;
        }
        System.out.print(node.getValue()+"->");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void midOrder(Node node){
        if (node==null){
            return;
        }
        midOrder(node.left);
        System.out.print(node.getValue()+"->");
        midOrder(node.right);
    }
    public void afterOrder(Node node){
        if (node==null){
            return;
        }
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node.getValue()+"->");
    }
    public void layerOrder(Node node){
            Queue<Node> queue=new ArrayDeque<>();
            queue.add(node);
        while (!queue.isEmpty()){
            Node n=queue.poll();
            System.out.println(n.getValue()+"->");
            if (n.left!=null){
                queue.add(n.left);
            }
            if (n.right!=null){
                queue.add(n.right);
            }
        }
    }
    private Node createNode(int value){
        return new Node(null,value,null);
    }
    private Node createNode(Node left,int value,Node right){
        return new Node(left,value,right);
    }

    @Override
    public String toString() {
        midOrder(parent);
        return "";
    }

    private static class Node{
       private int value;
       private Node left;
       private Node right;
       protected Node(Node left,int value,Node right){
           this.left=left;
           this.value=value;
           this.right=right;
       }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bsTree =new BinarySearchTree();
        bsTree.put(16);
        bsTree.put(14);
        bsTree.put(12);
        bsTree.put(15);
        bsTree.put(10);

//        Node node = bsTree.find(15);
//        System.out.println(node.value);
//        bsTree.delete(10);

//        System.out.println(bsTree.getMin().getValue());

        System.out.println(bsTree);
    }
}
