import java.util.ArrayList;

public class Maze {
    private static int xCoord;
    private static int yCoord;
    private String[][] inputMaze;

    public Maze(String[][] inputMaze){
        this.inputMaze = inputMaze;
        xCoord = 0;
        yCoord = 0;
    }

    public void addX(){
        xCoord++;
    }
    public void addY(){
        yCoord++;
    }

    public void ifLeft(){
            if (yCoord != 0 && inputMaze[xCoord][yCoord - 1].equals(".")) {
                yCoord--;
            }
    }

    public void ifDown(){
            if (inputMaze[xCoord + 1][yCoord].equals(".")) {
                xCoord++;
            }

    }

    public void ifUp(){
            if (xCoord != 0 && inputMaze[xCoord - 1][yCoord].equals(".")) {
                xCoord++;
            }
    }

    public void ifRight(){
            if (inputMaze[xCoord][yCoord+1].equals(".")) {
                xCoord++;
            }
    }


    public void part1(){
        ArrayList<String> solutions = new ArrayList<String>();
        solutions.add("(" + 0 + "," + 0 + ")");
        while (!solutions.contains("(" + (inputMaze.length -1) + "," + (inputMaze[0].length-1) + ")")) {
            ifDown();
            if (!solutions.contains("(" + xCoord + "," + yCoord + ")"))
                solutions.add("(" + xCoord + "," + yCoord + ")");
            ifUp();
            if (!solutions.contains("(" + xCoord + "," + yCoord + ")"))
                solutions.add("(" + xCoord + "," + yCoord + ")");
            ifLeft();
            if (!solutions.contains("(" + xCoord + "," + yCoord + ")"))
                solutions.add("(" + xCoord + "," + yCoord + ")");
            ifRight();
            if (!solutions.contains("(" + xCoord + "," + yCoord + ")"))
                solutions.add("(" + xCoord + "," + yCoord + ")");
        }
        for (int i = 0; i<solutions.size();i++){
            System.out.print(solutions.get(i) + "--->");
        }
    }
}
