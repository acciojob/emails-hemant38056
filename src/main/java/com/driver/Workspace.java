package com.driver;

import com.google.common.primitives.UnsignedInteger;
import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings


    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        calendar = new ArrayList<>();

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        if(calendar.size() == 0){
            return 0;
        }
        Collections.sort(calendar, (a, b) -> {
            if(a.getStartTime().compareTo(b.getStartTime()) == 0){
                return a.getEndTime().compareTo(b.getEndTime());
            }
            return a.getStartTime().compareTo(b.getStartTime());
        });
        int count = 0;
        for(int i = 0; i < calendar.size(); i++){
            int temp = 1;
            int index = i;
            Meeting previous = calendar.get(index);
            for(int j = i + 1; j < calendar.size(); j++){
                Meeting current = calendar.get(j);
                LocalTime time1 = current.getStartTime();
                LocalTime time2 = previous.getEndTime();
                int flag = time1.compareTo(time2);
                if(flag > 0){
                    temp = temp + 1;
                    index = j;
                }
                count = Math.max(count, temp);
            }
        }
        return count;
    }
}
