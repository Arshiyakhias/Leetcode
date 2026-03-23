class Solution {
    public List<List<Integer>> combine(int n, int k) {
    
        int val = 1 << n;  // 2^n
        List<List<Integer>> ans = new ArrayList<>();

        for (int mask = 0; mask < val; mask++) {

            // pick only subsets of size k
            if (Integer.bitCount(mask) == k) {

                List<Integer> temp = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    // check if ith bit is set
                    if ((mask & (1 << i)) != 0) {
                        temp.add(i + 1); // numbers are 1-based
                    }
                }

                ans.add(temp);
            }
        }

        return ans;

    }
}