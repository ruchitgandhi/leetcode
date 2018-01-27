import java.util.TreeMap;

public class MyCalendar_TreeMap {
    public static void main(String[] args) {
        MyCalendar_TreeMap obj = new MyCalendar_TreeMap();
        obj.book(10, 20);
        obj.book(15, 25);
        obj.book(20, 30);
    }

    private TreeMap<Integer, Integer> bookingRecord;

    private MyCalendar_TreeMap() {
        bookingRecord = new TreeMap<>();
    }

    private boolean book(int start, int end) {
        Integer key = bookingRecord.floorKey(start);
        if (key != null && bookingRecord.get(key) > start) {
            return false;
        }
        key = bookingRecord.ceilingKey(start);
        if (key != null && key < end) {
            return false;
        }
        bookingRecord.put(start, end);
        return true;
    }
}
