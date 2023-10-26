package com.codecool.stackoverflowtw.controller.dto;

import java.time.LocalDate;

public record AnswerDTO (int id, String body, int number_of_likes, int question_id, LocalDate created_at){
}
