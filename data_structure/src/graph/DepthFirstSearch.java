package graph;

//深度优先搜索
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G,int s){
        this.marked=new boolean[G.V()];
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        marked[v]=true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]){
                dfs(G,w);
            }
        }
        count++;
    }
    public int count(){
        return count;
    }
    public boolean marked(int w){
        return marked[w];
    }

    //深度优先搜索测试
    public static void main(String[] args) {
        Graph G=new Graph(13);
        G.addEdge(0,5);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(5,3);
        G.addEdge(5,4);
        G.addEdge(3,4);
        G.addEdge(4,6);
        G.addEdge(7,8);
        G.addEdge(9,11);
        G.addEdge(9,10);
        G.addEdge(9,12);
        G.addEdge(11,12);

        DepthFirstSearch search=new DepthFirstSearch(G,0);
        //和0相通的顶点数量(相通指直接相连或间接相通)
        System.out.println("和0相通的顶点数量"+search.count);
        //测试某个顶点与起点是否相通
        System.out.println("顶点5和顶点0是否相通："+search.marked(5));
        System.out.println("顶点7和顶点0是否相通："+search.marked(7));
    }
}
