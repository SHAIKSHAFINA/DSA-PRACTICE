class Solution {
    public int rotatedDigits(int n) {
        int c=0;
        
        for(int i=1;i<=n;i++){

            int temp=i;
            boolean isValid=true;
            boolean good=false;

            while(temp>0){
                int d=temp %10;

                if(d==4 || d==3 || d==7){
                    isValid=false;
                    break;
                }

                if(d==2 || d==5 || d==6 || d==9){
                    good=true;
                }

                temp/=10;
            }

            if(isValid && good){
                c++;
            }
        }

        return c;
    }
}