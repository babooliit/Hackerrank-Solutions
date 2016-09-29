import java.io.*;
import java.util.*;

public class Knapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while(testCase-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n+1];
            arr[0] = 0;
            for(int i=0,j=0;i<n;i++){
                int a = sc.nextInt();
                boolean present = false;
                for(int x=0;x<=j;x++){
                    if(arr[x] == a){
                        present = true;
                        break;
                    }
                }
                if(!present){
                    arr[++j] = a;
                }
            }
            Arrays.sort(arr);
            int length = arr.length;
            int t[][] = new int[length][k+1];
            int value[] = new int[k+1];
            for(int j=0;j<k+1;j++){
                value[j] = j;
                t[0][j] = 0;
            }
            for(int i=0;i<length;i++){
                t[i][0] = 0;
            }

            for(int i=1;i<length;i++){
                for(int j=1;j<k+1;j++){
                    if(value[j] >= arr[i]){
                        t[i][j] = Math.max(t[i-1][j],arr[i]+t[i][j-arr[i]]);
                    }
                    else{
                        t[i][j] = t[i-1][j];
                    }
                }
            }

            System.out.println(t[length-1][k]);
        }

    }
}