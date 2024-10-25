import java.util.Scanner;


public class LinearEquationLogic {
    //instance variables
    private Scanner scan;
    private String coordinate;
    private String coordinate2;
    private LinearEquation line;


    //constructor
    public LinearEquationLogic() {
        coordinate = null;
        coordinate2 = null;
        line = null;
        scan = new Scanner(System.in);
    }


    //start method
    public void start() {
        gameLoop();
    }


    private void getCoordinateInfo() {
        System.out.println("Welcome to the linear equation program.");
        System.out.println("Please enter a coordinate point in the form (x, y): ");
        coordinate = scan.nextLine();
        System.out.println("Please enter a coordinate point in the form (x, y): ");
        coordinate2 = scan.nextLine();
    }
    private void parseCoordinate() {
        int comma1 = coordinate.indexOf(",");


        String x1Value = coordinate.substring(1,comma1);
        String y1Value = coordinate.substring(comma1 + 1, coordinate.length()-1);
        int x1Int = Integer.parseInt(x1Value);
        int y1Int = Integer.parseInt(y1Value);


        int comma2 = coordinate.indexOf(",");
        String x2Value = coordinate2.substring(1,comma2);
        String y2Value = coordinate2.substring(comma2 + 1,coordinate2.length()-1);
        int x2Int = Integer.parseInt(x2Value);
        int y2Int = Integer.parseInt(y2Value);


        //create object
        line = new LinearEquation(x1Int, y1Int, x2Int, y2Int);
    }


    private void printLineInfo () {
        System.out.println(line.lineInfo());
    }


    private void coordinateWithX () {
        System.out.println("Enter an x coordinate: ");
        double xCoordinate = scan.nextInt();
        scan.nextLine();
        String s = line.coordinateForX(xCoordinate);
        System.out.println(s);
    }


    private void gameLoop () {
        getCoordinateInfo();
        parseCoordinate();
        checkVertical();
        printLineInfo();
        coordinateWithX();
        System.out.println("Do you want to continue doing this process (yes/no): ");
        String condition = scan.nextLine();
        while (condition.equals("yes")) {
            getCoordinateInfo();
            parseCoordinate();
            printLineInfo();
            coordinateWithX();
            System.out.println("Do you want to continue doing this process (yes/no): ");
            condition = scan.nextLine();
        }
    }

    private void checkVertical() {


    }
}
