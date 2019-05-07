
import java.util.Scanner;

public class CrossFire {

    public static int[][] destroy (int [][] matrix, int x, int y, int range) {
        matrix = ArrayUtils.removeElement(matrix, element)
        return matrix;
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

        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                System.out.print(matrix[i][j] + "  ");
                if(matrix[i][j] >= 1 && matrix[i][j] <=9 ){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        String nextLine = sc.nextLine();
        while(nextLine != "Nuke"){
            String[] nukibgPoint = nextLine.split(" ");
            int x = Integer.parseInt(nukibgPoint[0]);
            int y = Integer.parseInt(nukibgPoint[1]);
            int range = Integer.parseInt(nukibgPoint[2]);
            System.out.println(x + " " + y + " " + range);
            nextLine = sc.nextLine();
            destroy(matrix, x, y, range);
        }
    }
}
