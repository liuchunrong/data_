package graph;

import java.util.Stack;

//对有向图进行基于深度优先搜索的顶点（拓扑）排序
public class DepthFirstOrder {
    private boolean[] marked;
    private Stack reversePost;
    public DepthFirstOrder(Digraph G){
        marked=new boolean[G.V()];
        reversePost=new Stack<Integer>();
        for (int v=0;v<G.V();v++){
            if (!marked[v]){
                dfs(G,v);
            }
        }
    }

    private void dfs(Digraph G,int v){
        marked[v]=true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]){
                dfs(G,w);
            }
        }
        reversePost.push(v);
    }
    public Stack<Integer> reversePost(){
        return reversePost;
    }
}
