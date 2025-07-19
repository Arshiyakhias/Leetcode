class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                // Jump left pointer only forward
                left = Math.max(map.get(ch) + 1, left);
            }
            map.put(ch, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
