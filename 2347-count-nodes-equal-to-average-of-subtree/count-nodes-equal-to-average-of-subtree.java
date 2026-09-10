/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        find(root);
        return ans;
    }
    public int[] find(TreeNode root){
        if(root==null) return new int[]{0,0};
        int[] arr1=find(root.left);
        int[] arr2=find(root.right);
        int tot=root.val+arr1[0]+arr2[0];
        int n=arr1[1]+arr2[1]+1;
        if(root.val==tot/n) ans++;
        // System.out.println(root.val+" "+Arrays.toString(arr1)+" "+Arrays.toString(arr2)+" "+ans);
        return new int[]{tot,n};
    }
}