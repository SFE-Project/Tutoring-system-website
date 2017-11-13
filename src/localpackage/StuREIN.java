package localpackage;

public class StuREIN {
    private int ID;
    private String Sex;
    private String SexWanted;
    private String Time;
    private String Subject;
    private String Grade;
    private String Email;

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSexWanted() {
        return SexWanted;
    }

    public void setSexWanted(String sexWanted) {
        SexWanted = sexWanted;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
