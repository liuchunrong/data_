package graph;

import priority.IndexMinPriorityQueue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

//Prim算法API设计---找到加权无向图的最小生成树
public class PrimMSt {
    private boolean[] marked;
    private Edge[] edgeTo;
    private double[] distTo;
    private IndexMinPriorityQueue<Double> pq;

    public PrimMSt(EdgeWeightGraph G){
        this.edgeTo=new Edge[G.V()];
        this.distTo=new double[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i]=Double.POSITIVE_INFINITY;
        }
        this.marked=new boolean[G.V()];
        this.pq=new IndexMinPriorityQueue<>(G.V());
        distTo[0]=0.0;
        pq.insert(0,0.0);
        while (!pq.isEmpty()){
            visit(G,pq.delMin());
        }
    }
    private void visit(EdgeWeightGraph G,int v){
        marked[v]=true;
        for (Edge e : G.adj(v)) {
            int w=e.other(v);
            if (marked[w]){
                continue;
            }
            if (e.weight()<distTo[w]){
                edgeTo[w]=e;
                distTo[w]=e.weight();
                if (pq.contains(w)){
                    pq.changeItem(w,e.weight());
                }else {
                    pq.insert(w,e.weight());
                }
            }
        }
    }

    public Queue<Edge> edges() {
        Queue<Edge> edges = new ArrayDeque<>();
        for (int i = 0; i < marked.length; i++) {
            if (edgeTo[i]!=null){
                edges.add(edgeTo[i]);
            }
        }
        return edges;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream("E:/Code-Java/data_/data_structure/src/min_create_tree_test.txt")));
        int number=Integer.parseInt(bf.readLine());
        EdgeWeightGraph G=new EdgeWeightGraph(number);
        int roadNumber=Integer.parseInt(bf.readLine());
        for (int i = 0; i < roadNumber; i++) {
            String line=bf.readLine();
            String[] str=line.split(" ");
            int v=Integer.parseInt(str[0]);
            int w=Integer.parseInt(str[1]);
            double weight=Double.parseDouble(str[2]);
            G.addEdge(new Edge(v,w,weight));
        }

        PrimMSt mSt=new PrimMSt(G);
        Queue<Edge> edges = mSt.edges();
        for (Edge edge : edges) {
            if (edge!=null){
                System.out.println(edge.either()+"-"+edge.other(edge.either())+"::"+edge.weight());
            }
        }
    }
}

