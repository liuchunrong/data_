package graph;

import java.util.LinkedList;

//无向图实现
public class Graph {
    //定点的数目
    private int V;
    //边的数目
    private int E;
    //邻接表
    private LinkedList<Integer>[] adj;
    public Graph(int V){
        this.V=V;
        this.E=0;
        this.adj=new LinkedList[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new LinkedList<Integer>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public LinkedList<Integer> adj(int v){
        return adj[v];
    }







}
