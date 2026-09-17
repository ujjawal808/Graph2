// Dijkstra algo used Greedy Approach
// Aim is to find the shortest distance from src to all the vertices.
import java.util.*;
public class dikstraAlgo {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));
        graph[2].add(new Edge(2,4,3));
        graph[3].add(new Edge(3,5,1));
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }
    // 1.Create Pair class that automatically arranges them in ascending order
    static class Pair implements Comparable<Pair>{
        int n;
        int cost;
        public Pair(int n,int cost){
            this.n=n;
            this.cost=cost;
        }
    
    @Override
    public int compareTo(Pair p2){
        return this.cost-p2.cost;
    }
}
public static void dijkstra(ArrayList<Edge>graph[],int src){
    int distance[]=new int[graph.length];
    // 2.Give infinty value to all the dest/vertices except src
    for(int i=0;i<graph.length;i++){
        if(i!=src){
            distance[i]=Integer.MAX_VALUE;
        }
    }
    boolean isVis[]=new boolean[graph.length];
    // 3.Make a PQ and add new pair(src,0) to it
    PriorityQueue<Pair>pq=new PriorityQueue<>();
    pq.add(new Pair(src,0));

    //bfs
    //4. while pq not empty-
    //(a) take out current pair
    //(b) check its visited, if not visited then find its neighbours and assign values to u,v,wt
    //(c) compare the distance of v with existing and update it accordingly
    //(d) add new pair to pq (neighbour v, its updated cost/dist)
    while(!pq.isEmpty()){
        Pair curr=pq.remove();
        if(!isVis[curr.n]){
            isVis[curr.n]=true;
            for(int i=0;i<graph[curr.n].size();i++){
                Edge e=graph[curr.n].get(i);
                int u=e.src;
                int v=e.dest;
                int w=e.wt;
                // 4.check if the value from src to other side is smaller then the src to dest direct 
                if(distance[u]+w<distance[v]){
                    distance[v]=distance[u]+w;
                    pq.add(new Pair(v,distance[v]));//dest node ,cost.
                }
            }
        }


    }
    //5.print all the distance
    for(int i=0;i<distance.length;i++){
        System.out.print(distance[i]+" ");
    }
    System.out.println();
}
public static void main(String args[]){
    int v=6;
    ArrayList<Edge>graph[]=new ArrayList[v];
    createGraph(graph);
    dijkstra(graph,0);
}

    
}