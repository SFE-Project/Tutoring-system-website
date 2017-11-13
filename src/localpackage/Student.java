package localpackage;

public class Student {
    private int ID;
    private String NickName;
    private String Password;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String passWord) {
        Password = passWord;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
