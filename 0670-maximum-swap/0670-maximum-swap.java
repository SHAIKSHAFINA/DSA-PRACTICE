class Solution {
    public int maximumSwap(int num) {
        char arr[]=Integer.toString(num).toCharArray();
        int last[]=new int[10];

        for(int i=0;i<arr.length;i++){
            last[arr[i]- '0']=i;
        }

        for(int i=0;i<arr.length;i++){
            for(int d=9;d>arr[i]-'0';d--){
                if(last[d]> i){
                    swap(arr,last[d],i);
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }
    void swap(char arr[],int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}