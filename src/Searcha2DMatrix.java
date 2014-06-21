public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rowIndex = findRow(matrix, 0, matrix.length, target);
        int columnIndex = 0;
        if (rowIndex != -1) {
            columnIndex = findIndex(matrix[rowIndex], 0, matrix[0].length, target);
            if (columnIndex != -1)
                return true;
        }
        return false;
    }
    
    private int findIndex(int[] row, int start, int end, int target) {
        if (start == end - 1) {
            if (row[start] == target)
                return start;
            return -1;
        }
        
        int mid = (end - start) / 2 + start;
        if (row[mid] > target)
            return findIndex(row, start, mid, target);
        else if (row[mid] == target)
            return mid;
        else
            return findIndex(row, mid, end, target);
    }
    
    private int findRow(int[][] matrix, int start, int end, int target) {
        if (start == end - 1) {
            if (matrix[start][0] > target)
                return -1;
            return start;
        }

        int mid = (end - start) / 2 + start;
        if (matrix[mid][0] > target) 
            return findRow(matrix, start, mid, target);    
        else if (matrix[mid][0] == target)
            return mid;
        else    
            return findRow(matrix, mid, end, target);
    }
}