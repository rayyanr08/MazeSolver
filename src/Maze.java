import java.util.ArrayList;

public class Maze {
    private static int xCoord;
    private static int yCoord;
    private String[][] inputMaze;
    ArrayList<Integer[]> ifFork = new ArrayList<Integer[]>();

    public Maze(String[][] inputMaze){
        this.inputMaze = inputMaze;
        xCoord = 0;
        yCoord = 0;
    }


    public boolean ifLeft(){
        if (yCoord -1 < inputMaze[0].length && yCoord-1 >= 0){
            if (inputMaze[xCoord][yCoord-1].equals(".")) {
                yCoord--;
                inputMaze[xCoord][yCoord + 1] = "+";
                return true;
            }
        }
        return false;
    }

    public boolean ifDown() {
        if (xCoord + 1 >= 0) {
            if (inputMaze[xCoord + 1][yCoord].equals(".")) {
                xCoord++;
                inputMaze[xCoord-1][yCoord] = "+";
                return true;
            }
        }
        return false;
    }

    public boolean ifUp(){
        if (xCoord - 1 >= 0){
            if (inputMaze[xCoord-1][yCoord].equals(".")){
                xCoord--;
                inputMaze[xCoord+1][yCoord] = "+";
                return true;
            }
        }
        return false;
    }

    public boolean ifRight(){
            if (yCoord + 1 >0 && yCoord + 1 <=inputMaze[0].length -1) {
                if (inputMaze[xCoord][yCoord+1].equals(".")) {
                    yCoord++;
                    inputMaze[xCoord][yCoord - 1] = "+";
                    return true;
                }
            }
    return false;
    }

    public boolean ifMultipleDirections(){
        int count = 0;
        if (ifDown()) count++;
        if (ifUp()) count++;
        if (ifLeft()) count++;
        if (ifRight()) count++;
        if (count > 1){
            return true;
        }
        return false;
    }
    public void addFork(){
        Integer[] n = new Integer[]{xCoord,yCoord};
        ifFork.add(n);
    }

    public boolean canMove(){
        int count = 0;
        if (ifDown()) count++;
        if (ifUp()) count++;
        if (ifLeft()) count++;
        if (ifRight()) count++;
        if (count == 0) {
            return false;
        }
        return true;
    }


    public void part1(){
        ArrayList<String> solutions = new ArrayList<String>();
        solutions.add("(" + 0 + "," + 0 + ")");
        while (xCoord != inputMaze.length-1 && yCoord != inputMaze[0].length-1) {
            if (ifLeft()) {
                solutions.add("(" + xCoord + "," + yCoord + ")");
            }
            if (ifRight()) {
                System.out.println("right");
                solutions.add("(" + xCoord + "," + yCoord + ")");
            }
            if (ifUp()) {
                solutions.add("(" + xCoord + "," + yCoord + ")");
            }
            if (ifDown()) {
                solutions.add("(" + xCoord + "," + yCoord + ")");
            }
        }
        for (int i = 0; i<solutions.size();i++){
            System.out.print(solutions.get(i) + "--->");
        }
    }

    public void part2(){

        ArrayList<String> solutions = new ArrayList<String>();
        solutions.add("(" + 0 + "," + 0 + ")");
        int length = ifFork.size()-1;
        while (xCoord != inputMaze.length-1 && yCoord != inputMaze[0].length-1) {
            if (ifMultipleDirections()){
                System.out.println("run");
                addFork();
            }
            while (!canMove()){
                xCoord = ifFork.get(length)[0];
                yCoord = ifFork.get(length)[1];
                ifFork.remove(ifFork.get(length));
            }
                if (ifLeft()) {

                    solutions.add("(" + xCoord + "," + yCoord + ")");
                }
            if (ifRight()) {
                System.out.println("right");
                solutions.add("(" + xCoord + "," + yCoord + ")");
            }
            if (ifUp()) {
                solutions.add("(" + xCoord + "," + yCoord + ")");
            }
            if (ifDown()) {
                solutions.add("(" + xCoord + "," + yCoord + ")");
            }
        }
        for (int i = 0; i<solutions.size();i++){
            System.out.print(solutions.get(i) + "--->");
        }
    }
}
