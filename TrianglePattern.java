import java.util.ArrayList;
import java.util.Arrays;

public class TrianglePattern {
    int n;
    int h;
    int[] initial;
    int[][] board;


    public TrianglePattern(int n, int h, int[] initial) {
        this.n = n;
        this.h = h;
        this.initial = initial;
        board = new int[h][n]; //Laver vores 2D-array med række og kollonne og som fyldes med 0'ere
        createBoard(); //kalder metoden som laver mønsteret
    }

    public void createBoard() {
        for(int k: this.initial) { //Indsætter værdien 1 for vores valgte søjle(r) i første række
            board[0][k] = 1;
        }
        for(int i = 1; i < h; i++) { //foor-loop for rækkerne (starter på 2 række da vi allerede udfyldt første række)
            for(int j = 1; j < n-1; j++) { //foor-loop for søjlerne (sørger for at ikke medtage første og sidste søjle)
                if(this.board[i-1][j-1] == 0) {
                    if(this.board[i-1][j] == 0) {
                        if(this.board[i-1][j+1] == 0) {
                            this.board[i][j] = 0;
                        } else {
                            this.board[i][j] = 1;
                        }
                    } else {
                        this.board[i][j] = 1;
                    }
                } else {
                    if(this.board[i-1][j] == 0 && this.board[i-1][j+1] == 0) {
                        this.board[i][j] = 1;
                    } else {
                        this.board[i][j] = 0;
                    }
                }
            }
        }
    }

    public int getValueAt(int r, int c) { //returnerer værdien i en bestemt række og søjle
        return board[r][c];
    }
    public int getN() { //returnerer vores antal af søjler
        return this.n;
    }
    public int getH() { //returnerer vores antal af rækker
        return this.h;
    }
    public int[] getInitial() { //returnerer søjle(rne) for hvor mønsteret starter i første række
        return this.initial;
    }
}
