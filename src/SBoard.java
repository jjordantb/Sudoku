/**
 * Created by Jordan on 3/14/2016.
 */
public class SBoard {

    private final int[][] board, initBoard;

    public SBoard() {
        this.board = new int[9][9];
        this.initBoard = new int[9][9];
    }

    public int[][] getInitBoard() {
        return initBoard;
    }

    public int[][] getBoard() {
        return board;
    }

    /* ITS GETTING RE INIT'D SOMEWHERE something with update view */

    public boolean solveBoard(final int row, final int col) {
        if (row > 8) {
            return true;
        }
        if (this.board[row][col] == 0) {
            for (int i = 1; i < 10; i++) {
                if (this.isRowGood(row, i) && this.isColumnGood(col, i) && this.isSquareGood(row, col, i)) {
                    this.board[row][col] = i;
                    if (this.solveNext(row, col)) {
                        return true;
                    } else {
                        this.board[row][col] = 0;
                    }
                }
            }
        } else {
            if (this.solveNext(row, col)) {
                return true;
            }
        }
        return false;
    }

    public boolean solveNext(final int row, final int col) {
        if(col < 8) {
            return this.solveBoard(row, col + 1);
        }
        return this.solveBoard(row + 1, 0);
    }

    /* BOARD CHECKS */

    public boolean isRowGood(final int row, final int n) {
        for (int col = 0; col < 9; col++) {
            if (this.board[row][col] == n) {
                return false;
            }
        }
        return true;
    }

    public boolean isColumnGood(final int col, final int n) {
        for (int row = 0; row < 9; row++) {
            if (this.board[row][col] == n) {
                return false;
            }
        }
        return true;
    }

    public boolean isSquareGood(int row, int col, final int n) {
        row = (int) Math.floor(row / 3) * 3;
        col = (int) Math.floor(col / 3) * 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (this.board[row + r][col + c] == n) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String str = "";
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                str += this.board[r][c];
            }
            str += '\n';
        }
        return str;
    }

}
