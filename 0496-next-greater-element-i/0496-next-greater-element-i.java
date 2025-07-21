class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int arr[];
        arr=new int[nums1.length];
        int index=0;
        

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int max=nums2[j];
                if(nums1[i]==nums2[j]){
                    for(int k=j;k<nums2.length;k++){
                        max=Math.max(max,nums2[k]);
                        if(max!=nums2[j]){
                            break;
                        }


                    }
                    if(max==nums2[j]){
                        arr[index]=-1;
                        index++;

                    }
                    else{
                        arr[index]=max;
                        index++;
                    }
                }
            }
        }
        return arr;
        
    }
}