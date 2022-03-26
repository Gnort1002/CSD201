public class Main {

    public static void main(String[] args) throws Exception {
        int INF = 1000;
        int [][] b = {
            {0, 1, 0, 0, 1 ,0, 1}, 
            {1, 0, 1, 1, 1 ,0, 0}, 
            {0, 1, 0, 1, 0 ,1, 0},
            {0, 1, 1, 0, 0 ,1, 0},
            {1, 1, 0, 0, 0 ,0, 1}, 
            {0, 0, 1, 1, 0 ,0, 1},
            {1, 0, 0, 0, 1 ,1, 0}
        };
        int [][] c = {
            {0, 1, 4, INF, INF, INF},
            {1, 0, 2, INF, INF, INF},
            {4, 2, 0, 1, INF, INF},
            {INF, INF, 1, 0, INF, INF},
            {INF, INF, INF, INF, 0, 6},
            {INF, INF, INF, INF, 6, 0}
            
        };
        Graph h = new Graph();
        h.setData(c);
        h.dijkstra(3, 0);
//        Graph g = new Graph();
//        g.setData(b);
//        System.out.println("The connections between vertices: ");
//        g.displayGraph();
//        System.out.println("BFS from A:");
//        g.breadth1(g.convert('A'));
//        System.out.println("DFS from the 5th vertex");
//        g.depth(g.convert('A'));
//        System.out.print("The number of components: ");
//        System.out.println(g.countComponent());
    }
}
    

