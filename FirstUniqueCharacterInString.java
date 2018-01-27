public class FirstUniqueCharacterInString {

    static class Count {
        int count;
        int lastPosition;

        Count(int count, int lastPosition) {
            this.count = count;
            this.lastPosition = lastPosition;
        }
    }

    public static void main(String[] args) {
        String s = "leetcodel";
        System.out.println(firstUniqChar(s));
    }

    private static int firstUniqChar(String s) {
        Count alphabets[] = new Count[26];
        int position;
        for (int i = 0; i < s.length(); i++) {
            position = s.charAt(i) - 'a';
            if (alphabets[position] == null) {
                alphabets[position] = new Count(1, i);
            } else {
                alphabets[position].count++;
                alphabets[position].lastPosition = i;
            }
        }

        int minPosition = Integer.MAX_VALUE;
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] != null && alphabets[i].count == 1 && alphabets[i].lastPosition < minPosition) {
                minPosition = alphabets[i].lastPosition;
            }
        }
        if (minPosition == Integer.MAX_VALUE) {
            return -1;
        }
        return minPosition;
    }
}
