package uf;

import java.util.Scanner;

//并查集
public class UF {
    private int[] eleAndGroup;
    private int count;
    public UF(int N){
        this.eleAndGroup=new int[N];
        this.count=N;
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i]=i;
        }
    }
    public int count(){
        return this.count;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public int find(int p){
        return eleAndGroup[p];
    }
    public void union(int p,int q){
        if (connected(p,q)){
            return;
        }
        int pGroup=eleAndGroup[p];
        int qGroup=eleAndGroup[q];
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i]==pGroup){
                eleAndGroup[i]=qGroup;
            }
        }
        count--;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请录入并查集中元素的个数：");
        int N=sc.nextInt();
        UF uf=new UF(N);
        while (true){
            System.out.println("请录入您要合并的第一个点：");
            int p=sc.nextInt();
            System.out.println("请录入您要合并的第二个点：");
            int q=sc.nextInt();
            if (uf.connected(p,q)){
                System.out.println("节点"+p+"和节点"+q+"已经在同一个组");
                continue;
            }
            uf.union(p,q);
            System.out.println("总共还有"+uf.count+"个分组");
        }
    }
}
