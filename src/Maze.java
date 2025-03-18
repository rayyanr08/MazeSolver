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
        if (xCoord + 1 >= 0 && xCoord + 1 <inputMaze.length) {
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


    public void part1(){
        ArrayList<String> solutions = new ArrayList<String>();
        solutions.add("(" + 0 + "," + 0 + ")");
        while (xCoord != inputMaze.length-1 || yCoord != inputMaze[0].length-1) {
            if (ifLeft()) {
                solutions.add("(" + xCoord + "," + yCoord + ")");
            }
            if (ifRight()) {
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
            if (i == solutions.size()-1){
                System.out.print(solutions.get(i));
            } else {
                System.out.print(solutions.get(i) + "--->");
            }
        }
    }

        public void part2() {
        String[][] visited = new String[inputMaze.length][inputMaze[0].length];
        
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = ".";
            }
        }

        ArrayList<String> solutions = new ArrayList<>();
        solutions.add("(" + 0 + "," + 0 + ")");
        visited[xCoord][yCoord] = "+";

        while (xCoord != inputMaze.length - 1 || yCoord != inputMaze[0].length - 1) {
            boolean ifOpenSpace = false;

            if (ifLeft() && visited[xCoord][yCoord].equals(".")) {
                solutions.add("(" + xCoord + "," + yCoord + ")");
                visited[xCoord][yCoord] = "+";
                ifOpenSpace = true;
            } else if (ifRight() && visited[xCoord][yCoord].equals(".")) {
                solutions.add("(" + xCoord + "," + yCoord + ")");
                visited[xCoord][yCoord] = "+";
                ifOpenSpace = true;
            } else if (ifUp() && visited[xCoord][yCoord].equals(".")) {
                solutions.add("(" + xCoord + "," + yCoord + ")");
                visited[xCoord][yCoord] = "+";
                ifOpenSpace = true;
            } else if (ifDown() && visited[xCoord][yCoord].equals(".")) {
                solutions.add("(" + xCoord + "," + yCoord + ")");
                visited[xCoord][yCoord] = "+";
                ifOpenSpace = true;
            }

            if (!ifOpenSpace) {
                inputMaze[xCoord][yCoord] = "#";
                visited[xCoord][yCoord] = "#";

                if (!solutions.isEmpty()) {
                    solutions.remove(solutions.size() - 1);
                }
                xCoord = Integer.parseInt(solutions.get(solutions.size()-1).substring(1,2));
                yCoord = Integer.parseInt(solutions.get(solutions.size()-1).substring(3,4));
            }
        }

        for (int i = 0; i < solutions.size(); i++) {
           if (i == solutions.size()-1){
                System.out.print(solutions.get(i));
            } else {
                System.out.print(solutions.get(i) + "--->");
            }
        }
    }
}
