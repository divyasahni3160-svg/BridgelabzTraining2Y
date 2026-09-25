public static void bubbleSortMarks(int[] marks) {
    int totalStudents = marks.length;
    boolean swapped;
    
    for (int i = 0; i < totalStudents - 1; i++) {
        swapped = false;
        
        for (int j = 0; j < totalStudents - i - 1; j++) {
            if (marks[j] > marks[j + 1]) {
                int temp = marks[j];
                marks[j] = marks[j + 1];
                marks[j + 1] = temp;
                swapped = true;
            }
        }
        
        if (!swapped) {
            break;
        }
    }
}
