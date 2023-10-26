package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.service.PSQLConnector;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QuestionsDaoJdbc implements QuestionsDAO {

    private final PSQLConnector connector;

    public QuestionsDaoJdbc(PSQLConnector connector) {
        this.connector = connector;
    }

    @Override
    public List<QuestionDTO> getAllQuestions() {
        String sql = "SELECT q.question_id, q.title, " +
                "q.created_at, q.number_of_likes, q.body, COUNT(a.answer_id) AS answer_count " +
                "FROM questions q " +
                "INNER JOIN answers a ON (a.question_id=q.question_id) " +
                "GROUP BY q.question_id, q.title, q.created_at, q.number_of_likes, q.body;";
        Connection connection = connector.getConnection();
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                //id, title, answer_count, created_at, likes
                int id = resultSet.getInt("question_id");
                String title = resultSet.getString("title");
                String body = resultSet.getString("body");
                LocalDate createdAt = resultSet.getDate("created_at").toLocalDate();
                int answerCount = resultSet.getInt("answer_count");
                int numberOfLikes = resultSet.getInt("number_of_likes");

                questionDTOS.add(new QuestionDTO(id, title, body, createdAt, answerCount, numberOfLikes));
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return questionDTOS;
    }

    @Override
    public QuestionDTO getQuestionById(int id) {
        String sql = "SELECT * FROM questions WHERE question_id=" + id;
        Connection connection = connector.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                //id, title, answer_count, created_at, likes
                int questionId = resultSet.getInt("question_id");
                String title = resultSet.getString("title");
                String body = resultSet.getString("body");
                LocalDate createdAt = resultSet.getDate("created_at").toLocalDate();
                int numberOfLikes = resultSet.getInt("number_of_likes");

                return new QuestionDTO(questionId, title, body, createdAt, numberOfLikes, 0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteQuestionById(int id) {
        String sql = "DELETE FROM questions WHERE question_id=" + id;
        Connection connection = connector.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public int addNewQuestion(NewQuestionDTO newQuestion) {
        String sql = "INSERT INTO questions (title, body, number_of_likes, created_at) VALUES (?, ?, ?, ?)";
        try (Connection conn = connector.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, newQuestion.title());
            preparedStatement.setString(2, newQuestion.body());
            preparedStatement.setInt(3, 0);
            preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

}
