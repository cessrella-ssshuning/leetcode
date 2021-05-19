class Solution {
    public boolean checkValidString(String s) {
        //number of unmatched left parentheses
        int countMin = 0;//use * as ( as many as possible
        int countMax = 0;//use * as ) as many as possible
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                countMin++;
                countMax++;
            }else if(s.charAt(i)==')'){
                countMin--;
                countMax--;
            }else{
                countMin--;
                countMax++;
            }
            if(countMax<0) return false;
            if(countMin<0) countMin = 0;//means we can revert some * to ) to match
        }
        return countMin==0;//means there at least we have enough * to use as (
    }
}