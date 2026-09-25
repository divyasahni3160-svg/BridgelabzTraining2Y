public static void selectionSortScores(int[] scores) {
    int totalScores = scores.length;
    
    for (int i = 0; i < totalScores - 1; i++) {
        int lowestScoreIndex = i;
        
        for (int j = i + 1; j < totalScores; j++) {
            if (scores[j] < scores[lowestScoreIndex]) {
                lowestScoreIndex = j; 
            }
        }
        
        int temp = scores[lowestScoreIndex];
        scores[lowestScoreIndex] = scores[i];
        scores[i] = temp;
    }
}
