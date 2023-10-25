package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
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
    public QuestionService(QuestionsDAO questionsDAO, PSQLConnector connector) {
        this.questionsDAO = questionsDAO;
        this.connector = connector;
    }

    public List<QuestionDTO> getAllQuestions() {
        String sql = "SELECT q.question_id, q.title, " +
                "q.created_at, q.number_of_likes, COUNT(a.answer_id) AS answer_count " +
                "FROM questions q " +
                "INNER JOIN answers a ON (a.question_id=q.question_id) " +
                "GROUP BY q.question_id, q.title, q.created_at, q.number_of_likes;";
        Connection connection = connector.getConnection();
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                //id, title, answer_count, created_at, likes
                int id = resultSet.getInt("question_id");
                String title = resultSet.getString("title");
                LocalDate createdAt = resultSet.getDate("created_at").toLocalDate();
                int answerCount = resultSet.getInt("answer_count");
                int numberOfLikes = resultSet.getInt("number_of_likes");

                questionDTOS.add(new QuestionDTO(id, title, createdAt, answerCount, numberOfLikes));
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return questionDTOS;
    }

    public QuestionDTO getQuestionById(int id) {
        // TODO
        questionsDAO.sayHi();
        return null;
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

}
