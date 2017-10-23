package localpackage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

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
    public int Stulog(String A,String password){
        Connection con=null;
        PreparedStatement pstID=null;
        PreparedStatement pstPhone=null;
        PreparedStatement pstMailBox=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,user,pswd);
            pstID=con.prepareStatement("SELECT * FROM stuloginfo WHERE StuID=?");
            pstID.setInt(1,Integer.parseInt(A));
            ResultSet rstID=pstID.executeQuery();
            pstPhone=con.prepareStatement("SELECT * FROM stuloginfo WHERE PhoneNumber=? ");
            pstPhone.setString(1,A);
            ResultSet rstPhone=pstPhone.executeQuery();
            pstMailBox=con.prepareStatement("SELECT * FROM stuloginfo WHERE MailBox=?");
            pstMailBox.setString(1,A);
            ResultSet rstMailBox=pstMailBox.executeQuery();
            if(rstID.first()||rstPhone.first()||rstMailBox.first()){
                return 1;
            }else{
                return 0;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return 0;
    }
    /**
     *
     * @param stuloginfo
     * 更新学生个人信息昵称和密码，默认ID一定存在，用户只能操作自己的信息
     */
    public void StuInfoUpdate(Stuloginfo stuloginfo){
        Connection con=null;
        PreparedStatement pst=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,user,pswd);
            pst=con.prepareStatement("UPDATE stuloginfo SET NickName=?,PassWorld=?WHERE StuID=?");
            pst.setString(1,stuloginfo.getNickName());
            pst.setString(2,stuloginfo.getPassWord());
            pst.setInt(3,stuloginfo.getStuID());
            pst.executeUpdate();
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

    }
    public static void main(String[] args) {
       LogInfoDao dao=new LogInfoDao();
       dao.contest();
       Stuloginfo stuloginfo=new Stuloginfo();
       stuloginfo.setNickName("rewr");
       stuloginfo.setPassWord("432423");
       stuloginfo.setPhoneNumber("111");
       stuloginfo.setIDCard("13243243");
       stuloginfo.setMailBox("43243@qq.com");
       Stuloginfo stu= dao.Stuinsert(stuloginfo);
        System.out.println(stu.getIDCard());
//        stuloginfo.setStuID(10006);
//        stuloginfo.setNickName("six");
//        stuloginfo.setPassWord("1243");
////        dao.StuInfoUpdate(stuloginfo);


    }

}
