package uf;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//并查集应用----城市畅通工程
public class Traffic_Project {
    public static void main(String[] args) throws IOException {
//        BufferedReader bf=new BufferedReader(new InputStreamReader(Traffic_Project.class.getClassLoader().getResourceAsStream("traffic_project.txt")));
        BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream("E:/Code-Java/data_/data_structure/src/traffic_project.txt")));
        int N=Integer.parseInt(bf.readLine());
        UF_Tree_Weighted uf=new UF_Tree_Weighted(N);
        int roadNumber=Integer.parseInt(bf.readLine());
        for (int i=1;i<=roadNumber;i++){
            String line = bf.readLine();
            int p=Integer.parseInt(line.split(" ")[0]);
            int q=Integer.parseInt(line.split(" ")[1]);
            uf.union(p,q);
        }
        int groupNumber=uf.count();
        System.out.println("还需要修建"+(groupNumber-1)+"条道路，城市才能连通");
    }
}
