package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearch {
    private int count;
    private boolean[] marked;
    private Queue<Integer> waitSearch;
    public BreadthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        waitSearch = new ArrayDeque<>();
        bfs(G, s);
    }

    public void bfs(Graph G,int v){
        marked[v]=true;
        waitSearch.add(v);
        while(!waitSearch.isEmpty()){
            Integer wait = waitSearch.poll();
            for (Integer w : G.adj(wait)) {
                if (!marked[w]) {
                    bfs(G, w);
                }
            }
        }
        //相通的顶点数量+1
        count++;
    }
    public boolean marked(int w){
        return marked[w];
    }
    public int count(){
        return count;
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

        BreadthFirstSearch search=new BreadthFirstSearch(G,0);
        System.out.println(search.count);
    }


}
