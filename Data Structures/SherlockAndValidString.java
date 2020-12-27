import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        char [] char_s = s.toCharArray();
        int [] freq = new int[26];
        int min = s.length()+1;
        int max =-1;
        int unique_char = 26;
        int nummin = 0;
        int nummax = 0;
        for(char c: char_s){
            freq[c-97] +=1;
        }
        for(int i: freq){
            System.out.println(i);
            unique_char -= i==0?1:0;
            min = min > i && i!=0? i:min;
            max = max < i? i:max; 
        }
        for(int i: freq){
            nummin += i == min? 1:0;
            nummax += i == max? 1:0;
        }
        System.out.println(unique_char);
        
        return (max == min) || ((max-min <2) || (min ==1 && nummin == 1)) && 
        ( (min*(unique_char-1) + max == s.length()  && (nummax == 1 )) || 
        (max*(unique_char-1) + min == s.length() && (nummin == 1 )))?"YES":"NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
