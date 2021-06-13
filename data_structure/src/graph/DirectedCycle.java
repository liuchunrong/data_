package graph;
//检测有向图中是否有环---基于深度优先搜索（没有环才可以进行拓扑排序）
public class DirectedCycle {
    private boolean[] marked;
    private boolean hasCycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph G){
        this.marked=new boolean[G.V()];
        this.hasCycle=false;
        this.onStack=new boolean[G.V()];
        for (int v=0;v<G.V();v++){
            if (!marked[v]){
                dfs(G,v);
            }
        }
    }

    private void dfs(Digraph G,int v){
        marked[v]=true;
        onStack[v]=true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]){
                dfs(G,w);
            }
            if (onStack[w]){
                hasCycle=true;
                return;
            }
        }
        onStack[v]=false;
    }
    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args) {
        Digraph G=new Digraph(5);
        G.addEdge(3,0);
        G.addEdge(0,2);
        G.addEdge(2,1);
        G.addEdge(1,4);
        G.addEdge(1,0);

        DirectedCycle cycle=new DirectedCycle(G);
        System.out.println(cycle.hasCycle);
    }
}
