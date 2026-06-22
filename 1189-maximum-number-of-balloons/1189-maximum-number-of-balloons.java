class Solution {
    public int maxNumberOfBalloons(String text) {
        int [] a=new int[26];

        for(char c:text.toCharArray()){
            a[c-'a']++;
        }

        int min=Integer.MAX_VALUE;

        min=Math.min(min,a['b'-'a']);
        min=Math.min(min,a['a'-'a']);
        min=Math.min(min,a['n'-'a']);
        min=Math.min(min,a['l'-'a']/2);
        min=Math.min(min,a['o'-'a']/2);

        return min;
    }
}