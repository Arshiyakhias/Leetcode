class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        HashMap<Integer,Character>fin=new HashMap<>();
        int count=25;
        for(char i='a';i<='z';i++){
            fin.put(count,i);
            count--;
        }

        HashMap<Character,Integer>wts=new HashMap<>();
        int ind=0;

        for(char i='a';i<='z';i++){
            wts.put(i,weights[ind]);
            ind++;

        }
        String ans=new String();
        for(String sing:words){
            int sum=0;
            for(int i=0;i<sing.length();i++){
                int val=wts.get(sing.charAt(i));
                sum=sum+val;
            }
            sum=sum%26;
            char find=fin.get(sum);
            ans=ans+find;
        }
        return ans;
    }
}