public static int findPeakElement(int[] numbers) {
    int leftIndex = 0;
    int rightIndex = numbers.length - 1;

    while (leftIndex <= rightIndex) {
        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

        boolean isGreaterThanLeft = (middleIndex == 0) || (numbers[middleIndex] > numbers[middleIndex - 1]);
        boolean isGreaterThanRight = (middleIndex == numbers.length - 1) || (numbers[middleIndex] > numbers[middleIndex + 1]);

        if (isGreaterThanLeft && isGreaterThanRight) {
            return numbers[middleIndex]; 
        }

        if (middleIndex > 0 && numbers[middleIndex - 1] > numbers[middleIndex]) {
            rightIndex = middleIndex - 1;
        } else {
            leftIndex = middleIndex + 1;
        }
    }
    return -1;
}
