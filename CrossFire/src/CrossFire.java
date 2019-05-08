import java.util.Scanner;

public class CrossFire {

    public static void print(int [][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + "  ");
                if(matrix[i][j] >= 1 && matrix[i][j] <=9 ){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static int[][] nuke(int [][] matrix, int x, int y, int range){
        int iter = 1;

        while (iter != range + 1) { // up
            if(y - iter != -1) {
                matrix[y - iter] = destroy(matrix[y - iter], matrix[y - iter][x]);
                iter++;
            }else iter = range + 1;

        }
       // print(matrix);
        iter = 1;
        while (iter != range + 1) { // down
            if(y + iter != matrix[y].length) {
                matrix[y + iter] = destroy(matrix[y + iter], matrix[y + iter][x]);
                iter++;
            } else iter = range + 1;
        }
        //print(matrix);
        iter = 1;
        int leftDestruction = 0;
        while (iter != range + 1) { // left
            if(x - iter != -1) {
                matrix[y] = destroy(matrix[y], matrix[y][x - iter]);
                iter++;
                leftDestruction++;
            }else {
                iter = range + 1;
            }
        }
        //print(matrix);
        x -= leftDestruction;
        iter = 0;
        while (iter != range + 1) { //right
            //System.out.println(matrix[y].length);
            if(x + iter != matrix[y].length) {
                matrix[y] = destroy(matrix[y], matrix[y][x + iter]);
                iter++;
                x--;
            }else iter = range + 1;
        }
        return matrix;
    }

    public static int[] destroy(int [] matrixArr, int element) {
        int newArr[]= new int[matrixArr.length - 1];
        for (int i = 0, k = 0; i < matrixArr.length; i++) {
            if(element == matrixArr[i]) {
                continue;
            }else {
                newArr[k++] = matrixArr[i];
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[rows][cols];
        int iter = 1;
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                matrix[i][j] = iter;
                iter++;
            }
        }
        print(matrix);
        String[] command;
        String nextLine = sc.nextLine();
        while(!nextLine.equals("Nuke")){
            command = nextLine.split(" ");
            int x = Integer.parseInt(command[0]) - 1;
            int y = Integer.parseInt(command[1] ) - 1;
            int range = Integer.parseInt(command[2]);
            matrix = nuke(matrix, x, y, range);
            print(matrix);
            //System.out.println(x + y + range);
            nextLine = sc.nextLine();
        }
        print(matrix);
    }
}
