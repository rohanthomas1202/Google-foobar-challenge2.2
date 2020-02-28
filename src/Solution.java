import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

        int start = 19;
        int dest = 19;
        System.out.println("The shortest path between " + start + " and " + dest + " is " + solution(start, dest));
    }

    public static int solution(int src, int dest) {

        // if the knight is already at the destination
        if (src == dest){
            return 0;
        }

        int shortest_path_distance = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        queue.add(-100);
        boolean[] visited_or_not = new boolean[64];
        boolean found;

        for (int i = 0; i < 64; i++) {
            visited_or_not[i] = false;
        }

        int path_dist = 1;


        while (!queue.isEmpty()) {
            int val = queue.remove();
            if (val == -100) {
                path_dist++;
                val = queue.remove();
                queue.add(-100);
            }

            found = update_queue(queue, val, dest, visited_or_not);

            if (found) {
                return path_dist;
            }


        }


        return shortest_path_distance;
    }


    public static boolean update_queue(Queue<Integer> queue, int val, int dest, boolean[] visited_or_not) {
        int check_val = -1;
        boolean found = false;
        switch (val % 8) {
            // if case '0', the current node is in the first column
            case 0:

                // do not check the following as they have to go left and hence will go out of bounds
                // do not check up two and left one(-17)
                // do not check down two and left one(+15)
                // do not check left two and up one(-10)
                // do not check left two and down one(+6)


                // check for values up two spaces and right one space
                check_val = val - 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values right two spaces and up one space
                check_val = val - 6;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values right two spaces and down one space
                check_val = val + 10;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values down two spaces and right one space
                check_val = val + 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                break;

            // if case '1', the current node is in the second column
            case 1:

                // do not check the following as they have to two left and hence will go out of bounds
                // do not check left two and up one(-10)
                // do not check left two and down one(+6)


                // check for values up two spaces and right one space
                check_val = val - 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values right two spaces and up one space
                check_val = val - 6;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values right two spaces and down one space
                check_val = val + 10;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values down two spaces and right one space
                check_val = val + 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values down two spaces and left one space
                check_val = val + 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values up two spaces and left one space
                check_val = val - 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                break;


            // if case '6', the current node is in the second last column
            case 6:

                // do not check the following as they have to two right and hence will go out of bounds
                // do not check right two and up one(-6)
                // do not check right two and down one(+10)


                // check for values left two spaces and up one space
                check_val = val - 10;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values up two spaces and left one space
                check_val = val - 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values down two spaces and left one space
                check_val = val + 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values left two spaces and down one space
                check_val = val + 6;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values up two spaces and right one space
                check_val = val - 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values down two spaces and right one space
                check_val = val + 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                break;


            // if case '7', the current node is in the last column
            case 7:

                // do not check the following as they have to go right and hence will go out of bounds
                // do not check up two and right one(-15)
                // do not check down two and left one(+17)
                // do not check right two and up one(-6)
                // do not check right two and down one(+10)


                // check for values left two spaces and up one space
                check_val = val - 10;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values up two spaces and left one space
                check_val = val - 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values right two spaces and down one space
                check_val = val + 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values left two spaces and down one space
                check_val = val + 6;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                break;


            // of we reach this level, we are in the center, and can find all 8 possible destination points
            default:


                /*
                Use symmetry of chess board to group possible places knight can be at
                 */

                ///////////////////////////   17   ///////////////////////////
                // check for values up two spaces and left one space
                check_val = val - 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values down two spaces and right one space
                check_val = val + 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }
                ///////////////////////////   17   ///////////////////////////




                ///////////////////////////   15   ///////////////////////////
                // check for values up two spaces and left one space
                check_val = val - 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values down two spaces and right one space
                check_val = val + 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }
                ///////////////////////////   15   ///////////////////////////


                ///////////////////////////   6   ///////////////////////////
                // check for values up two spaces and left one space
                check_val = val - 6;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values down two spaces and right one space
                check_val = val + 6;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }
                ///////////////////////////   6   ///////////////////////////



                ///////////////////////////   10   ///////////////////////////
                // check for values up two spaces and left one space
                check_val = val - 10;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values down two spaces and right one space
                check_val = val + 10;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }
                ///////////////////////////   10   ///////////////////////////

        }
        return false;
    }


    public static boolean check_and_add(Queue<Integer> queue, int check_val, int dest, boolean[] visited_or_not) {
        if (check_val >= 0 && check_val <= 63 && !visited_or_not[check_val]) {


            if (check_val == dest) {
                return true;
            }
            visited_or_not[check_val] = true;
            queue.add(check_val);


        }
        return false;
    }
}
