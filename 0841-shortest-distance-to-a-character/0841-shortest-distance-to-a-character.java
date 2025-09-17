class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer>lis=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                lis.add(i);
            }
        }
        int[]arr;
        arr=new int[s.length()];
        for(int i=0;i<s.length();i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<lis.size();j++){
                int subs=Math.abs(lis.get(j)-i);
                min=Math.min(min,subs);

            }
            arr[i]=min;

        }
        return arr;
    }
}