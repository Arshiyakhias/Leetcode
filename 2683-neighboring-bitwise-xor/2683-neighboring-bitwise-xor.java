class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int val=derived[0];
        for(int i=1;i<derived.length;i++){
            val=val^derived[i];
        }
        if(val==0){
            return true;
        }
        return false;
    }
}