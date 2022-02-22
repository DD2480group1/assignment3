package com.thealgorithms.dynamicprogramming;

class LongestCommonSubsequence {

    public static String getLCS(String str1, String str2, boolean[] checks) {

        // At least one string is null
        if (str1 == null || str2 == null) {
            checks[0] = true;
            return null;
        }

        // At least one string is empty
        if (str1.length() == 0 || str2.length() == 0) {
            checks[1] = true;
            return "";
        }

        String[] arr1 = str1.split("");
        String[] arr2 = str2.split("");

        // lcsMatrix[i][j]  = LCS of first i elements of arr1 and first j characters of arr2
        int[][] lcsMatrix = new int[arr1.length + 1][arr2.length + 1];

        for (int i = 0; i < arr1.length + 1; i++) {
            checks[2] = true;
            lcsMatrix[i][0] = 0;
        }

        lcsMatrix = handleMatrix(lcsMatrix, arr1, arr2, checks);
        return lcsString(str1, str2, lcsMatrix);
    }

    public static int[][] handleMatrix(int[][] lcsMatrix, String[] arr1, String[] arr2, boolean[] checks){
        for (int j = 1; j < arr2.length + 1; j++) {
            checks[3] = true;
            lcsMatrix[0][j] = 0;
        }
        for (int i = 1; i < arr1.length + 1; i++) {
            checks[4] = true;
            for (int j = 1; j < arr2.length + 1; j++) {
                checks[5] = true;
                if (arr1[i - 1].equals(arr2[j - 1])) {
                    checks[6] = true;
                    lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
                } else {
                    checks[7] = true;
                    lcsMatrix[i][j]
                            = lcsMatrix[i - 1][j] > lcsMatrix[i][j - 1] ? lcsMatrix[i - 1][j] : lcsMatrix[i][j - 1];
                }
            }
        }
        return lcsMatrix;
    }

    public static String lcsString(String str1, String str2, int[][] lcsMatrix) {
        StringBuilder lcs = new StringBuilder();
        int i = str1.length(), j = str2.length();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (lcsMatrix[i - 1][j] > lcsMatrix[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return lcs.reverse().toString();
    }

    public static void coverage(boolean[] checking){
        double coverage = 0;
        for(int i = 0; i < 8; i ++) {
            if (checking[i]) coverage ++;
        }
        double percentage = coverage/8.0 * 100.0;
        System.out.println("Coverage is: "+ percentage);
    }
    // Tests that getLCS returns null if input is null
    public static void testNull(boolean[] checking){
        String str1 = null;
        String str2 = null;

        String lcs = getLCS(str1, str2, checking);
        System.out.println("LCS input is null and getLCS returns: " + lcs);
    }

    // Tests that getLCS() returns an empty String if input is an Empty String
    public static void testEmptyString(boolean[] checking){
        String str1 = "";
        String str2 = "AAA";

        String lcs = getLCS(str1, str2, checking);
        System.out.println("One input String is empty and getLCS returns: \"" + lcs + "\"");
    }

    public static void main(String[] args) {
        boolean[] checking = new boolean[8];
        for(int i = 0; i < 8; i ++){
            checking[i] = (false);
        }

        String str1 = "DSGSHSRGSRHTRD";
        String str2 = "DATRGAGTSHS";
        String lcs = getLCS(str1, str2, checking);

        testNull(checking);
        testEmptyString(checking);

        // Print LCS
        if (lcs != null) {
            System.out.println("String 1: " + str1);
            System.out.println("String 2: " + str2);
            System.out.println("LCS: " + lcs);
            System.out.println("LCS length: " + lcs.length());
        }
        coverage(checking);
    }
}
