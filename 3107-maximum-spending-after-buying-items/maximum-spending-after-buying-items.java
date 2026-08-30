class Solution {
    public long maxSpending(int[][] values) {
        long ans=0;
        int[] ptr=new int[values.length];
        Arrays.fill(ptr,values[0].length-1);
        for(long d=1;d<=values.length*values[0].length;d++){
            int max=0;
            for(int i=0;i<values.length;i++){
                if(ptr[i]!=-1){
                    max=i;
                    break;
                }
            }
            if(max==-1) return ans;
            for(int i=0;i<values.length;i++){
                if(ptr[i]<0) continue;
                if(values[i][ptr[i]]<values[max][ptr[max]]) max=i;
            }
            ans+=d*values[max][ptr[max]];
            ptr[max]--;
        }
        return ans;
    }
}