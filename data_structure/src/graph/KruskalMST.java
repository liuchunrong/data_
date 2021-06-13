package graph;

import priority.MinPriorityQueue;
import uf.UF_Tree_Weighted;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalMST {
    //保存最小生成树的所有边
    private Queue<Edge> mst;
    //索引代表顶点，使用uf.connect(v,w)可以判断顶点v和顶点w是否在同一颗树中，使用uf.union(v,w)可以把顶点v所在的树和顶点w所在的树合并
    private UF_Tree_Weighted uf;
    //存储图中所有的边，使用最小优先队列，对边按照权重进行排序
    private MinPriorityQueue<Edge> pq;

    //根据一副加权无向图，创建最小生成树计算对象
    public KruskalMST(EdgeWeightGraph G) {
        //初始化mst队列
        this.mst = new ArrayDeque<>();
        //初始化并查集对象uf,容量和图的顶点数相同
        this.uf = new UF_Tree_Weighted(G.V());
        //初始化最小优先队列pq，容量比图的边的数量大1，并把图中所有的边放入pq中
        this.pq = new MinPriorityQueue<>(G.E()+1);
        for (Edge edge : G.edges()) {
            pq.offer(edge);
        }
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            //取出pq中权重最小的边e
            Edge e = pq.poll();
            //获取边e的两个顶点v和w
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v,w)){
                continue;
            }

            uf.union(v,w);
            mst.add(e);
        }
    }

    //获取最小生成树的所有边
    public Queue<Edge> edges() {
        return mst;
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
        KruskalMST mst=new KruskalMST(G);
        Queue<Edge> edges = mst.edges();
        for (Edge edge : edges) {
            if (edge!=null){
                System.out.println(edge.either()+"-"+edge.other(edge.either())+"-"+edge.weight());
            }
        }
    }
}

/*
1-7::0.19
0-2::0.26
2-3::0.17
4-5::0.35
5-7::0.28
6-2::0.4
0-7::0.16
 */
