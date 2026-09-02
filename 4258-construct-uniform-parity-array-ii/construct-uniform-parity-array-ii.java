class Solution {
    public boolean uniformArray(int[] nums1) {
        int cnt=0;
        int[] arr=new int[nums1.length];
        int min=nums1[0];
        for(int i=0;i<nums1.length;i++) min=Math.min(nums1[i],min);
        int par=min%2;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2==0) cnt++;
        }
        return par==0?cnt==nums1.length:true;
    }
}