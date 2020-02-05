/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author DELL
 */
public class Exam {
    private String ExamID;
    private int TotalQuestion;
    private String SubjectID;
    private float point;
    private long time;
    private String listQuestionID;
    private String listRandom;

    public String getExamID() {
        return ExamID;
    }

    public void setExamID(String ExamID) {
        this.ExamID = ExamID;
    }

    public int getTotalQuestion() {
        return TotalQuestion;
    }

    public void setTotalQuestion(int TotalQuestion) {
        this.TotalQuestion = TotalQuestion;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(String SubjectID) {
        this.SubjectID = SubjectID;
    }

    public String getListQuestionID() {
        return listQuestionID;
    }

    public void setListQuestionID(String listQuestionID) {
        this.listQuestionID = listQuestionID;
    }

    public String getListRandom() {
        return listRandom;
    }

    public void setListRandom(String listRandom) {
        this.listRandom = listRandom;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }
    
}
