package com.sergdalm.week8.practice.dmdev.report;

import com.sergdalm.week8.practice.dmdev.dto.LogFileDay;

import java.util.List;

public interface ReportGenerator {

    String generate(List<LogFileDay> logFileDays);
}
