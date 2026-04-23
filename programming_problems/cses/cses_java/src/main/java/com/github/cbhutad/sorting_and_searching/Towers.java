import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Towers {

    private static final List<Integer> towers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        while (n-- > 0) {
            int tower = Integer.parseInt(tokenizer.nextToken());
            int pos = upperbound(tower);

            if (pos == towers.size()) {
                towers.add(tower);
            } else {
                towers.set(pos, tower);
            }
        }

        System.out.println(towers.size());
        
    }

    private static int upperbound(int n) {
        int left = 0, right = towers.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (towers.get(mid) > n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }
}
