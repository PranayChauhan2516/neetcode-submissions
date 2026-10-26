class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowT = 0, rowB = matrix.length - 1;
        while (rowT <= rowB) {
            int midRow = (rowT + rowB) >> 1;
            if (matrix[midRow][0] <= target) {
                if (midRow + 1 == matrix.length || matrix[midRow + 1][0] > target) {
                    int l = 0, r = matrix[0].length - 1;
                    while (l <= r) {
                        int mid = (l + r) >> 1;
                        if (matrix[midRow][mid] == target) {
                            return true;
                        } else if (matrix[midRow][mid] < target) {
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }
                    return false;
                } else {
                    rowT = midRow + 1;
                }
            } else {
                rowB = midRow - 1;
            }
        }
        return false;
    }
}