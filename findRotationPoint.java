public static int findRotationPoint(int[] rotatedArray) {
    int leftIndex = 0;
    int rightIndex = rotatedArray.length - 1;
    
    while (leftIndex < rightIndex) {
        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        
        if (rotatedArray[middleIndex] > rotatedArray[rightIndex]) {
            leftIndex = middleIndex + 1;
        } else {
            rightIndex = middleIndex;
        }
    }
    
    return rotatedArray[leftIndex];
}
