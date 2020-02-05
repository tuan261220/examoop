
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import object.Exam;
import object.Question;
//import Object.User;
import java.sql.SQLException;
import java.util.ArrayList;


public class ExamQuery {

    private static Connection conn = Connect.getConnect();
    private static ResultSet rs = null;
    private static PreparedStatement pst = null;

    public static String testConten() {
        try {
            conn = Connect.getConnect();
            return "Kết Nối CSDL Thành công";
        } catch (Exception e) {
            return "Kết Nối CSDL Thất Bại";
        }
    }
    public static int getCountOfQuestion(String monHoc) {
        try {

            String maMon = getMaMonHoc(monHoc);

            String sql = "select count(QuestionID) from question where SubjectID='" + maMon + "'";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            return -1;
        }

        return -1;
    }

    public static String getMaMonHoc(String monHoc) {
        try {
            String sql = "select SubjectID from subject where SubjectName like N'%" + monHoc + "'";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            String maMon = "";
            if (rs.next()) {

                maMon = rs.getString(1);
                return maMon;

            }
        } catch (SQLException e) {

            return "";

        }

        return "";
    }

    public static ArrayList<Question> getListQuestion(String maMon) {

        ArrayList<Question> listQuestions = new ArrayList<Question>();
        try {
            String sql = "select * from question where SubjectID='" + maMon + "'";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                Question question = new Question();
                question.setQuestionContent(rs.getString("QuestionContent"));
                question.setAnsA(rs.getString("AnsA"));
                question.setAnsB(rs.getString("AnsB"));
                question.setAnsC(rs.getString("AnsC"));
                question.setAnsD(rs.getString("AnsD"));
                question.setSubjectID(maMon);
                question.setQuestionId(rs.getString("QuestionID"));

                listQuestions.add(question);
            }

            return listQuestions;

        } catch (SQLException e) {
            return null;

        }

    }

    public static Exam getDeThi(String maDe) {
        try {

            String sql = "select \n"
                    + "   EXTRACT(SECOND FROM Time) +\n"
                    + "    60 * EXTRACT(MINUTE FROM Time) +\n"
                    + "    3600 * EXTRACT(HOUR FROM Time),\n"
                    + "	Point, ListQuestion, ListRandom from exam where ExamID ='" + maDe + "'";
            //String sql = "SELECT * FROM exam WHERE ExamID ='" + maDe + "'";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            Exam deThi = new Exam();
            //System.out.println(deThi);
            while (rs.next()) {

                deThi.setExamID(maDe);
                deThi.setTime(rs.getLong(1));
                deThi.setTotalQuestion(rs.getString("ListQuestion").trim().split(";").length);
                deThi.setPoint(rs.getInt("Point"));
                deThi.setListQuestionID(rs.getString("ListQuestion").trim());
                deThi.setListRandom(rs.getString("ListRandom").trim());

            }
            return deThi;

        } catch (SQLException e) {

            return null;
        }
    }

    public static ArrayList<String> getListDeThi(String maMon) {
        ArrayList<String> array = new ArrayList<>();

        try {
            String sql = "select ExamID from exam where SubjectID='" + maMon + "'";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {

                array.add(rs.getString(1));
            }

            return array;

        } catch (SQLException e) {

            return null;
        }

    }

    public static Question getQuestion(String maCauHoi) {
        try {
            String sql = "select * from question where QuestionID ='" + maCauHoi + "'";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            Question q = new Question();
            if (rs.next()) {

                q.setAnsA(rs.getString(4));
                q.setAnsB(rs.getString(5));
                q.setAnsC(rs.getString(6));
                q.setAnsD(rs.getString(7));
                q.setQuestionId(maCauHoi);
                q.setQuestionContent(rs.getString(2));
            }

            return q;
        } catch (SQLException e) {

            return null;
        }
    }
    public static ArrayList<String> getArraySubject() {
        try {
            String sql = "select SubjectName from subject";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            ArrayList<String> array = new ArrayList<>();

            while (rs.next()) {

                array.add(rs.getString(1));

            }
            System.out.println(array.size() + "");
            return array;

        } catch (SQLException e) {
            return null;
        }

    }
    public static int excuteUpdate(String sql) {

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            int kq = pst.executeUpdate();
            return kq;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static ResultSet excuteQuery(String sql) {

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    /*public static void main(String[] args) {
        Exam results = getDeThi("1");
        System.out.println(results);
    }
    */
}
