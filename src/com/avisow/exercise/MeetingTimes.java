package com.avisow.exercise;

/**
 * Created by ryan on 3/3/16.
 */
public class MeetingTimes {
    private final int start;
    private final int end;

    public MeetingTimes(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isSlotBooked(int i) {
        if (i >= start && i < end) {
            return true;
        }

        return false;
    }
}
