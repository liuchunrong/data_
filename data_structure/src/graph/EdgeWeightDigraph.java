package graph;

import java.util.ArrayDeque;
import java.util.Queue;

//加权有向图API设计
public class EdgeWeightDigraph {
    private final int V;
    private int E;
    private Queue<DirectedEdge>[] adj;

    public EdgeWeightDigraph(int V){
        this.V=V;
        this.E=0;
        this.adj=new ArrayDeque[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new ArrayDeque<DirectedEdge>();
        }
    }

    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(DirectedEdge e){
        int v=e.from();
        adj[v].add(e);
        E++;
    }
    public Queue<DirectedEdge> adj(int v){
        return adj[v];
    }
    public Queue<DirectedEdge> edges(){
        Queue<DirectedEdge> allEdge=new ArrayDeque<>();
        for (int v=0;v<V;v++){
            for (DirectedEdge edge : adj[v]) {
                allEdge.add(edge);
            }
        }
        return allEdge;
    }
}
