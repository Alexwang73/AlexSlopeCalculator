public class LinearEquation {
    //instance variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    //constructor
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }


    public double distance() {
        double base = Math.pow((x2-x1), 2);
        double height = Math.pow((y2 - y1), 2);
        double distance = Math.sqrt(base + height);
        return roundedToHundredth(distance);
    }


    public double slope() {
        double slope = (double) (y2 - y1) / (x2 - x1);
        return roundedToHundredth(slope);
    }


    public double yIntercept () {
        double slope = slope();
        double multiple = slope * x1;
        return roundedToHundredth(y1-multiple);
    }


    public String equation() {
        if (y1 == y2) {
            return "y = " + yIntercept();
        }
        if ((y2-y1) % (x2-x1) == 0) {
            if (yIntercept() < 0) {
                return "y = " + (y2 - y1) / (x2 - x1) + "x " + yIntercept();
            }
            return "y = " + (y2 - y1) / (x2 - x1) + "x + " + yIntercept();
        }
        if (yIntercept() < 0) {
            return "y = " + (y2 - y1) / (x2 - x1) + "x " + yIntercept();
        }
        return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x + " + yIntercept();
    }


    public String coordinateForX(double x) {
        double newX = x * slope() + yIntercept();
        return "(" + x + ", " + newX + ")";


    }


    public String lineInfo() {

        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ") \n" +
                "The equation of the line between these two points is: " + equation() + "\n" +
                "The y-intercept of this line is: " + yIntercept() +"\n" +
                "The slope of this line is: " + slope() +"\n" +
                "The distance between these points is: " + distance();
    }


    //helper method for rounding


    public double roundedToHundredth(double toRound) {
        double rounded = Math.round(toRound * 100) / 100.0;
        return rounded;
    }




}
