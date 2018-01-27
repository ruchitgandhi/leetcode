import java.util.TreeMap;

public class MyCalendarThree {
    public static void main(String[] args) {
        MyCalendarThree obj = new MyCalendarThree();
        System.out.println(obj.book(10, 20));
        System.out.println(obj.book(50, 60));
        System.out.println(obj.book(10, 40));
        System.out.println(obj.book(5, 15));
        System.out.println(obj.book(5, 10));
        System.out.println(obj.book(25, 55));
    }

    private TreeMap<Integer, Integer> bookingRecord;

    private MyCalendarThree() {
        bookingRecord = new TreeMap<>();
    }

    private int book(int start, int end) {
        bookingRecord.put(start, bookingRecord.getOrDefault(start, 0) + 1);
        bookingRecord.put(end, bookingRecord.getOrDefault(end, 0) - 1);
        int overlap = 0, maxOverlap = Integer.MIN_VALUE;
        for (int value : bookingRecord.values()) {
            overlap += value;
            if (overlap > maxOverlap) {
                maxOverlap = overlap;
            }
        }
        return maxOverlap;
    }
}
