package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.dao.AnswerDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerDAO answerDAO;

    public AnswerService(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    public List<AnswerDTO> getAllAnswersForQuestion(int question_id) {
        return answerDAO.getAllAnswersForQuestion(question_id);
    }

    public boolean deleteAnswer(int answer_id) {
        return answerDAO.deleteAnswer(answer_id);
    }

    public int addNewAnswer(NewAnswerDTO answer) {
        return answerDAO.addNewAnswer(answer);
    }

    public boolean likeAnswer(int id){return  answerDAO.likeAnswer(id);}
}
