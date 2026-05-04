class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        String[]arr=answerKey.split("");
   
        //counting longest 't' subarray
        int count_f=0;
        int l=0;
        int r=0;
        int len_t=0;
        while(r<arr.length){
            if(arr[r].equals("F")){
                count_f++;
            }
            while(count_f>k){
                if(arr[l].equals("F")){
                    count_f--;
                }
                l++;
            }
            if(count_f<=k){
                len_t=Math.max(len_t,(r-l+1));

            }
            r++;
        }

        //counting longest 'f' subarray
        int count_t=0;
        int l1=0;
        int r1=0;
        int len_f=0;
        while(r1<arr.length){
            if(arr[r1].equals("T")){
                count_t++;
            }
            while(count_t>k){
                if(arr[l1].equals("T")){
                    count_t--;
                }
                l1++;
            }
            if(count_t<=k){
                len_f=Math.max(len_f,(r1-l1+1));

            }
            r1++;
        }
        return Math.max(len_t,len_f);
        
    }
}