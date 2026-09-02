class Solution {
    public boolean uniformArray(int[] nums1) {
        int cnt=0;
        int[] arr=new int[nums1.length];
        for(int i=0;i<nums1.length;i++) arr[i]=nums1[i];
        Arrays.sort(arr);
        int par=arr[0]%2;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2==0) cnt++;
        }
        return par==0?cnt==nums1.length:true;
    }
}