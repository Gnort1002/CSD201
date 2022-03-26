
import Queue.MyQueue;

public class Graph {
    int n; //so luong dinh
    int[][] a; //ma tran lien ke, quan he giua cac dinh
    char[] v; //ten cua cac dinh
    int INF = 1000;
    Graph(){
        v = "ABCDEFGHIJKLMN".toCharArray();
    }

    void setData(int[][] b) {
        n = b.length;
        a = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = b[i][j];
    }
    
    
    void setAMatrix(int [][] b, int m){
        setData(b);
        this.n = m;
    }
    
    void setLabel(String [] c){
        v = new char[c.length];
        String d = "";
        for (int i = 0; i < c.length; i++)
            d += c[i];
        v = d.toCharArray();
    }
            
    void displayGraph(){
        for (int i = 0; i < n; i++){
            System.out.print(v[i] + ": ");
            for (int j = 0; j< n; j++)
                if (a[i][j] != 0)
                    System.out.print(v[j] + " ");
            System.out.println("");
        }
    }
    void visit(int h){
        System.out.print(v[h] + " ");
    }
    
    int convert(char s){
        for(int i = 0; i < n; i++){
            if(v[i] == s) return i;
        }
        return -1;
    }
    void breadth(boolean[] enqueued, int k){
        
    }
    void breadth(int k) throws Exception{
        MyQueue q = new MyQueue();int i,h;
        boolean [] enqueued = new boolean[n]; //Đánh dấu đỉnh i đã được đưa vào queue chưa
        for(i=0;i<n;i++) enqueued[i]=false; //khởi tạo các đỉnh chưa đưa vào queue
        q.enQueue(new Integer(k));enqueued[k]=true; //duyệt từ đỉnh k với trạng thái đánh dấu
        while(!q.isEmpty()){  
            h=Integer.parseInt((q.deQueue()).toString().trim());
            visit(h); 
            for(i=0;i<n;i++)
            if((!enqueued[i]) && a[h][i]>0)
            {q.enQueue(new Integer(i));
             enqueued[i] = true;
            }
        }
        System.out.println();     
    }

    void breadth1(int k) throws Exception{
        MyQueue q = new MyQueue();int i,h;
        boolean [] enqueued = new boolean[n]; //Đánh dấu đỉnh i đã được đưa vào queue chưa
        for(i=0;i<n;i++) enqueued[i]=false; //khởi tạo các đỉnh chưa đưa vào queue
        q.enQueue(new Integer(k));enqueued[k]=true; //duyệt từ đỉnh k với trạng thái đánh dấu
        while(!q.isEmpty()){  
            h=Integer.parseInt((q.deQueue()).toString().trim());
            visit(h); 
            for(i=0;i<n;i++)
            if((!enqueued[i]) && a[h][i]>0)
            {q.enQueue(new Integer(i));
             enqueued[i] = true;
            }
        }
        System.out.println();   
        for(i = 0; i < n; i++){
            if (enqueued[i] == false) System.out.print(v[i] + " ");
        }
        System.out.println("");
    }
    
    void breadth() throws Exception{
        breadth(0);
    }
    
    //int count = 0 (used when we need visit in range)
    void depth(boolean visited[], int i){
        //If (count >= start && count <= end)
        visit(i);
        //count++;
        visited[i] = true; 
        int j;
        for(j=0;j<n;j++)
            if(a[i][j]>0 && (!visited[j]))
                depth(visited,j);
   }

    void depthNotPrint(boolean visited[], int i){
        visited[i] = true; 
        int j;
        for(j=0;j<n;j++)
            if(a[i][j]>0 && (!visited[j]))
                depthNotPrint(visited,j);
    }
    
    void depth(int k){
        int i; boolean [] visited = new boolean[20];
        for(i=0;i<n;i++) visited[i]=false;
        depth(visited,k);
        for(i=0;i<n;i++) 
            if(!visited[i]){
                System.out.println();
                depth(visited,i);
            } 
        System.out.println("");
   }
    
    int countComponent(){
        int numOfComponent = 1;
        int i; boolean [] visited = new boolean[20];
        for(i=0;i<n;i++) visited[i]=false;
        depthNotPrint(visited,0);
        for(i=0;i<n;i++) 
            if(!visited[i]){
                numOfComponent ++;
                depthNotPrint(visited,i);
            }         
        return numOfComponent;
    }
    
    boolean isConnected(){
        return countComponent() == 1;
    }
    
    int degree(int i) { // Bac cua 1 dinh nao do
        int s, j;
        s = 0;
        for (j = 0; j < n; j++) s += a[i][j];
        s += a[i][i];
        return s;
    }    
    
     boolean isUndirected() { // The adjacency matrix should be symmetric
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] != a[j][i]) return false;
        return true;
    }
     
    boolean isAllEvenDegree() {
        int bac;
        for (int i = 0; i < n; i++) {
            bac = 0;
            for (int j = 0; j < n; j++) bac += a[i][j];
            if (bac % 2 == 1) return false;
        }
        return true;
    }
    
    void dijkstra(int startVertex, int endVertex){
        boolean [] checked = new boolean[n]; //danh dau dinh da duoc xac dinh hay chua
        int [] d = new int[n]; //khoang cach tu dinh startV den dinh i
        int [] previous = new int[n]; //luu dinh truoc dinh i
        int min_d;
        for (int i = 0; i < n; i++)
            checked[i] = false;
        
        for (int i = 0; i < n; i++)
            d[i] = INF;
        
        d[startVertex] = 0;
        
        for (int i = 0; i < n; i++)
            previous[i] = -1;
        
        int u = startVertex; 
        while (u != -1){
            checked[u] = true;
            for (int i = 0; i < n; i++){
                if(!checked[i] && (d[i] > d[u] + a[u][i])){
                    d[i] = d[u] + a[u][i];
                    previous[i] = u;
                }
            }
            min_d = INF;
            u = -1;
            for (int i = 0; i < n; i++)
                if (!checked[i] && (d[i] < min_d)){
                    min_d = d[i];
                    u = i;
                }
            if (u == endVertex) u = -1;
        }
        displayPath(startVertex, endVertex, d[endVertex], previous);
    }

    void displayPath(int startVertex, int endVertex, int d, int[] p) {
        if (d == INF){
            System.out.println("No path from " + v[startVertex] + " to " + v[endVertex] + ". ");
            return;
        }
        System.out.println("The shortest dustance from " + v[startVertex]
                            + " to " + v[endVertex] + " is " + d);
        MyStack s = new MyStack();
        int u = endVertex;
        while (u != -1){
            s.push(u);
            u = p[u];
        }
        u = (int) s.pop();
        System.out.print(v[u]);
        while (!s.isEmpty()){
            u = (int) s.pop();
            System.out.print(" -> " + v[u]);
        }
        System.out.println("");
    }
    
    public void euler() {
        MyStack ms = new MyStack();
        ms.push(0);
        int [] e = new int[20];
        int ne = 0;
        while(!ms.isEmpty()) {
            int r = (int) ms.top();
            //neu r la dinh co lap -> ket nap r vao e, xoa r khoi ngan xep
            //nguoc lai, tim i la dinh dau tien co canh noi voi r
            //xoa canh noi r va i, ket nap i vao ngan xep
            int i = 0;
            while(i < n && a[r][i] == 0) i++;
            if(i == n) {//r la dinh co lap
             e[ne] = r;ms.pop();ne++;
            }
            else {a[r][i]--; a[i][r]--; ms.push(i);}
        }
        for (int i = 0; i < ne; i++) {
            System.out.print(v[e[i]] + "  ");
            }
        System.out.println("");
    }

}
