import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

        int start = 0;
        int dest = 1;
        System.out.println("The shortest path between " + start + " and " + dest + " is " + solution(start,dest));
    }

    public static int solution(int src, int dest){
        int shortest_path_distance = -1;

        Queue<Integer> queue= new LinkedList<>();
        queue.add(src);
        queue.add(-100);
        boolean[] visited_or_not = new boolean[64];
        boolean found;


        int path_dist = 1;
        while(!queue.isEmpty()){
            int val = queue.remove();
            if (val == -100){
                path_dist ++;
                val = queue.remove();
                queue.add(-100);
            }

            found = update_queue(queue, val, dest);

            if (found){
                return path_dist;
            }


        }


        return shortest_path_distance;
    }



    public static boolean update_queue(Queue<Integer> queue, int val, int dest) {
        return false;
    }
}
