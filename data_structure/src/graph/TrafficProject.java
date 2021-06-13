package graph;

import java.io.*;

public class TrafficProject {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream("E:/Code-Java/data_/data_structure/src/traffic_project.txt")));
        int number=Integer.parseInt(bf.readLine());
        Graph G=new Graph(number);
        int roadNumber=Integer.parseInt(bf.readLine());
        for (int i = 0; i < roadNumber; i++) {
            String line=bf.readLine();
            int p=Integer.parseInt(line.split(" ")[0]);
            int q=Integer.parseInt(line.split(" ")[1]);
            G.addEdge(p,q);
        }
        DepthFirstSearch search=new DepthFirstSearch(G,9);
        boolean flag1=search.marked(10);
        boolean flag2=search.marked(8);
        System.out.println("9号城市和10号城市是否已相通："+flag1);
        System.out.println("9号城市和8号城市是否已相通："+flag2);
    }
}
