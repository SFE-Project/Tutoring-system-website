package localpackage;

import javax.xml.soap.Text;

public class Message {
    private int MessageID;
    private String Messagecol;
    private int OutID;
    private int RecID;

    public String getMessagecol() {
        return Messagecol;
    }

    public void setMessagecol(String messagecol) {
        Messagecol = messagecol;
    }

    public int getRecID() {
        return RecID;
    }

    public void setRecID(int recID) {
        RecID = recID;
    }

    public int getOutID() {
        return OutID;
    }

    public void setOutID(int outID) {
        OutID = outID;
    }


    public int getMessageID() {
        return MessageID;
    }

    public void setMessageID(int messageID) {
        MessageID = messageID;
    }
}
