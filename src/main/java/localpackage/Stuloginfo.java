package localpackage;

public class Stuloginfo {
    private int StuID;
    private String NickName;
    private String PassWord;
    private String PhoneNumber;
    private String IDCard;
    private String MailBox;
    public int getStuID() {
        return StuID;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getMailBox() {
        return MailBox;
    }

    public void setMailBox(String mailBox) {
        MailBox = mailBox;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setStuID(int stuID) {
        StuID = stuID;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
}

