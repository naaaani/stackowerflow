package com.codecool.stackoverflowtw.controller.dto;

import java.time.LocalDate;

public record QuestionDTO(int id, String title, LocalDate created, int likes, int answerCount) {}
