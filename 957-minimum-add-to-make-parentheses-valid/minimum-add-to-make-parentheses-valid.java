class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Integer> stk=new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stk.push(i);
            else{
                if(!stk.isEmpty()) stk.pop();
                else ans++;
            }
        }
        return stk.size()+ans;
    }
}