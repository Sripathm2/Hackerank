import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    static int [][] arr; 
    static int commonChild(String s1, String s2) {
        arr = new int[s1.length()][s2.length()];
        for (int[] row: arr)
            Arrays.fill(row, -2);
        return commonSubString(s1, s2, 0, 0);
    }
    
    static int commonSubString(String s1, String s2, int i, int j){
        if(i == s1.length() || j == s2.length()){
            return 0;
        } else if(arr[i][j]!= -2) {
            return arr[i][j];
        } else if(s1.charAt(i) == s2.charAt(j)){
            arr[i][j] = 1 + commonSubString(s1, s2, i+1, j+1);
            return arr[i][j] ;
        } else {
            int pos1 = s2.indexOf(s1.charAt(i), j);
            int n1 = (pos1!= -1)? commonSubString(s1, s2, i, pos1): -1;
            
            int pos2 = s1.indexOf(s2.charAt(j), i);
            int n2 = (pos2!= -1)? commonSubString(s1, s2, pos2, j): -1;
            
            arr[i][j] = n1 == -1 && n2 == -1?
            commonSubString(s1, s2, i+1, j+1) : 
            Math.max(n1,Math.max(n2,commonSubString(s1, s2, i+1, j+1)));
            return arr[i][j] ;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
