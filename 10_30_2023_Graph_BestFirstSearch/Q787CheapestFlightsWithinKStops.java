import java.util.*;

public class Q787CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // build graph
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights){
            List<int[]> to = map.getOrDefault(flight[0], new ArrayList<>());
            to.add(new int[]{flight[1], flight[2]});
            map.put(flight[0], to);
        }

        // create heap
        PriorityQueue<Cell2> heap = new PriorityQueue<>();
        heap.offer(new Cell2(src, k, 0));

        while(!heap.isEmpty()){
            Cell2 cur = heap.poll();
            if (cur.dst == dst) {
                return cur.price;
            }

            if (cur.stop >= 0 && map.containsKey(cur.dst)) {
                for (int[] next: map.get(cur.dst)) {
                    heap.offer(new Cell2(next[0], cur.stop - 1, cur.price + next[1]));
                }
            }
        }

        return -1;
    }
}

class Cell2 implements Comparable<Cell2>{
    int dst;
    int stop;
    int price;

    Cell2(int dst, int stop, int price) {
        this.dst = dst;
        this.stop = stop;
        this.price = price;
    }

    public int compareTo(Cell2 c2) {
        return price - c2.price;
    }
}
