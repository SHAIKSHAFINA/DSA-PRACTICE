class Solution {
    public double[] internalAngles(int[] sides) {
        int a=sides[0];
        int b=sides[1];
        int c=sides[2];
        double arr[]=new double[3];
        
        if(a+b <= c || a+c <= b || b+c <=a) return new double[]{};
        double cosa=((b*b +c*c - a*a)/(2.0* b * c));
        double cosb=((a*a +c*c - b*b)/(2.0* a * c));
        double cosc=((b*b +a*a - c*c)/(2.0*b * a));

        double A=Math.toDegrees(Math.acos(cosa));
        double B=Math.toDegrees(Math.acos(cosb));
        double C=Math.toDegrees(Math.acos(cosc));

        
        arr[0]=A;
        arr[1]=B;
        arr[2]=C;

        Arrays.sort(arr);
        return arr;
    }
}