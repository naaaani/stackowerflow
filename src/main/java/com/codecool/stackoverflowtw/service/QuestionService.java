package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.QuestionsDaoJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private final QuestionsDAO questionsDAO;

    public QuestionService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public List<QuestionDTO> getAllQuestions() {
        return questionsDAO.getAllQuestions();
    }

    public QuestionDTO getQuestionById(int id) {
        return questionsDAO.getQuestionById(id);
    }

    public boolean deleteQuestionById(int id) {
        return questionsDAO.deleteQuestionById(id);
    }

    public int addNewQuestion(NewQuestionDTO question) {
       return questionsDAO.addNewQuestion(question);
    }

}
