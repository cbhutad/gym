import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubarraySumsI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int s = Integer.parseInt(str[1]);
        int[] nums = new int[n];

        str = br.readLine().split(" ");

        for (int i = 0;i < n;i++) {
           nums[i] = Integer.parseInt(str[i]); 
        }

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0;right < n;right++) {
            sum += nums[right];

            while (sum > s) {
                sum -= nums[left];
                left++;
            }

            if (sum == s) {
                count++;
            }
        }

        System.out.println(count);
    }
}