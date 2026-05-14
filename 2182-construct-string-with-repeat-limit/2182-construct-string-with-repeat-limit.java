
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {

        HashMap<Character, Integer> map = new HashMap<>();

        // frequency count
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // max heap
        PriorityQueue<Character> pq =
                new PriorityQueue<>((a, b) -> b - a);

        for (char ch : map.keySet()) {
            pq.add(ch);
        }

        StringBuilder ans = new StringBuilder();

        int count = 0;

        while (!pq.isEmpty()) {

            char tops = pq.poll();

            // same character as previous
            if (ans.length() == 0 ||
                ans.charAt(ans.length() - 1) == tops) {

                count++;

                // exceeded repeat limit
                if (count > repeatLimit) {

                    if (pq.isEmpty()) {
                        return ans.toString();
                    }

                    char second = pq.poll();

                    ans.append(second);

                    int secondFreq = map.get(second) - 1;

                    if (secondFreq == 0) {
                        map.remove(second);
                    } else {
                        map.put(second, secondFreq);
                        pq.add(second);
                    }

                    // put top back
                    pq.add(tops);

                    // second appeared once consecutively
                    count = 1;
                }

                else {

                    ans.append(tops);

                    int topFreq = map.get(tops) - 1;

                    if (topFreq == 0) {
                        map.remove(tops);
                    } else {
                        map.put(tops, topFreq);
                        pq.add(tops);
                    }
                }
            }

            // different character
            else {

                count = 1;

                ans.append(tops);

                int topFreq = map.get(tops) - 1;

                if (topFreq == 0) {
                    map.remove(tops);
                } else {
                    map.put(tops, topFreq);
                    pq.add(tops);
                }
            }
        }

        return ans.toString();
    }
}
