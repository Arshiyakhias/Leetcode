class Solution {
    public String reverseByType(String s) {
        String[]arr=s.split("");
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            char leftie=arr[left].charAt(0);
            char rightie=arr[right].charAt(0);
            if(Character.isLetter(leftie) && Character.isLetter(rightie)){
                String lef=arr[left];
                String righ=arr[right];
                arr[left]=righ;
                arr[right]=lef;
                left++;
                right--;
            }
            else if(Character.isLetter(leftie) && !Character.isLetter(rightie)){
            
                right--;
            }
            else if(!Character.isLetter(leftie) && Character.isLetter(rightie)){
            
                left++;
            }
            else{
                left++;
                right--;
            }
        }
        int left1=0;
        int right1=arr.length-1;
        while(left1<=right1){
            char leftie1=arr[left1].charAt(0);
            char rightie1=arr[right1].charAt(0);
            if(!Character.isLetter(leftie1) && !Character.isLetter(rightie1)){
                String lef=arr[left1];
                String righ=arr[right1];
                arr[left1]=righ;
                arr[right1]=lef;
                left1++;
                right1--;
            }
            else if(Character.isLetter(leftie1) && !Character.isLetter(rightie1)){
            
                left1++;
            }
            else if(!Character.isLetter(leftie1) && Character.isLetter(rightie1)){
            
                right1--;
            }
            else{
                left1++;
                right1--;
            }
        }
        String ans=new String();
        for(int i=0;i<arr.length;i++){
            ans=ans+arr[i];
        }
        return ans;
    }
}