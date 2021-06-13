package tree;
//平衡二叉树
import java.util.Comparator;

public class AvlTree<T extends Comparable>{
    private AvlNode tree;

    /**
     * 获取郑课树的高度
     * @return
     */
    public int height(){
        return height(tree);
    }
    /**
     * 返回某一节点的高度
     * @param node
     * @return
     */
    private int height(AvlNode node){
        return node==null?0:node.height;
    }

    /**
     * 返回两个高度中的最大值
     * @param h1
     * @param h2
     * @return
     */
    private int getMax(int h1,int h2){
        return h1>h2?h1:h2;
    }

    /**
     * 打印树
     * @return
     */
    @Override
    public String toString() {
        System.out.println("前序遍历的结果：");
        preOrder(tree);
        System.out.println();
        System.out.println("中序遍历的结果：");
        inOrder(tree);
        System.out.println();
        System.out.println("后序遍历的结果：");
        postOrder(tree);
        return "";
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrder(AvlNode node){
        if (node==null){
            return;
        }
        System.out.print(node.getData()+"->");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    public void inOrder(AvlNode node){
        if (node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.getData()+"-->");
        inOrder(node.right);
    }

    /**
     * 后序遍历
     * @param node
     */
    public void postOrder(AvlNode node){
        if (node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.getData()+"->");
    }

    public static class AvlNode<T extends Comparable>{
        public T data;
        public AvlNode<T> left;
        public AvlNode<T> right;
        public int height;
        protected AvlNode(T data,AvlNode left,AvlNode right,int height){
            this.data=data;
            this.left=left;
            this.right=right;
            this.height=height;
        }
        protected AvlNode(T data,AvlNode<T> left,AvlNode<T> right){
            this(data,left,right,0);
        }
        protected AvlNode(T data){
            this(data,null,null);
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public AvlNode<T> getLeft() {
            return left;
        }

        public void setLeft(AvlNode<T> left) {
            this.left = left;
        }

        public AvlNode<T> getRight() {
            return right;
        }

        public void setRight(AvlNode<T> right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    /**
     * @param node 失衡节点
     * @return 左旋后的根节点
     */
    public AvlNode ll(AvlNode node){
        AvlNode node_left=node.left;
        node.left=node_left.right;
        node_left.right=node;
        //重新计算失衡节点和旋转后节根点的高度
        node.height=getMax(height(node.left),height(node.right))+1;
        node_left.height=getMax(height(node_left.left),height(node_left.right))+1;
        return node_left;
    }
    public AvlNode lr(AvlNode node){
        node.left=rr(node.left);
        AvlNode avlNode = ll(node);
        return avlNode;
    }
    public AvlNode rr(AvlNode node){
        AvlNode node_right=node.right;
        node.right=node_right.left;
        node_right.left=node;
        node.height=getMax(height(node.left),height(node.right))+1;
        node_right.height=getMax(height(node_right.left),height(node_right.right))+1;
        return node_right;
    }
    public AvlNode rl(AvlNode node){
        node.right=ll(node.right);
        AvlNode avlNode = rr(node);
        return avlNode;
    }
    public void insert(T data){
        tree=insert(tree,data);
    }
    private AvlNode insert(AvlNode node,T data){
        if (node==null){
            node=new AvlNode(data);
        }else {
            int compare = data.compareTo(node.getData());
            if (compare>0){
                node.right=insert(node.right,data);
                if (height(node.right)-height(node.left)==2){
                    if (data.compareTo(node.right.getData())>0){
                        node=this.rr(node);
                    }else {
                        node=this.rl(node);
                    }
                }
            }else if (compare<0){
                node.left=insert(node.left,data);
                if (height(node.left)-height(node.right)==2){
                    if (data.compareTo(node.left.getData())>0){
                        node=this.lr(node);
                    }else{
                        node=this.ll(node);
                    }
                }
            }else {
            }
        }
        node.height=getMax(height(node.left),height(node.right))+1;
        return node;
    }

    public static void main(String[] args) {
        AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(8);
        tree.insert(3);
        tree.insert(12);
        tree.insert(9);
        tree.insert(4);
        tree.insert(5);
        tree.insert(7);
        tree.insert(1);
        tree.insert(11);
        tree.insert(17);
        System.out.println(tree);
    }
}
