class Solution {
    public boolean validMountainArray(int[] arr) {
        int count =0;
        Boolean flag=false;
        int len=0;
        if(arr.length<3){
return false;
        }
        
        for(int i=1;i<arr.length-1;i++){
            if(arr[i-1]<arr[i] && arr[i]>arr[i+1]){
                count++;
              
                
                
            }
            
        }
        if(count==1){
            return true;
        }
        return false;
        
    }
}