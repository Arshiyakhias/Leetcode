class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long x = nums[i];

            // Find smallest number >= (x - valueDiff)
            Long candidate = set.ceiling(x - valueDiff);

            // Check if it's within (x + valueDiff)
            if (candidate != null && candidate <= x + valueDiff) {
                return true;
            }

            set.add(x);

            // Maintain window of size indexDiff
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}