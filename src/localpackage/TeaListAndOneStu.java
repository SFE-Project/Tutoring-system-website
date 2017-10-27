package localpackage;

import java.util.List;

public class TeaListAndOneStu {
    private List<TeaREIN> teaREINS;
    private int StuID;

    public int getStuID() {
        return StuID;
    }

    public void setStuID(int stuID) {
        StuID = stuID;
    }

    public List<TeaREIN> getTeaREINS() {
        return teaREINS;
    }

    public void setTeaREINS(List<TeaREIN> teaREINS) {
        this.teaREINS = teaREINS;
    }
}
