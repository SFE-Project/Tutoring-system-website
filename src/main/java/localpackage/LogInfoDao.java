package localpackage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.org.apache.regexp.internal.RE;

import java.sql.*;

public class LogInfoDao {
        private static final String driver = "com.mysql.jdbc.Driver";
        private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
        private static final String user = "root";
        private static final String pswd = "db414133";
        public void contest() {
            Connection con = null;
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, pswd);
                if (!con.isClosed()) {
                    System.out.println("通信成功！");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    /**
     * 注册学生信息，暂时没有解决昵称和密码为空的问题
     */

    public Stuloginfo Stuinsert(Stuloginfo stuloginfo){
        Stuloginfo stu=new Stuloginfo();
        if(stuloginfo.getPassWord().equals("")||stuloginfo.getNickName().equals("")
                ||stuloginfo.getPhoneNumber().equals("")||stuloginfo.getIDCard().equals("")
                ||stuloginfo.getMailBox().equals("")){
            stu=null;
            return stu;
        }else{
            Connection con=null;
            PreparedStatement pst=null;
            PreparedStatement pst2=null;
            try {
                Class.forName(driver);
                con=DriverManager.getConnection(url,user,pswd);
                pst=con.prepareStatement("INSERT INTO stuloginfo(NickName,PassWord,PhoneNumber," +
                        "IDCard,MailBox) VALUES (?,?,?,?,?)");
                pst.setString(1,stuloginfo.getNickName());
                pst.setString(2,stuloginfo.getPassWord());
                pst.setString(3,stuloginfo.getPhoneNumber());
                pst.setString(4,stuloginfo.getIDCard());
                pst.setString(5,stuloginfo.getMailBox());
                pst.executeUpdate();
                pst2=con.prepareStatement("SELECT * FROM stuloginfo WHERE IDCard=?");
                pst2.setString(1,stuloginfo.getIDCard());
                ResultSet rst=pst2.executeQuery();
               if(rst.first()){
                   stu.setStuID(rst.getInt("StuID"));
                   stu.setNickName(rst.getString("NickName"));
                   stu.setPassWord(rst.getString("PassWord"));
                   stu.setPhoneNumber(rst.getString("PhoneNumber"));
                   stu.setIDCard(rst.getString("IDCard"));
                   stu.setMailBox(rst.getString("MailBox"));
                }


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    pst.close();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return stu;
        }
    }
    public int StuLog(String message,String password){
        Connection con=null;
        PreparedStatement pstID=null;
        PreparedStatement pstPhone=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,user,pswd);
            if(message.length()==5){
                pstID=con.prepareStatement("SELECT * FROM stuloginfo WHERE StuID=?");
                pstID.setInt(1,Integer.parseInt(message));
                ResultSet rstID=pstID.executeQuery();
                if(rstID.first()&&rstID.getString("PassWord").equals(password)){
                    return 1;
                }else{
                    return 0;
                }
            }else{
                pstPhone=con.prepareStatement("SELECT * FROM stuloginfo WHERE PhoneNumber=?");
                pstPhone.setString(1,message);
                ResultSet rstPhone=pstPhone.executeQuery();
                if(rstPhone.first()&&rstPhone.getString("PassWord").equals(password)){
                    return 1;
                }else{
                    return 0;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;

    }
    public static void main(String[] args) {
       LogInfoDao dao=new LogInfoDao();
       dao.contest();
//       Stuloginfo stuloginfo=new Stuloginfo();
//       stuloginfo.setNickName("rewr");
//       stuloginfo.setPassWord("432423");
//       stuloginfo.setPhoneNumber("111");
//       stuloginfo.setIDCard("13243243");
//       stuloginfo.setMailBox("43243@qq.com");
//       Stuloginfo stu= dao.Stuinsert(stuloginfo);
//        System.out.println(stu.getIDCard());
//        stuloginfo.setStuID(10006);
//        stuloginfo.setNickName("six");
//        stuloginfo.setPassWord("1243");
//        dao.StuInfoUpdate(stuloginfo);
        int i=dao.StuLog("14567894038","tom34567");
        System.out.println(i);

    }

}
