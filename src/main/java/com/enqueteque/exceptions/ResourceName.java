package com.enqueteque.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResourceName {
    POLL("Poll");

    private final String name;
}