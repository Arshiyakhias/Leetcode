class Solution {
    public int totalFruit(int[] fruits) {
        int max=Integer.MIN_VALUE;
        int left=0;
        int right=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        while(right<fruits.length){
            if(map.containsKey(fruits[right])){
                int vals=map.get(fruits[right]);
                vals++;
                map.put(fruits[right],vals);
            }
            else{
                map.put(fruits[right],1);
            }
            while(map.size()>2){
                if(map.containsKey(fruits[left])){
                    int values=map.get(fruits[left]);
                    values--;
                    if(values==0){
                        map.remove(fruits[left]);
                    }
                    else{
                        map.put(fruits[left],values);
                    }
                    left++;
                }
            }
            max=Math.max(max,(right-left+1));
            right++;


        }
        return max;
    }
}