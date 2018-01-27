public class MontoneIncreasingDigits {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(332));
    }

    private static int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        } else {
            char[] number = String.valueOf(N).toCharArray();
            int pointer = number.length;
            for (int i = number.length - 1; i > 0; i--) {
                if (number[i - 1] > number[i]) {
                    number[i - 1]--;
                    pointer = i - 1;
                }
            }

            for (int i = pointer + 1; i < number.length; i++) {
                number[i] = '9';
            }
            return Integer.valueOf(new String(number));
        }
    }
}
