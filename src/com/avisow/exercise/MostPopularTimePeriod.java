package com.avisow.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 3/3/16.
 */
public class MostPopularTimePeriod {
    public List<Integer> getMostTimeAppearedIntegersInMeetingTimess(List<MeetingTimes> list) {
        int start = 0;
        int end = 0;
        int largestSum = 0;

        for (int i = 0; i < 23; i++) {
            int count = 0;

            for (MeetingTimes m : list) {
                if (m.isSlotBooked(i)) {
                    count++;
                }
            }

            if (count > largestSum) {
                start = i;
                end = i;
                largestSum = count;
            }

            if (count >= largestSum) {
                end = i;
            }
        }

        List<Integer> wrapper = new ArrayList<>();
        wrapper.add(start);
        wrapper.add(end);

        return wrapper;
    }
}
