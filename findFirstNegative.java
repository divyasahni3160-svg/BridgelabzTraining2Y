public static int findFirstNegative(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] < 0) {
            return i;
        }
    }
    return -1;
}
