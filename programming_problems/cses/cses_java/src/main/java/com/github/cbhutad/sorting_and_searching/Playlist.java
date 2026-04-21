import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Playlist {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int index = 0;
        
        for (String str : br.readLine().split(" ")) {
            nums[index++] = Integer.parseInt(str);
        }

        int count = solution(n, nums);
        System.out.println(count);
    }

    private static int solution(int n, int[] nums) {
        int max = 0;
        int left = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int right = 0; right < n;right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                left++;
            } 
            set.add(nums[right]);
            max = Math.max(max, right - left + 1);
        }
        

        return max;

    } 
}
