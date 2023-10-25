package com.codecool.stackoverflowtw.dao.model;

import java.time.LocalDate;

public record Answer(int id, String body, int number_of_likes, int question_id, LocalDate created_at) {
}
