import java.util.ArrayList;
import java.util.List;

public class MyCalendar1 {

    class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    List<Interval> bookedIntervalList = new ArrayList<>();

    public MyCalendar1() {

    }

    public boolean book(int start, int end) {
        for (Interval i : bookedIntervalList) {
            if (start < i.end) {
                if (end <= i.start) {
                    addToList(new Interval(start, end));
                    return true;
                } else {
                    return false;
                }
            }
        }
        addToList(new Interval(start, end));
        return true;
    }

    private void addToList(Interval interval) {
        int insertIndex = bookedIntervalList.size();
        for (int i = 0; i < bookedIntervalList.size(); i++) {
            if (interval.start < bookedIntervalList.get(i).start) {
                insertIndex = i;
                break;
            }
        }

        Interval temp;
        for (int i = insertIndex; i < bookedIntervalList.size(); i++) {
            temp = bookedIntervalList.get(i);
            bookedIntervalList.set(i, interval);
            interval = temp;
        }
        bookedIntervalList.add(interval);
    }

    public static void main(String[] args) {
        MyCalendar1 obj = new MyCalendar1();
        obj.book(10, 20);
        obj.book(15, 25);
        obj.book(20, 30);
    }
}
