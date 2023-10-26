package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.dao.AnswerDAO;
import com.codecool.stackoverflowtw.service.PSQLConnector;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnswerDaoJdbc implements AnswerDAO {
    private final PSQLConnector connector;

    public AnswerDaoJdbc(PSQLConnector connector) {
        this.connector = connector;
    }
    @Override
    public List<AnswerDTO> getAllAnswersForQuestion(int question_id) {
        List<AnswerDTO> answerDTOS = new ArrayList<>();
        String sql = "SELECT * FROM answers WHERE question_id="+ question_id;
        Connection connection = connector.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int answerId = resultSet.getInt("answer_id");
                String body = resultSet.getString("body");
                int numberOfLikes = resultSet.getInt("number_of_likes");
                int questionId = resultSet.getInt("question_id");
                LocalDate createdAt = resultSet.getDate("created_at").toLocalDate();
                answerDTOS.add(new AnswerDTO(answerId, body, numberOfLikes, questionId, createdAt));
            }
            return answerDTOS;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteAnswer(int id) {
        String sql = "DELETE FROM answers WHERE answer_id=" + id;
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
    public int addNewAnswer(NewAnswerDTO newAnswer) {
        String sql = "INSERT INTO answers (body, number_of_likes, question_id, created_at) VALUES (?, ?, ?, ?)";
        try (Connection conn = connector.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, newAnswer.body());
            preparedStatement.setInt(2,0);
            preparedStatement.setInt(3, newAnswer.question_id());
            preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public boolean likeAnswer(int answer_id) {
        String sql = "UPDATE answers SET number_of_likes = number_of_likes + 1 WHERE answer_id=" + answer_id;
        try{
            Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
