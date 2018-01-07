package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ruchit.
 */
public class EmployeeFreeTime {
    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        List<List<Interval>> schedule;
        /*schedule = Arrays.asList(Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
                Arrays.asList(new Interval(1, 3)), Arrays.asList(new Interval(4, 10)));*/
        /*schedule = Arrays.asList(Arrays.asList(new Interval(1, 3), new Interval(6, 7)),
                Arrays.asList(new Interval(2, 4)), Arrays.asList(new Interval(2, 5), new Interval(9, 12)));*/
        /*schedule = Arrays.asList(Arrays.asList(new Interval(7, 24), new Interval(29, 33)),
                Arrays.asList(new Interval(6, 24)), Arrays.asList(new Interval(5, 16), new Interval(18, 26)),
                Arrays.asList(new Interval(9, 16)), Arrays.asList(new Interval(0, 25)));*/
        schedule = Arrays.asList(Arrays.asList(new Interval(45, 57), new Interval(66, 69), new Interval(94, 99)),
                Arrays.asList(new Interval(56, 59), new Interval(61, 75), new Interval(80, 81)), Arrays.asList(new Interval(39, 57), new Interval(65, 74)),
                Arrays.asList(new Interval(68, 71), new Interval(78, 81)), Arrays.asList(new Interval(57, 87), new Interval(91, 94)));
        List<Interval> result = employeeFreeTime(schedule);
        for (Interval i : result) {
            System.out.println(i.start + " : " + i.end);
        }
    }

    static class IntervalCompare implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            if (i2.start < i1.start) {
                return 1;
            } else if (i1.start == i2.start && i2.end < i1.end) {
                return 1;
            } else return -1;
        }
    }

    private static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> combinedList = new ArrayList<>();
        List<Interval> result = new ArrayList<>();
        for (List<Interval> list : schedule) {
            combinedList.addAll(list);
        }

        IntervalCompare intervalCompare = new IntervalCompare();
        combinedList.sort(intervalCompare);

        int currentEnd = Integer.MIN_VALUE;
        for (int i = 0; i < combinedList.size() - 1; i++) {
            if (combinedList.get(i).end < combinedList.get(i + 1).start) {
                if (currentEnd <= combinedList.get(i).end) {
                    currentEnd = combinedList.get(i + 1).end;
                    result.add(new Interval(combinedList.get(i).end, combinedList.get(i + 1).start));
                } else if (currentEnd > combinedList.get(i).end && currentEnd < combinedList.get(i + 1).start) {
                    result.add(new Interval(currentEnd, combinedList.get(i + 1).start));
                    currentEnd = combinedList.get(i + 1).end;
                } else {
                    currentEnd = Math.max(currentEnd, combinedList.get(i + 1).end);
                }
            } else {
                currentEnd = Math.max(currentEnd, combinedList.get(i).end);
                currentEnd = Math.max(currentEnd, combinedList.get(i + 1).end);
            }
        }
        return result;
    }
}
