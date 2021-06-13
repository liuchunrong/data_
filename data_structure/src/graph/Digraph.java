package graph;

import java.util.LinkedList;

//有向图实现
public class Digraph {
    private int V;
    private int E;
    private LinkedList<Integer> [] adj;
    public Digraph(int V){
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
        E++;
    }
    public LinkedList<Integer> adj(int v){
        return adj[v];
    }
    private Digraph reverse(){
        Digraph digraph=new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (Integer w : adj[v]) {
                addEdge(w,v);
            }
        }
        return digraph;
    }

}
