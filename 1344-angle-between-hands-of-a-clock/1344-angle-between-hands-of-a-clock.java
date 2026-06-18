class Solution {
    public double angleClock(int hour, int minutes) {
        double x= Math.abs(30*hour -5.5*minutes);
        if(x>180) return 360-x;
        return x;
    }
}