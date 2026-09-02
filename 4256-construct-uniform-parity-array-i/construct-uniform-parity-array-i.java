class Solution {
    public boolean uniformArray(int[] nums1) {
        int cnt=0;
        int cnt1=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2==0) cnt++;
            else cnt1++;
        }
        return cnt==nums1.length || cnt1>0;
    }
}