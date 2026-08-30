class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int i=cardPoints.length-1;
        int ans=0;
        int sum=0;
        int p=k;
        while(k>0){
            ans+=cardPoints[i];
            i--;
            k--;
        }
        int j=0;
        i++;
        sum=ans;
        while(p>0){
            ans+=cardPoints[j];
            ans-=cardPoints[i];
            j++;
            i++;
            p--;
            sum=Math.max(sum,ans);
        }
        return sum;
    }
}