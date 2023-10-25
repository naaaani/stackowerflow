package com.codecool.stackoverflowtw.dao.model;

import java.time.LocalDate;

public record Question (int id, String title, String body, int number_of_likes, LocalDate created_at, int answer_count) {
}
