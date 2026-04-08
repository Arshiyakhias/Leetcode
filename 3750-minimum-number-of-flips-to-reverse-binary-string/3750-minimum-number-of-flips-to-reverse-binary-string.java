class Solution {
    public int minimumFlips(int n) {
        String num=Integer.toBinaryString(n);
        StringBuilder str=new StringBuilder(num);
        str.reverse();
        String reverse=str.toString();
        int vals=Integer.parseInt(reverse,2);
     
        int fins=n^vals;
        

        return Integer.bitCount(fins);
    }
}