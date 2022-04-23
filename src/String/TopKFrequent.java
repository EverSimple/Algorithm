package String;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public String[] topKFrequent(String[] combo, int k) {
        //corner case
        if (combo.length == 0 || k == 0) {
            return new String[]{};
        }
        //step 1: get freq for each word in combo
        Map<String, Integer> freqMap = getFreqMap(combo);
        //step 2: find top k freq words from map
        //use minHeap to store top k freq so far
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>
                (k, new Comparator<Map.Entry<String, Integer>>(){
                    @Override
                    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                        return e1.getValue().compareTo(e2.getValue());
                    }
                });
        // iterate over freqMap
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            //put k entry in first
            if (minHeap.size() < k) {
                minHeap.offer(entry);//after k, compare with top elem in the heap
            } else if (minHeap.peek().getValue() < entry.getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        // helper function to get words(String) from minHeap
        return getWords(minHeap);
    }
    private Map<String, Integer> getFreqMap (String[] combo) {
        Map<String, Integer> freqMap = new HashMap<>();
        // iterate over composition
        for (String s : combo) {
            Integer freq = freqMap.get(s);
            // not yet in, put it in and freq = 1
            if (freq == null) {
                freqMap.put(s, 1);
            } else { // if already in, update the freq by +1
                freqMap.put(s, freq + 1);
            }
        }
        return freqMap;
    }
    private String[] getWords (PriorityQueue<Map.Entry<String, Integer>>
                                       minHeap) {
        String[] result = new String[minHeap.size()];
        // freq in descending order, top elem from minHeap is smallest
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        String[] s = {"d","a","c","b","d","a","b","b","a","d","d","a","d"};
        TopKFrequent test = new TopKFrequent();
        String[] result = test.topKFrequent(s, 4);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
