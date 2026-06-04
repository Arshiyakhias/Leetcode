class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans=0;
        for(int i=num1;i<=num2;i++){
            String check=new String();
            check=check+i;
            if(check.length()<3){
                ans=ans+0;
            }
            else{
                
            int count=0;
            for(int j=1;j<check.length()-1;j++){
                System.out.println(Integer.valueOf(check.charAt(j-1)));
                if(Integer.valueOf(check.charAt(j-1))>Integer.valueOf(check.charAt(j)) && Integer.valueOf(check.charAt(j+1))>Integer.valueOf(check.charAt(j))){
                    count++;
                }
                else if(Integer.valueOf(check.charAt(j-1))<Integer.valueOf(check.charAt(j)) && Integer.valueOf(check.charAt(j+1))<Integer.valueOf(check.charAt(j))){
                    count++;
                }
            }
            ans=ans+count;
            }
        }
        return ans;
    }
}