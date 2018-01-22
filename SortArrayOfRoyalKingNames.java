import java.util.Arrays;

/*
    Sort array of names of Royal Kings

    Pocket Gems Hackerrank Test - Question 2

    The name consists of 2 strings : first is name like Louis and second is birth order like II or VIII (these are in Roman numerals)
    The task is to sort the given list of names of Kings in ascending order.
 */
public class SortArrayOfRoyalKingNames {
    public static void main(String[] args) {
        String names[] = {"Louis XI", "Luis VIII"};
        String[] result = getSortedList(names);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        return -1;
    }

    private static int romanToDecimal(String str) {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            int s1 = value(str.charAt(i));

            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));

                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
                i++;
            }
        }

        return res;
    }

    private static String[] getSortedList(String[] names) {
        Arrays.sort(names, (str1, str2) -> {
            String[] elements1 = str1.split(" ");
            String[] elements2 = str2.split(" ");
            if (!elements1[0].equals(elements2[0])) {
                return elements1[0].compareTo(elements2[0]);
            } else {
                int num1 = romanToDecimal(elements1[1]);
                int num2 = romanToDecimal(elements2[1]);
                return num1 - num2;
            }
        });
        return names;
    }
}
