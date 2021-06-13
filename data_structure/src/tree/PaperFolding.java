package tree;

import java.util.ArrayDeque;
import java.util.Queue;

//二叉树----折纸问题(打印N折树的折痕)
public class PaperFolding {
    public static void main(String[] args) {
        Node tree=createTree(3);
        printTree(tree);
    }
    private static void printTree(Node tree){
        //中序遍历
        if (tree==null){
            return;
        }
        printTree(tree.left);
        System.out.print(tree.item+",");
        printTree(tree.right);
    }
    private static Node createTree(int N){
        Node root=null;
        for (int i = 0; i < N; i++) {
            if (i==0){
                root=new Node("down",null,null);
                continue;
            }else {
                Queue<Node> queue=new ArrayDeque<>();
                queue.add(root);
                while (!queue.isEmpty()){
                    Node tmp=queue.poll();
                    if (tmp.left!=null){
                        queue.add(tmp.left);
                    }
                    if (tmp.right!=null){
                        queue.add(tmp.right);
                    }
                    if (tmp.left==null&&tmp.right==null){
                        tmp.left=new Node("down",null,null);
                        tmp.right=new Node("up",null,null);
                    }
                }
            }
        }
        return root;
    }
    private static class Node{
        String item;
        Node left;
        Node right;
        public Node(String item,Node left,Node right){
            this.item=item;
            this.left=left;
            this.right=right;
        }
    }
}
