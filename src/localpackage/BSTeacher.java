package localpackage;

public class BSTeacher {
    private Teacher teacher=new Teacher();
    private TeaREIN teaREIN=new TeaREIN();

    public TeaREIN getTeaREIN() {
        return teaREIN;
    }

    public void setTeaREIN(TeaREIN teaREIN) {
        this.teaREIN = teaREIN;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
