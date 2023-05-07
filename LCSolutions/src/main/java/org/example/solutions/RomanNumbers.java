package org.example.solutions;

public class RomanNumbers {
    public int romanToInt(String s) {
        String romanNumbers = "IVXLCDM";
        int[] arabicNumbers = new int[] {1, 5, 10, 50, 100, 500, 1000};
        String[] numbersList = s.split("");
        int result = romanNumbers.contains(numbersList[0]) ? arabicNumbers[romanNumbers.indexOf(numbersList[0])] : 0;
        for (int i = 1; i < numbersList.length; i++) {
            int num = romanNumbers.contains(numbersList[i]) ? arabicNumbers[romanNumbers.indexOf(numbersList[i])] : 0;
            int previousNum = romanNumbers.contains(numbersList[i-1]) ? arabicNumbers[romanNumbers.indexOf(numbersList[i-1])] : 0;
            result += (num <= previousNum) ? num : (num - (previousNum * 2));
        }
        return result;
    }
    public int romanToInt2(String s) {
        int ans = 0, num = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            switch(s.charAt(i)) {
                case 'M': num = 1000; break;
                case 'D': num = 500; break;
                case 'C': num = 100; break;
                case 'L': num = 50; break;
                case 'X': num = 10; break;
                case 'V': num = 5; break;
                case 'I': num = 1; break;
            }
            if (num < prev)
                ans -= num;
            else
                ans += num;
            prev = num;
        }
        return ans;
    }
    public int romanToInt3(String s) {
        int result = 0, previousNum = 0;
        String romanNumbers = "IVXLCDM";
        int[] arabicNumbers = new int[] {1, 5, 10, 50, 100, 500, 1000};
        for (int i = s.length() - 1; i >= 0; --i) {
            int num = arabicNumbers[romanNumbers.indexOf(s.charAt(i))];
            result += (num < previousNum) ? -num : num;
            previousNum = num;
        }
        return result;
    }
}
