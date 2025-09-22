class Solution {
    public int hammingDistance(int x, int y) {
        int val=x^y;
        return Integer.bitCount(val);
    }
}