import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        char [] char_a = a.toCharArray();
        char [] char_b = b.toCharArray();
        int [][] char_count = new int[26][2];
        int count = 0;
        for(char c: char_a){
            char_count[(c-97)][0] += 1;
        }
        for(char c: char_b){
            char_count[(c-97)][1] += 1;
        }
        for(int [] arr : char_count){
            count += Math.abs(arr[0]-arr[1]);
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
