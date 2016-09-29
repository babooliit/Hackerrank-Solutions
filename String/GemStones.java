/**
 * Created by Hemant on 25-09-2016.
 */
import java.io.*;
import java.util.*;

public class GemStones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[26];
        for(int i=0;i<n;i++){
            String s = sc.next();
            char [] c = s.toCharArray();
            Arrays.sort(c);
            System.out.println(c);

            array[c[0]-'a']++;
            for(int j=1;j<c.length;j++){
                if(c[j]!=c[j-1]){
                    array[c[j]-'a']++;
                }
            }

        }
        int count = 0;
        for(int i=0;i<26;i++){
            System.out.println(array[i]+" ");
            if(array[i]==n){
                count++;
            }
        }
        System.out.println(count);
    }
}
