public class Solution {
    public void solveSudoku(char[][] board) {
        tryFill(board, 0, 0);
    }

    private boolean tryFill(char[][] board, int row, int column) {
        int m = board.length;
        int n = board[0].length;

        int selectedRow = 0;
        int selectedColumn = 0;
        int columnStart = column;
        boolean existMissing = false;
        for (int i = row; i < m; i ++) {
            for (int j = columnStart; j < n; j ++) {
                if (board[i][j] == '.') {
                    selectedRow = i;
                    selectedColumn = j;
                    existMissing = true;
                    break;
                }
            }
            columnStart = 0;
            if (existMissing)
                break;
        }

        if (!existMissing)
            return true;

        boolean hasSolution = false;
        for (int i = 1; i < 10; i ++) {
            board[selectedRow][selectedColumn] = (char)(i + '0');
            if (isGood(board, selectedRow, selectedColumn)) {
                hasSolution = tryFill(board, row, column + 1);
                // print(board);
                if (hasSolution)
                    break;
            }
            board[selectedRow][selectedColumn] = '.';
        }

        return hasSolution;
    }

    private boolean isGood(char[][] board, int row, int column) {
        int n = board[0].length;
        int m = board.length;
        boolean[] mark = new boolean[10];
        for (int i = 0; i < n; i ++) {
            if (board[row][i] == '.')
                continue;
            int index = board[row][i] - '0';
            if (mark[index])
                return false;
            mark[index] = true;
        }

        mark = new boolean[10];
        for (int i = 0; i < m; i ++) {
            if (board[i][column] == '.')
                continue;
            int index = board[i][column] - '0';
            if (mark[index])
                return false;
            mark[index] = true;
        }

        mark = new boolean[10];
        int boxRow = (row / 3) * 3;
        int boxColumn = (column / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i ++)
            for (int j = boxColumn; j < boxColumn + 3; j ++) {
                if (board[i][j] == '.')
                    continue;
                int index = board[i][j] - '0';
                if (mark[index])
                    return false;
                mark[index] = true;
            }
        return true;
    }

}