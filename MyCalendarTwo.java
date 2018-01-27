import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {

    public static void main(String[] args) {
        MyCalendarTwo obj = new MyCalendarTwo();
        System.out.println(obj.book(10, 20));
        System.out.println(obj.book(50, 60));
        System.out.println(obj.book(10, 40));
        System.out.println(obj.book(5, 15));
        System.out.println(obj.book(5, 10));
        System.out.println(obj.book(25, 55));
    }

    private TreeMap<Integer, Integer> booking;

    private MyCalendarTwo() {
        booking = new TreeMap<>();
    }

    private boolean book(int start, int end) {
        booking.put(start, booking.getOrDefault(start, 0) + 1);
        booking.put(end, booking.getOrDefault(end, 0) - 1);
        int overlap = 0;
        for (Map.Entry<Integer, Integer> entry : booking.entrySet()) {
            overlap += entry.getValue();
            if (overlap >= 3) {
                booking.put(start, booking.get(start) - 1);
                booking.put(end, booking.get(end) + 1);
                if (booking.get(start) == 0) {
                    booking.remove(start);
                }
                if (booking.get(end) == 0) {
                    booking.remove(end);
                }
                return false;
            }
        }
        return true;
    }
}
