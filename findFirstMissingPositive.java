public static int findFirstMissingPositive(int[] numbers) {
    boolean[] isPresent = new boolean[numbers.length + 1];
    
    for (int number : numbers) {
        if (number > 0 && number <= numbers.length) {
            isPresent[number] = true;
        }
    }
    
    for (int i = 1; i <= numbers.length; i++) {
        if (!isPresent[i]) {
            return i;
        }
    }
    
    return numbers.length + 1;
}

public static int searchTargetIndex(int[] sortedNumbers, int targetNumber) {
    int leftBoundary = 0;
    int rightBoundary = sortedNumbers.length - 1;
    
    while (leftBoundary <= rightBoundary) {
        int middleIndex = leftBoundary + (rightBoundary - leftBoundary) / 2;
        
        if (sortedNumbers[middleIndex] == targetNumber) {
            return middleIndex;
        } else if (sortedNumbers[middleIndex] < targetNumber) {
            leftBoundary = middleIndex + 1;
        } else {
            rightBoundary = middleIndex - 1;
        }
    }
    
    return -1;
}
