class Solution {
    public int findClosest(int x, int y, int z) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int a=0;
        int b=0;
        a=Math.abs(x-z);
        b=Math.abs(y-z);
        if(a<b){
            return 1;
        }
        else if(b<a){
            return 2;
        }
        return 0;

    }
}