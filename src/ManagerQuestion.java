
import object.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class ManagerQuestion {
    //private Connect connectDB;
    private Connection connection;

    public ManagerQuestion() {
        connection = Connect.getConnect();
    }

    public boolean updateQuestion(Question q) {
        String sql = "UPDATE question SET QuestionContent=?, SubjectID=?, AnsA=?, AnsB=?, AnsC=?, AnsD=? WHERE QuestionID=?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, q.getQuestionContent());
            pst.setString(2, q.getSubjectID());
            pst.setString(3, q.getAnsA());
            pst.setString(4, q.getAnsB());
            pst.setString(5, q.getAnsC());
            pst.setString(6, q.getAnsD());
            //pst.setString(7, q.getAnswer());
            pst.setString(7, q.getQuestionId());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean addQuestion(Question q) {
        String sql = "INSERT INTO question(QuestionID,QuestionContent,SubjectID,AnsA,AnsB,AnsC,AnsD)"
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, q.getQuestionId());
            ps.setString(2, q.getQuestionContent());
            ps.setString(3, q.getSubjectID());
            ps.setString(4, q.getAnsA());
            ps.setString(5, q.getAnsB());
            ps.setString(6, q.getAnsC());
            ps.setString(7, q.getAnsD());
            //ps.setString(8, q.getAnswer());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Question> getListQuestion() {
        ArrayList<Question> list = new ArrayList<Question>();
        String sql = "SELECT * FROM question";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                Question q = new Question();
                q.setQuestionId(rs.getString("QuestionID"));
                q.setQuestionContent(rs.getString("QuestionContent"));
                q.setSubjectID(rs.getString("SubjectID"));
                q.setAnsA(rs.getString("AnsA"));
                q.setAnsB(rs.getString("AnsB"));
                q.setAnsC(rs.getString("AnsC"));
                q.setAnsD(rs.getString("AnsD"));
                //q.setAnswer(rs.getString("Answer"));
                
                list.add(q);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args){
        new ManagerQuestion();
    }
}
