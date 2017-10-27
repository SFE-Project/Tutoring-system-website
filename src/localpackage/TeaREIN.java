package localpackage;

public class TeaREIN {
    private int ID;
    private String Sex;
    private String Education;
    private String Time;
    private String Subject;
    private String Grade;
    /**
     * 教师个人信息包括ID,性别，最高学历，要求时间，学科,年级---仍需添加
     * Sex:0男1女
     * Education:0本科1硕士2博士3博士后
     * Time:0早1中2晚
     * Subject:0数学2外语3语文
     * Grade:0小学1初中2高中
     */

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
