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
        double slope = slope();
        double yIntercept = yIntercept();
        String equation = "y = ";

        // Handle horizontal line
        if (slope == 0) {
            if (yIntercept == 0) {
                return "y = 0";
            } else {
                return "y = " + roundedToHundredth(yIntercept);
            }
        }

        int rise = y2 - y1;
        int run = x2 - x1;

        if (rise % run == 0) {
            int numberSlope = rise / run;

            if (numberSlope == 1) {
                equation += "x";
            } else if (numberSlope == -1) {
                equation += "-x";
            } else {
                equation += numberSlope + "x";
            }
        } else {
            if (rise < 0 && run < 0) {
                // handle negative
                rise = Math.abs(rise);
                run = Math.abs(run);
            } else if (run < 0) {
                rise = -rise;
                run = Math.abs(run);
            }
            equation += rise + "/" + run + "x";
        }
        if (yIntercept != 0) {
            if (yIntercept > 0) {
                equation += " + " + roundedToHundredth(yIntercept);
            } else {
                equation += " - " + Math.abs(roundedToHundredth(yIntercept));
            }
        }
        return equation;
    }


    public String coordinateForX(double x) {
        double newX = x * slope() + yIntercept();
        return "(" + x + ", " + newX + ")";


    }


    public String lineInfo() {

        return "\nThe two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ") \n" +
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