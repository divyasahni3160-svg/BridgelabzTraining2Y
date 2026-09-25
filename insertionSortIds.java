public static void insertionSortIds(int[] employeeIds) {
    int totalEmployees = employeeIds.length;
    
    for (int i = 1; i < totalEmployees; i++) {
        int currentId = employeeIds[i];
        int j = i - 1;
        
        while (j >= 0 && employeeIds[j] > currentId) {
            employeeIds[j + 1] = employeeIds[j];
            j = j - 1;
        }
        
        employeeIds[j + 1] = currentId;
    }
}
