import java.util.Scanner;


public class LinearEquationLogic {
    //instance variables
    private Scanner scan;
    private String coordinate;
    private String coordinate2;
    private LinearEquation line;
    private int x1Int;
    private int x2Int;

    //constructor
    public LinearEquationLogic() {
        coordinate = null;
        coordinate2 = null;
        line = null;
        scan = new Scanner(System.in);
        x1Int = 0;
        x2Int = 0;
    }


    //start method
    public void start() {
        gameLoop();
    }


    private void getCoordinateInfo() {
        System.out.print("Welcome to the linear equation program.");
        System.out.print("Please enter a coordinate point in the form (x, y): ");
        coordinate = scan.nextLine();
        System.out.print("Please enter a coordinate point in the form (x, y): ");
        coordinate2 = scan.nextLine();
    }

    private void parseCoordinate() {
        int comma1 = coordinate.indexOf(",");
        String x1Value = coordinate.substring(1,comma1);
        String y1Value = coordinate.substring(comma1 + 1, coordinate.length()-1);
        x1Int = Integer.parseInt(x1Value);
        int y1Int = Integer.parseInt(y1Value);


        int comma2 = coordinate2.indexOf(",");
        String x2Value = coordinate2.substring(1,comma2);
        String y2Value = coordinate2.substring(comma2 + 1,coordinate2.length()-1);
        x2Int = Integer.parseInt(x2Value);
        int y2Int = Integer.parseInt(y2Value);


        //create object
        line = new LinearEquation(x1Int, y1Int, x2Int, y2Int);
    }


    private void printLineInfo () {
        System.out.println(line.lineInfo());
    }


    private void coordinateWithX () {
        System.out.print("Enter an x coordinate: ");
        double xCoordinate = scan.nextInt();
        scan.nextLine();
        String s = line.coordinateForX(xCoordinate);
        System.out.println(s);
    }


    private void gameLoop () {
        getCoordinateInfo();
        parseCoordinate();
        if (x1Int != x2Int) {
            printLineInfo();
            coordinateWithX();
            System.out.print("Do you want to continue doing this process (yes/no): ");
            String condition = scan.nextLine();
            while (condition.equals("yes") && x1Int != x2Int) {
                getCoordinateInfo();
                parseCoordinate();
                printLineInfo();
                coordinateWithX();
                System.out.println("Do you want to continue doing this process (yes/no): ");
                condition = scan.nextLine();
            }
        } else {
            checkVertical();
        }
    }

    private void checkVertical() {
        if (x1Int == x2Int) {
            System.out.println("Your line is vertical.");
            System.out.println("Its equation is x = " + x1Int);
        }

    }
}
