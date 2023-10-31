import java.util.*;

public class Q127WordLadder {
    private Map<String, List<String>> constructGraph(List<String> wordList) {
        int size = wordList.size();
        Map<String, List<String>> graph;
        graph = new HashMap<String, List<String>>();

        for (int i=0; i < size; i++) {
            for (int j=i+1; j < size; j++) {
                String w1 = wordList.get(i);
                String w2 = wordList.get(j);

                if (oneDiff(w1, w2)) {
                    graph.computeIfAbsent(w1, k -> new LinkedList<>()).add(w2);
                    graph.computeIfAbsent(w2, k -> new LinkedList<>()).add(w1);
                }
            }
        }

        return graph;
    }

    private static boolean oneDiff(String w1, String w2) {
        int len = w1.length();
        int numDiff = 0;
        for (int i=0; i < len; i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);
            if (c1 != c2) {
                numDiff++;
            }
        }
        if (numDiff == 1){
            return true;
        } else {
            return false;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        Map<String, List<String>> graph = constructGraph(wordList);

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.offer(beginWord);

        int cost = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return cost;
                }

                for (String neighbor: graph.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        // not visited it yet
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            cost++;
        }

        return 0;
    }

}
