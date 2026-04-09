
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class MovieFestival {
    
    static class Movie implements Comparable<Movie> {
        private int start;
        private int end;

        public Movie(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + start;
            result = prime * result + end;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Movie other = (Movie) obj;
            if (start != other.start)
                return false;
            if (end != other.end)
                return false;
            return true;
        }

        @Override
        public int compareTo(Movie arg0) {
            return this.end - arg0.getEnd();
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str;
        List<Movie> movieTimings = new ArrayList<>();

        
        while (n-- > 0) {
            str = br.readLine().split(" ");
            movieTimings.add(new Movie(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
        }

        int count = solution(movieTimings);
        System.out.println(count);
    }

    private static int solution(List<Movie> movieTimings) {
        Collections.sort(movieTimings);
        int count = 0, currentTime = -1;

        for (Movie movie : movieTimings) {
            if (currentTime == -1) {
                currentTime = movie.getEnd();
                count++;
            } else if (currentTime <= movie.getStart()) {
                currentTime = movie.getEnd();
                count++;
            }
        }

        return count;
    }
}