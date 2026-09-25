public static boolean searchMatrix(int[][] matrix, int targetValue) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return false;
    }
    
    int totalRows = matrix.length;
    int totalColumns = matrix[0].length;
    int leftBoundary = 0;
    int rightBoundary = (totalRows * totalColumns) - 1;
    
    while (leftBoundary <= rightBoundary) {
        int middleIndex = leftBoundary + (rightBoundary - leftBoundary) / 2;
        int row = middleIndex / totalColumns;
        int column = middleIndex % totalColumns;
        int middleValue = matrix[row][column];
        
        if (middleValue == targetValue) {
            return true;
        } else if (middleValue < targetValue) {
            leftBoundary = middleIndex + 1;
        } else {
            rightBoundary = middleIndex - 1;
        }
    }
    
    return false;
}
