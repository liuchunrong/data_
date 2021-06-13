package graph;

import priority.IndexMinPriorityQueue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

//最短路径树（求加权有向图中A点到B点的最短路径）
public class DijkstraSP {
    //索引代表顶点，值表示从顶点s到当前顶点的最短路径上的最后一条边
    private DirectedEdge[] edgeTo;
    //索引代表顶点，值从顶点s到当前顶点的最短路径的总权重
    private double[] distTo;

    //存放树中顶点与非树中顶点之间的有效横切边
    private IndexMinPriorityQueue<Double> pq;

    //根据一副加权有向图G和顶点s，创建一个计算顶点为s的最短路径树对象
    public DijkstraSP(EdgeWeightDigraph G, int s){
        //创建一个和图的顶点数一样大小的DirectedEdge数组，表示边
        this.edgeTo = new DirectedEdge[G.V()];
        //创建一个和图的顶点数一样大小的double数组，表示权重，并且初始化数组中的内容为无穷大，无穷大即表示不存在这样的边
        this.distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        //创建一个和图的顶点数一样大小的索引优先队列，存储有效横切边
        this.pq = new IndexMinPriorityQueue<>(G.V());
        //默认让顶点s进入树中，但s顶点目前没有与树中其他的顶点相连接，因此初始化distTo[s]=0.0
        distTo[s] = 0.0;
        //使用顶点s和权重0.0初始化pq
        pq.insert(s, 0.0);
        //遍历有效边队列
        while (!pq.isEmpty()) {
            //松弛图G中的顶点
            relax(G, pq.delMin());
        }
    }

    private void relax(EdgeWeightDigraph G,int v){
        for (DirectedEdge edge : G.adj(v)) {
            int w=edge.to();
            if (distTo[v]+edge.weight()<distTo[w]){
                distTo[w]=distTo[v]+edge.weight();
                edgeTo[w]=edge;
                if (pq.contains(w)){
                    pq.changeItem(w,distTo[w]);
                }else {
                    pq.insert(w,distTo[w]);
                }
            }
        }
    }
    public boolean hasPathTo(int v){
        return distTo[v]<Double.POSITIVE_INFINITY;
    }
    public double distTo(int v){
        return distTo[v];
    }
    public Queue<DirectedEdge> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        Queue<DirectedEdge> edges=new ArrayDeque<>();
        DirectedEdge e=null;
        while (true){
            e=edgeTo[v];
            if (e==null){
                break;
            }
            edges.add(e);
            v=e.from();
        }
        return edges;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream("E:/Code-Java/data_/data_structure/src/min_route_test.txt")));
        int number=Integer.parseInt(bf.readLine());
        EdgeWeightDigraph G=new EdgeWeightDigraph(number);
        int edgeNumber=Integer.parseInt(bf.readLine());
        for (int i = 0; i < edgeNumber; i++) {
            String line=bf.readLine();
            String[] str = line.split(" ");
            int v=Integer.parseInt(str[0]);
            int w=Integer.parseInt(str[1]);
            double weight=Double.parseDouble(str[2]);
            G.addEdge(new DirectedEdge(v,w,weight));
        }

        DijkstraSP dsp=new DijkstraSP(G,0);
        Queue<DirectedEdge> edges = dsp.pathTo(6);
        for (DirectedEdge edge : edges) {
            System.out.print(edge.from()+"->"+edge.to()+"::"+edge.weight()+" ");
        }
    }
}

