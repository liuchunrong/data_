package graph;

import java.util.LinkedList;
import java.util.Queue;

//无向图
public class UnGraph {
    private int points;
    private LinkedList<Integer> adjacency[];
    public UnGraph(int points){
        this.points=points;
        adjacency=new LinkedList[this.points];
        for (int i=0;i<points;i++){
            adjacency[i]=new LinkedList<Integer>();
        }
    }
    public void addPoint(int s,int t){
        adjacency[s].add(t);
        adjacency[t].add(s);
    }
    //广度优先搜索算法BFS
    public void bfs(int s,int t){
        if (s==t){
            return;
        }
        boolean[] visited=new boolean[this.points];
        visited[s]=true;
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(s);
        int[] prev=new int[this.points];
        for (int i=0;i<prev.length;i++){
            prev[i]=-1;
        }
        while (!queue.isEmpty()){
            Integer p = queue.poll();
            for (int i=0;i<adjacency[p].size();i++){
                Integer p_edge=adjacency[p].get(i);
                if (!visited[p_edge]){
                    prev[p_edge]=p;
                    if (p_edge==t){
                        print(prev,s,t);
                        return;
                    }
                    visited[p_edge]=true;
                    queue.add(p_edge);
                }
            }
        }
    }
//    深度优先搜索算法
    boolean found=false;
    public void dfs(int s,int t){
        if (s==t){
            return;
        }
        boolean[] visited=new boolean[this.points];
        visited[s]=true;
        int[] prev=new int[this.points];
        for (int i=0;i<prev.length;i++){
            prev[i]=-1;
        }
        returnDFS(s,t,visited,prev);
        print(prev,s,t);
    }
    private void returnDFS(int point,int target,boolean[] visited,int[] prev){
        if (found){
            return;
        }
        visited[point]=true;
        if (point==target){
            found=true;
            return;
        }
        for (int i=0;i<adjacency[point].size();i++){
            Integer p_conect = adjacency[point].get(i);
            if (!visited[p_conect]){
                prev[p_conect]=point;
                returnDFS(p_conect,target,visited,prev);
            }
        }
    }
    public void print(int[] prev,int s,int t){
        if (prev[t]!=-1&&s!=t){
            print(prev,t,prev[t]);
        }
        System.out.print(t+">>");



    }
    public static void main(String[] args) {
        UnGraph graph=new UnGraph(8);
        graph.addPoint(0,1);
        graph.addPoint(0,3);
        graph.addPoint(1,2);
        graph.addPoint(1,4);
        graph.addPoint(2,5);
        graph.addPoint(3,4);
        graph.addPoint(4,5);
        graph.addPoint(4,6);
        graph.addPoint(6,7);
        graph.addPoint(7,5);
//        System.out.println(graph);
        graph.bfs(0,6);
        System.out.println();
        graph.dfs(0,6);
    }
}
