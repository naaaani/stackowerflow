package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private final String url = "jdbc:postgresql://localhost/stack_overflow";
    private final String user = "nandi";
    private final String password = "kakamaka";

    private QuestionsDAO questionsDAO;

    @Autowired
    public QuestionService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public List<QuestionDTO> getAllQuestions() {
        String sql = "SELECT q.question_id, q.title, " +
                "q.created_at, q.number_of_likes, COUNT(a.answer_id) AS answer_count " +
                "FROM questions q " +
                "INNER JOIN answers a ON (a.question_id=q.question_id) " +
                "GROUP BY q.question_id, q.title, q.created_at, q.number_of_likes;";
        Connection connection = getConnection();
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //id, title, answer_count, created_at
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }

    }

    public QuestionDTO getQuestionById(int id) {
        // TODO
        questionsDAO.sayHi();
        return new QuestionDTO(id, "example title", "example desc", LocalDateTime.now());
    }

    public boolean deleteQuestionById(int id) {
        // TODO
        return false;
    }

    public int addNewQuestion(NewQuestionDTO question) {
        // TODO
        int createdId = 0;
        return createdId;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println();
        }
        return connection;
    }
}
