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
public class User {
    private String UserId;
    private String UserName;
    private String PassWord;

    public String getUserId() {
        return UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }
    
}
