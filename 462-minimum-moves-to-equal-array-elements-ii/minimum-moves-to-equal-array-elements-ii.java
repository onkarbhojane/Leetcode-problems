class Solution {
    public int minMoves2(int[] nums) {
        int move=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            move+=Math.abs(nums[i]-nums[nums.length/2]);
        }
        return move;
    }
}