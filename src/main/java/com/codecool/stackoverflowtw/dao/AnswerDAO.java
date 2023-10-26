package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;

import java.util.List;

public interface AnswerDAO {
    List<AnswerDTO> getAllAnswersForQuestion(int question_id);

    boolean deleteAnswer(int answer_id);

    int addNewAnswer(NewAnswerDTO answer);

    boolean likeAnswer(int answer_id);
}
