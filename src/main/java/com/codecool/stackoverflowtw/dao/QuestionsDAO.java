package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;

import java.util.List;

public interface QuestionsDAO {
    List<QuestionDTO> getAllQuestions();

    QuestionDTO getQuestionById(int id);

    boolean deleteQuestionById(int id);
    int addNewQuestion(NewQuestionDTO question);
}

