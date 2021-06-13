package graph;

import java.io.*;
import java.util.Stack;

//基于深度优先搜索的路径查找
public class DepthFirstPaths {
    private boolean[] marked;
    private int s;
    private int[] edgeTo;

    public DepthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s=s;
        dfs(G,s);
    }

    private void dfs(Graph G, int v){
        marked[v]=true;
        for (Integer w : G.adj(v)){
            if (!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Stack<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v;x!=s;x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream("E:/Code-Java/data_/data_structure/src/road_find.txt")));
        int number=Integer.parseInt(bf.readLine());
        Graph G=new Graph(number);
        int roadNumber=Integer.parseInt(bf.readLine());
        for (int i = 0; i < roadNumber; i++) {
            String line=bf.readLine();
            int v=Integer.parseInt(line.split(" ")[0]);
            int w=Integer.parseInt(line.split(" ")[1]);
            G.addEdge(v,w);
        }

        DepthFirstPaths paths=new DepthFirstPaths(G,0);
        Stack<Integer> path=paths.pathTo(4);
        StringBuilder sb=new StringBuilder();
        for (Integer v : path) {
            sb.append(v+"-");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());


    }
}
