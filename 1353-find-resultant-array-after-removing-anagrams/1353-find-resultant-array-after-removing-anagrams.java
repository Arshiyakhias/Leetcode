class Solution {
    public List<String> removeAnagrams(String[] words) {
        String[]word;
        word=new String[words.length];
        for(int i=0;i<word.length;i++){
            word[i]=words[i];
        }
        ArrayList<String>lis=new ArrayList<String>();
        String sorted=new String();
        for(int j=0;j<words.length;j++){
            String[]arr=words[j].split("");
            Arrays.sort(arr);
             String check=new String();
            for(int i=0;i<arr.length;i++){
                check=check+arr[i];

            }if(check.equals(sorted)){
                continue;
            }
            else{
                lis.add(word[j]);
                sorted=check;
            }

        }
        return lis;
    }
}