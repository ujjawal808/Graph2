import java.util.*;
public class detectCycle {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int wt){
            this.src=s;
            this.dest=d;
            this.wt=wt;
        }
    }
     public static void createGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));
    
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));

    }
    public static boolean detectCycle(ArrayList<Edge>graph[]){
        boolean isVisited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!isVisited[i]){
                if(detectCycleUtil(graph,i,-1,isVisited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>graph[],int curr,int par,boolean isVisited[]){
        isVisited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            // Case 3-> Not visited
            if(!isVisited[e.dest]){
                if(detectCycleUtil(graph, e.dest,curr , isVisited)){
                    return true;
                }
            }
            // Case 1-> visited but not parent 
            else if(isVisited[e.dest] && e.dest!=par){
                return true;
            }
        }
        // Case-2> visited and parent [continue].
        return false;
    }
    public static void main(String args[]){
        int v=7;
        ArrayList<Edge>graph[]=new ArrayList[v];
        createGraph(graph);
        System.out.print(detectCycle(graph));
    }
    
}
