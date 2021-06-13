package tree;

import java.util.ArrayDeque;
import java.util.Queue;

//二叉查找树
public class BinaryTree<Key extends Comparable<Key>,Value> {
    private Node root;
    private  int N;

    public int size(){
        return N;
    }
    public void put(Key key,Value value){
        root=put(root,key,value);
    }
    public Node put(Node x,Key key,Value value){
        if (x==null){
            N++;
            return new Node(key,value,null,null);
        }
        int cmp=key.compareTo(x.key);
        if (cmp>0){
            x.right=put(x.right,key,value);
        }else if (cmp<0){
            x.left=put(x.left,key,value);
        }else {
            x.value=value;
        }
        return x;
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
    public void delete(Key key){
        root=delete(root,key);
    }
    public Node delete(Node x,Key key){
        if (x==null){
            return null;
        }
        int cmp=key.compareTo(x.key);
        if (cmp>0){
            x.right=delete(x.right,key);
        }else if (cmp<0){
            x.left=delete(x.left,key);
        }else {
            N--;
            if (x.right==null){
                return x.left;
            }
            if (x.left==null){
                return x.right;
            }
            Node minNode=x.right;
            while (minNode.left!=null){
                minNode=minNode.left;
            }
            Node n=x.right;
            while (n.left!=null){
                if (n.left.left==null){
                    n.left=null;
                }else {
                    n=n.left;
                }
            }
            minNode.left=x.left;
            minNode.right=x.right;
            x=minNode;
        }
        return x;
    }
    //找出整个树种最小的键
    public Key min(){
        return min(root).key;
    }
    public Node min(Node x){
        if (x.left!=null){
            return min(x.left);
        }else {
            return x;
        }
    }
    public Key max(){
        return max(root).key;
    }
    public Node max(Node x){
        if (x.right!=null){
            return max(x.right);
        }else {
            return x;
        }
    }
    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        public Node(Key key,Value value,Node left,Node right){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }
    //前序遍历
    public Queue<Key> preErgodic(){
        Queue<Key> keys=new ArrayDeque<>();
        preErgodic(root,keys);
        return keys;
    }
    public void preErgodic(Node x,Queue<Key> keys){
        if (x==null){
            return;
        }
        keys.add(x.key);
        if (x.left!=null){
            preErgodic(x.left,keys);
        }
        if (x.right!=null){
            preErgodic(x.right,keys);
        }
    }
    //中序遍历
    public Queue<Key> midErgodic(){
        Queue<Key> keys=new ArrayDeque<>();
        midErgodic(root,keys);
        return keys;
    }
    public void midErgodic(Node x,Queue<Key> keys){
        if (x==null){
            return;
        }
        if (x.left!=null){
            midErgodic(x.left,keys);
        }
        keys.add(x.key);
        if (x.right!=null){
            midErgodic(x.right,keys);
        }
    }
    //后序遍历
    public Queue<Key> afterErgodic(){
        Queue<Key> keys=new ArrayDeque<>();
        afterErgodic(root,keys);
        return keys;
    }
    public void afterErgodic(Node x,Queue<Key> keys){
        if (x.left!=null){
            afterErgodic(x.left,keys);
        }
        if (x.right!=null){
            afterErgodic(x.right,keys);
        }
        keys.add(x.key);
    }
    //层序遍历
    public Queue<Key> layerErgodic(){
        Queue<Key> keys=new ArrayDeque<>();
        Queue<Node> nodes=new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            Node node = nodes.poll();
            keys.add(node.key);
            if (node.left!=null){
                nodes.add(node.left);
            }
            if (node.right!=null){
                nodes.add(node.right);
            }
        }
        return keys;
    }
    //树的最大深度
    public int maxDepth(){
        return maxDepth(root);
    }
    public int maxDepth(Node x){
        if (x==null){
            return 0;
        }
        int max=0;
        int maxL=0;
        int maxR=0;
        if (x.left!=null){
            maxL=maxDepth(x.left);
        }
        if (x.right!=null){
            maxR=maxDepth(x.right);
        }
        max=maxL>maxR?maxL+1:maxR+1;
        return max;
    }
    public static void main(String[] args) {
        /*BinaryTree<Integer, String> bt = new BinaryTree<>();
        bt.put(4,"二哈");
        bt.put(1,"张三");
        bt.put(3,"李四");
        bt.put(5,"王五");
        System.out.println(bt.size());
        bt.put(1,"老三");
        System.out.println(bt.get(1));
        System.out.println(bt.size());
        bt.delete(1);
        System.out.println(bt.size());
        System.out.println(bt.min());
        System.out.println(bt.max());*/

        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E","5");
        bt.put("B","2");
        bt.put("G","7");
        bt.put("A","1");
        bt.put("D","4");
        bt.put("F","6");
        bt.put("H","8");
        bt.put("C","3");
//        Queue<String> keys = bt.preErgodic();
        Queue<String> keys = bt.midErgodic();
//        Queue<String> keys = bt.afterErgodic();
//        Queue<String> keys = bt.layerErgodic();
        for (String key:keys){
            String value=bt.get(key);
            System.out.println(key+"----"+value);
        }

        System.out.println(bt.maxDepth());
    }
}
