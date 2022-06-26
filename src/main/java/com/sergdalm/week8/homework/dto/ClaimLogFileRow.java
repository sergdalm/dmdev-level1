package com.sergdalm.week8.homework.dto;

import java.time.LocalDateTime;

public record ClaimLogFileRow(int id, LocalDateTime time, String clientName,
                              PhoneNumber phoneNumber, String claim) {
}
