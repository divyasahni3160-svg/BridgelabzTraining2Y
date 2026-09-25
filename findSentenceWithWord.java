public static String findSentenceWithWord(String[] sentences, String targetWord) {
    for (String currentSentence : sentences) {
        if (currentSentence.contains(targetWord)) {
            return currentSentence;
        }
    }
    return "Not Found";
}
