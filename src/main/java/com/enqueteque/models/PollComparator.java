package com.enqueteque.models;

import java.util.Comparator;

public class PollComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Poll poll1 = (Poll) o1;
        Poll poll2 = (Poll) o2;
        return poll1.getCreateDate()
                .compareTo(poll2.getCreateDate());
    }
}
