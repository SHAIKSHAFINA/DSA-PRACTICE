class Solution {
    public int candy(int[] arr) {
        int n=arr.length;

        int sum=1,i=1;

        while(i<n){
            if(arr[i]==arr[i-1]){
                sum+=1;
                i++;
                continue;
            }
            int peak=1;
            while(i<n && arr[i] > arr[i-1]){
                peak+=1;
                sum+=peak;
                i++;
            }
            
            int down=1;
            while(i<n && arr[i] < arr[i-1]){
                sum+=down;
                down+=1;
                i++;
            }

            if(down>peak){
                sum+=(down-peak);
            }
        }

        return sum;

    }
}