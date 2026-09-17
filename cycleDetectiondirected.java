// DFS+Stack=recursion 
import java.util.*;
public class cycleDetectiondirected {
     static class Edge{
        int src;
        int dest;
       
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
           
        }
    }
     public static void createGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

    
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,3));
    }
    public static boolean isCycle(ArrayList<Edge>graph[]){
        boolean vis[]=new boolean[graph.length];
        boolean Stack[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleUtil(graph,i,vis,Stack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge>graph[],int curr,boolean vis[],boolean Stack[]){
        vis[curr]=true;
        Stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(Stack[e.dest]){//cycle
                return true;
            }
            if(!vis[curr] && isCycleUtil(graph,e.dest,vis,Stack)){
                return true;
            }
        }
        Stack[curr]=false;
        return false;

    }
    public static void main(String args[]){
        int v=4;
        ArrayList<Edge>graph[]=new ArrayList[v];
        createGraph(graph);
        System.out.print(isCycle(graph));
    }
    
}
