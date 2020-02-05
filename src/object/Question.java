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
public class Question {
    private String QuestionId;
    private String QuestionContent;
    private String SubjectID;
    private String AnsA;
    private String AnsB;
    private String AnsC;
    private String AnsD;

    public String getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(String QuestionId) {
        this.QuestionId = QuestionId;
    }
    public String getAnsA() {
        return AnsA;
    }

    public void setAnsA(String AnsA) {
        this.AnsA = AnsA;
    }

    public String getAnsB() {
        return AnsB;
    }

    public void setAnsB(String AnsB) {
        this.AnsB = AnsB;
    }

    public String getAnsC() {
        return AnsC;
    }

    public void setAnsC(String AnsC) {
        this.AnsC = AnsC;
    }

    public String getAnsD() {
        return AnsD;
    }

    public void setAnsD(String AnsD) {
        this.AnsD = AnsD;
    }

    public String getQuestionContent() {
        return QuestionContent;
    }

    public void setQuestionContent(String QuestionContent) {
        this.QuestionContent = QuestionContent;
    }

    public String getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(String SubjectID) {
        this.SubjectID = SubjectID;
    }
}   
