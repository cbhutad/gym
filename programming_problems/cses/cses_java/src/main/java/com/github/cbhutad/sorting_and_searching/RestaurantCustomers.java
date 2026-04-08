
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RestaurantCustomers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str;
        int[] arrivals = new int[n]; 
        int[] departures = new int[n];
        long count = 0, maxCount = 0;

        for(int i = 0;i < n;i++) {
            str = br.readLine().split(" ");
            
            Integer min = Integer.parseInt(str[0]);
            Integer max = Integer.parseInt(str[1]);

            arrivals[i] = min;
            departures[i] = max;

        }

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int ptr1 = 0, ptr2 = 0;

        while (ptr1 < n && ptr2 < n) {
            if (arrivals[ptr1] < departures[ptr2]) {
                count++;
                ptr1++;
            } else {
                ptr2++;
                if (count > maxCount) {
                    maxCount = count;
                }
                count--;
            }
        }

        if (count > maxCount) {
            maxCount = count;
        }

        System.out.println(maxCount);

    }
}
