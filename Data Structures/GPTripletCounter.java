import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long,Long> map = new HashMap<Long,Long>();
        HashMap<Long,Long> freq = new HashMap<Long,Long>();
        long count = 0;
        
        for(long i: arr){
            if(freq.get(i)!=null){
                freq.replace(i,freq.get(i)+1);
            } else {
                freq.put(i,(long)1);
            }
        }
        
        for(long i: arr){
            freq.replace(i,freq.get(i)-1);
            if(i%r == 0 && map.get(i/r)!=null && freq.get(i*r)!= null ){
                count += map.get(i/r) * freq.get(i*r);
            }
            
            if(map.get(i)!=null){
                map.replace(i,map.get(i)+1);
            } else {
                map.put(i,(long)1);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
