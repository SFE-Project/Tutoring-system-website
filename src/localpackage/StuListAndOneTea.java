package localpackage;

import java.util.List;

public class StuListAndOneTea {
    private List<StuREIN> listofStu;
    private int TeaID;

    public int getTeaID() {
        return TeaID;
    }

    public void setTeaID(int teaID) {
        TeaID = teaID;
    }

    public List<StuREIN> getListofStu() {
        return listofStu;
    }

    public void setListofStu(List<StuREIN> listofStu) {
        this.listofStu = listofStu;
    }
}
