import java.util.*;

class Solution {

    public String fractionAddition(String expression) {
        List<int[]> fractions = parseExpression(expression);
        int commonDenominator = 1;
        for (int[] fraction : fractions) {
            commonDenominator = lcm(commonDenominator, fraction[1]);
        }
        int numeratorSum = 0;
        for (int[] fraction : fractions) {
            numeratorSum += fraction[0] * (commonDenominator / fraction[1]);
        }
        int gcd = gcd(Math.abs(numeratorSum), commonDenominator);
        numeratorSum /= gcd;
        commonDenominator /= gcd;
        if (numeratorSum == 0) {
            return "0/1";
        }
        return numeratorSum + "/" + commonDenominator;
    }

    private List<int[]> parseExpression(String expression) {
        List<int[]> fractions = new ArrayList<>();
        int i = 0;
        while (i < expression.length()) {
            int start = i;
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                i++;
            }
            while (i < expression.length() && expression.charAt(i) != '+' && expression.charAt(i) != '-') {
                i++;
            }
            String fraction = expression.substring(start, i);
            String[] parts = fraction.split("/");
            int numerator = Integer.parseInt(parts[0]);
            int denominator = Integer.parseInt(parts[1]);
            fractions.add(new int[]{numerator, denominator});
        }
        return fractions;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
