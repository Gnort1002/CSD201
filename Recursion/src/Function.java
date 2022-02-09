public class Function {
    public static int sumOfN(int n){
        if (n==1) return 1;
        return sumOfN(n-1) + n;
    }
    
    public static int findMin(int A[], int n){
      if(n == 1)
        return A[0];         
        return Math.min(A[n-1], findMin(A, n-1));        
    }    
    
    public static int findSum(int A[], int N){
        if (N <= 0) return 0;
        return (findSum(A, N - 1) + A[N - 1]);
    }    
    static int isPalindrome(char arr[], int n){
        int size = arr.length;
        if (n == size/2) return 1;
        else if (arr[size-n] != arr[n-1]) return 0;
        else return isPalindrome(arr, n-1);
    }    
    
    public static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }

        return -1;
    }


    static int gcd(int a, int b)
    {

        if (a == 0)
          return b;
        if (b == 0)
          return a;
      
        if (a == b)
            return a;
      
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
    
    public static int power(int x, int n) {
        if (x != 0) {
            return (x * power(x, n - 1));
        }
        else {
            return 1;
        }
    }  
    
    public static long fact(int n){
        if (n<=1) return 1;
        return n*fact(n-1);
    }
    
    public static long fib(int n){
        if (n<=2) return 1;
        return fib(n-1) + fib(n-2);
    }
    
    public static double addReciprocals(int n){
        if (n == 1) return 1;
        return addReciprocals(n-1) + 1/n;
    }  
    
    static long s(int n, int k){
        if (k == 0 && n == 0) return 1;
        else if (n > 0 && k == 0) return 0;
        else if (k > n) return 0;
        else return s(n-1, k-1) - (n-1)*s(n-1, k);
    }

    
    
}
