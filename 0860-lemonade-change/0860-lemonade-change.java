class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;
        int c1=0;
        int c2=0;
        int c3=0;

        for(int i=0;i<n;i++){
            
            if(bills[i]==5){
                c1++;
            }
            else if(bills[i]==10){
                if(c1==0) return false;
                c2++;
                c1--;
               
            }
            else if(bills[i]==20){
                if(c2>=1 && c1>=1){
                    c2--;
                    c1--;
                   
                }
                else if(c1>=3){
                    c1-=3;
                }
                else{
                    return false;
                }
               
            }
        }

        return true;
    }
}