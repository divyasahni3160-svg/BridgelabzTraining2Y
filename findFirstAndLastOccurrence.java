public static int[] findFirstAndLastOccurrence(int[] sortedArray, int targetValue) {
    int[] resultPositions = new int[]{-1, -1};
    
    int leftIndex = 0;
    int rightIndex = sortedArray.length - 1;
    
    while (leftIndex <= rightIndex) {
        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        if (sortedArray[middleIndex] == targetValue) {
            resultPositions[0] = middleIndex;
            rightIndex = middleIndex - 1; 
        } else if (sortedArray[middleIndex] < targetValue) {
            leftIndex = middleIndex + 1;
        } else {
            rightIndex = middleIndex - 1;
        }
    }
    
    leftIndex = 0;
    rightIndex = sortedArray.length - 1;
    
    while (leftIndex <= rightIndex) {
        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        if (sortedArray[middleIndex] == targetValue) {
            resultPositions[1] = middleIndex;
            leftIndex = middleIndex + 1; 
        } else if (sortedArray[middleIndex] < targetValue) {
            leftIndex = middleIndex + 1;
        } else {
            rightIndex = middleIndex - 1;
        }
    }
    
    return resultPositions;
}
