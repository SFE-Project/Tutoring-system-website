package localpackage;

public class User {
    private int UserID;
    private String NickName;
    private String UserType;
    private String RON;
    private int SuperOutID;
    private int SuperRecID;

    public String getRON() {
        return RON;
    }

    public void setRON(String RON) {
        this.RON = RON;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }


    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }
}
