package localpackage;

import com.sun.org.apache.regexp.internal.RE;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/mydatabase?useSSL=false";
    private static final String username="root";
    private static final String pswd="db414133";

    public void Contest(){
        Connection con=null;
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,pswd);
            if(!con.isClosed()){
                System.out.println("通信成功！");
            }else{
                System.out.println("通信失败！");
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
    public Student StuInsert(Student student){
        Student studemo=new Student();
        if(student.getNickName().equals("")||student.getPassWord().equals("")){
            studemo=null;
        }else{
            Connection con=null;
            PreparedStatement pstB=null;
            PreparedStatement pstA=null;
            PreparedStatement pstC=null;
            PreparedStatement pstD=null;
            PreparedStatement pstE=null;
            try {
                Class.forName (driver);
                con=DriverManager.getConnection(url,username,pswd);
                pstB=con.prepareStatement ("INSERT INTO student VALUES(?,?,?)");
                pstB.setInt (1,student.getID());
                pstB.setString(2,student.getNickName());
                pstB.setString(3,student.getPassWord());
                pstB.executeUpdate ();
                pstA=con.prepareStatement("select * from student where id = (select max(id) from student)");
                ResultSet rstA=pstA.executeQuery();
                if(rstA.first()){
                    studemo.setID(rstA.getInt("ID"));
                    studemo.setNickName(rstA.getString("NickName"));
                    studemo.setPassWord(rstA.getString("PassWord"));
                    pstC=con.prepareStatement("INSERT INTO sturein VALUES (?,?,?,?,?,?)");
                    pstC.setInt(1,rstA.getInt("ID"));
                    pstC.setString(2,"男");
                    pstC.setString(3,"不限");
                    pstC.setString(4,"晚上");
                    pstC.setString(5,"数学");
                    pstC.setString(6,"高中");
                    pstC.executeUpdate();
                    pstD=con.prepareStatement("INSERT INTO friendrelationship VALUES (?,?)");
                    System.out.println(rstA.getInt("ID"));
                    pstD.setInt(1,rstA.getInt("ID"));
                    pstD.setString(2,"2000");
                    pstD.executeUpdate();
                    pstE=con.prepareStatement("INSERT INTO persionserver VALUES (?,?)");
                    pstE.setInt(1,rstA.getInt("ID"));
                    pstE.setInt(2,0);
                    pstE.executeUpdate();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace ();
            } catch (SQLException e) {
                e.printStackTrace ();
            } finally {
                try {
                    pstB.close();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return studemo;
    }
    public Student StuLog(Student student){
        Student studemo=new Student();
        Connection con=null;
        PreparedStatement pstS=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstS=con.prepareStatement("SELECT * FROM student WHERE ID=? AND PassWord=?");
            pstS.setInt(1,student.getID());
            pstS.setString(2,student.getPassWord());
            ResultSet rstS=pstS.executeQuery();
            if(rstS.first()){
               studemo.setID(rstS.getInt("ID"));
               studemo.setNickName(rstS.getString("NickName"));
               studemo.setPassWord(rstS.getString("PassWord"));
            }else{
                studemo=null;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return studemo;
    }
    //教师注册
    public Teacher TeaInsert(Teacher teacher){
        Teacher teademo=new Teacher();
        if(teacher.getNickName().equals("")||teacher.getPassWord().equals("")){
            teademo=null;
        }else{
            Connection con=null;
            PreparedStatement pstB=null;
            PreparedStatement pstA=null;
            PreparedStatement pstC=null;
            try {
                Class.forName (driver);
                con=DriverManager.getConnection(url,username,pswd);
                pstB=con.prepareStatement ("INSERT INTO teacher VALUES(?,?,?)");
                pstB.setInt (1,teacher.getID());
                pstB.setString(2,teacher.getNickName());
                pstB.setString(3,teacher.getPassWord());
                pstB.executeUpdate ();
                pstA=con.prepareStatement("select * from teacher where id = (select max(id) from teacher)");
                ResultSet rstA=pstA.executeQuery();
                if(rstA.first()){
                    System.out.println(rstA.getInt("ID"));
                    teademo.setID(rstA.getInt("ID"));
                    teademo.setNickName(rstA.getString("NickName"));
                    teademo.setPassWord(rstA.getString("PassWord"));
                    pstC=con.prepareStatement("INSERT INTO tearein VALUES (?,?,?,?,?,?)");
                    pstC.setInt(1,rstA.getInt("ID"));
                    pstC.setString(2,"男");
                    pstC.setString(3,"本科");
                    pstC.setString(4,"晚上");
                    pstC.setString(5,"数学");
                    pstC.setString(6,"高中");
                    pstC.executeUpdate();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace ();
            } catch (SQLException e) {
                e.printStackTrace ();
            } finally {
                try {
                    pstB.close();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return teademo;
    }
    public Teacher TeaLog(Teacher teacher){
        Teacher teademo=new Teacher();
        Connection con=null;
        PreparedStatement pstS=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstS=con.prepareStatement("SELECT * FROM teacher WHERE ID=? AND PassWord=?");
            pstS.setInt(1,teacher.getID());
            pstS.setString(2,teacher.getPassWord());
            ResultSet rstS=pstS.executeQuery();
            if(rstS.first()){
                teademo.setID(rstS.getInt("ID"));
                teademo.setNickName(rstS.getString("NickName"));
                teademo.setPassWord(rstS.getString("PassWord"));
            }else{
                teademo=null;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return teademo;
    }
    //录入教师个人信息
    public TeaREIN TeaReInUpdate(TeaREIN teaREIN){

        TeaREIN tridemo=new TeaREIN();
        Connection con=null;
        PreparedStatement pstT=null;
        PreparedStatement pstD=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstD=con.prepareStatement("SELECT * FROM tearein WHERE ID=?");
            pstD.setInt(1,teaREIN.getID());
            pstT=con.prepareStatement("UPDATE tearein SET Sex=?,Education=?,Time=?,Subject=?,Grade=? WHERE ID=?");
            pstT.setString(1,teaREIN.getSex());
            pstT.setString(2,teaREIN.getEducation());
            pstT.setString(3,teaREIN.getTime());
            pstT.setString(4,teaREIN.getSubject());
            pstT.setString(5,teaREIN.getGrade());
            pstT.setInt(6,teaREIN.getID());
            pstT.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstT.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return teaREIN;
    }
    public StuREIN StuReInUpdate(StuREIN stuREIN){
        System.out.println(stuREIN.getID());
        StuREIN sridemo=new StuREIN();
        Connection con=null;
        PreparedStatement pstT=null;
        PreparedStatement pstD=null;
        if(stuREIN.getID()==0){
            return null;
        }else{
            try {
                Class.forName(driver);
                con=DriverManager.getConnection(url,username,pswd);
                pstD=con.prepareStatement("SELECT * FROM sturein WHERE ID=?");
                pstD.setInt(1,stuREIN.getID());
                pstT=con.prepareStatement("UPDATE sturein SET Sex=?,SexWanted=?,Time=?,Subject=?,Grade=? WHERE ID=?");
                pstT.setString(1,stuREIN.getSex());
                pstT.setString(2,stuREIN.getSexWanted());
                pstT.setString(3,stuREIN.getTime());
                pstT.setString(4,stuREIN.getSubject());
                pstT.setString(5,stuREIN.getGrade());
                pstT.setInt(6,stuREIN.getID());
                pstT.executeUpdate();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    pstT.close();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return stuREIN;
    }
    //为学生匹配家教
    public TeaListAndOneStu MatchForStu(int StuID){
        TeaListAndOneStu teaListAndOneStu=new TeaListAndOneStu();
        teaListAndOneStu.setStuID(StuID);
        List<TeaREIN> listoftea=new ArrayList<TeaREIN>();
        Connection con=null;
        PreparedStatement pstA=null;
        PreparedStatement pstS=null;
        PreparedStatement pstT=null;
        BasicServe bss=new BasicServe();
        BasicServe bss1=new BasicServe();
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);

            pstS=con.prepareStatement("SELECT * FROM sturein WHERE ID=?");
            pstS.setInt(1,StuID);
            ResultSet rstS=pstS.executeQuery();
            if(rstS.first()){
                if(!rstS.getString("SexWanted").equals("不限")){
                    pstT=con.prepareStatement("SELECT * FROM tearein WHERE Sex=?");
                    pstT.setString(1,rstS.getString("SexWanted"));
                }else{
                    pstT=con.prepareStatement("SELECT * FROM tearein WHERE Sex=? OR Sex =?");
                    pstT.setString(1,"男");
                    pstT.setString(2,"女");
                }
                ResultSet rstT=pstT.executeQuery();
                String ATime=rstS.getString("Time");
                String ASubject=rstS.getString("Subject");
                String AGrade=rstS.getString("Grade");
                while(rstT.next()){
                    String BTime=rstT.getString("Time");
                    String BSubject=rstS.getString("Subject");
                    String BGrade=rstS.getString("Grade");
                   if(bss.MatchON(bss.StringIntoArray(ATime),bss.StringIntoArray(BTime))==1
                           &&bss.MatchON(bss.StringIntoArray(ASubject),bss.StringIntoArray(BSubject))==1
                           &&bss.MatchON(bss.StringIntoArray(AGrade),bss.StringIntoArray(BGrade))==1){
                       TeaREIN tridemo=new TeaREIN();
                       tridemo.setID(rstT.getInt("ID"));
                       tridemo.setSex(rstT.getString("Sex"));
                       tridemo.setEducation(rstT.getString("Education"));
                       tridemo.setTime(rstT.getString("Time"));
                       tridemo.setSubject(rstT.getString("Subject"));
                       tridemo.setGrade(rstT.getString("Grade"));
                       listoftea.add(tridemo);
                   }
                }
                if(listoftea.size()<1){
                    return null;
                }else{
                    teaListAndOneStu.setTeaREINS(listoftea);
                }
            }else{
                return null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return teaListAndOneStu;
    }
    public BSTeacher SingleTea(int TeaID){
        BSTeacher bsTeacher=new BSTeacher();
        Connection con=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstA=con.prepareStatement("SELECT * FROM teacher WHERE ID=?");
            pstA.setInt(1,TeaID);
            ResultSet rstA=pstA.executeQuery();
            pstB=con.prepareStatement("SELECT * FROM tearein WHERE ID=?");
            pstB.setInt(1,TeaID);
            ResultSet rstB=pstB.executeQuery();
            if(rstA.first()&&rstB.first()){
                Teacher teacher=new Teacher();
                teacher.setID(rstA.getInt("ID"));
                teacher.setNickName(rstA.getString("NickName"));
                teacher.setPassWord(rstA.getString("PassWord"));
                TeaREIN teaREIN=new TeaREIN();
                teaREIN.setID(rstB.getInt("ID"));
                teaREIN.setSex(rstB.getString("Sex"));
                teaREIN.setEducation(rstB.getString("Education"));
                teaREIN.setTime(rstB.getString("Time"));
                teaREIN.setSubject(rstB.getString("Subject"));
                teaREIN.setGrade(rstB.getString("Grade"));
                bsTeacher.setTeacher(teacher);
                bsTeacher.setTeaREIN(teaREIN);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return bsTeacher;

    }
    public List<BSTeacher> AllTheTea(){
        List<BSTeacher> listofbstea=new ArrayList<BSTeacher>();

        Connection con=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstA=con.prepareStatement("SELECT * FROM teacher");
            ResultSet rstA=pstA.executeQuery();
            while(rstA.next()){
                pstB=con.prepareStatement("SELECT * FROM tearein WHERE ID=?");
                pstB.setInt(1,rstA.getInt("ID"));
                ResultSet rstB=pstB.executeQuery();
                while(rstB.next()){
                    BSTeacher bsTeacher=new BSTeacher();
                        Teacher teacher=new Teacher();
                        teacher.setID(rstA.getInt("ID"));
                        teacher.setNickName(rstA.getString("NickName"));
                        teacher.setPassWord(rstA.getString("PassWord"));
                        TeaREIN teaREIN=new TeaREIN();
                        teaREIN.setID(rstB.getInt("ID"));
                        teaREIN.setSex(rstB.getString("Sex"));
                        teaREIN.setEducation(rstB.getString("Education"));
                        teaREIN.setTime(rstB.getString("Time"));
                        teaREIN.setSubject(rstB.getString("Subject"));
                        teaREIN.setGrade(rstB.getString("Grade"));
                        bsTeacher.setTeaREIN(teaREIN);
                        bsTeacher.setTeacher(teacher);
                        listofbstea.add(bsTeacher);
                }

            }
//            while(rstA.next()){
//                while(rstB.next()){
//                    if(rstA.getInt("ID")==rstB.getInt("ID")){
//
//                    }
//                }
//            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return listofbstea;
    }
    //加好友功能
    public int MakeFriend(int StuID,int TeaID){
        int flag=1;
        BasicServe bss=new BasicServe();
        Connection con=null;
        PreparedStatement pstAT=null;
        PreparedStatement pstBT=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstA=con.prepareStatement("SELECT * FROM friendrelationship WHERE ID=?");
            pstA.setInt(1,StuID);
            ResultSet rstA=pstA.executeQuery();
            String Str=new String();
            if(rstA.first()){
                String StrArray[]=bss.StringIntoArray(rstA.getString("FSIDList"));
                for(int i=0;i<StrArray.length;i++){
                    if(StrArray[i].equals(String.valueOf(TeaID))){
                        flag=0;
                    }
                }
                if(flag==1){
                    Str=rstA.getString("FSIDList")+", "+TeaID;
                    pstB=con.prepareStatement("UPDATE friendrelationship SET FSIDList=? WHERE ID=?");
                    pstB.setString(1,Str);
                    pstB.setInt(2,StuID);
                    pstB.executeUpdate();
                }else{
                    return flag;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
       return flag;

    }
    public List<Teacher> Friendlist(int StuID){
        List<Teacher> listofteachers=new ArrayList<Teacher>();
        Connection con=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        BasicServe bss=new BasicServe();
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstA=con.prepareStatement("SELECT * FROM friendrelationship WHERE ID=?");
            pstA.setInt(1,StuID);
            ResultSet rstA=pstA.executeQuery();
            if(rstA.first()){
                String[] StrArray=bss.StringIntoArray(rstA.getString("FSIDList"));
                for(int i=0;i<StrArray.length;i++){
                    Teacher teacher=new Teacher();
                    pstB=con.prepareStatement("SELECT * FROM teacher WHERE ID=?");
                    pstB.setInt(1,Integer.parseInt(StrArray[i]));
                    ResultSet rstB=pstB.executeQuery();
                    if(rstB.first()){
                        teacher.setID(rstB.getInt("ID"));
                        teacher.setNickName(rstB.getString("NickName"));
                        teacher.setPassWord(rstB.getString("PassWord"));
                        listofteachers.add(teacher);
                    }
                }
             }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        if(listofteachers.size()>0){
            return listofteachers;
        }else{
            return null;
        }
    }
    public void KillFriends(int TeaID,int StuID){
        Connection con=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        BasicServe bss=new BasicServe();
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstA=con.prepareStatement("SELECT * FROM friendrelationship WHERE ID=?");
            pstA.setInt(1,StuID);
            ResultSet rstA=pstA.executeQuery();
            if(rstA.first()){
                String[] Str=bss.StringIntoArray(rstA.getString("FSIDList"));
                String[] StrNew=new String[Str.length-1];
                int i=0;
                int j=0;
                while(i<Str.length){
                    if(Str[i].equals(String.valueOf(TeaID))){
                        i++;
                    }else{
                        StrNew[j]=Str[i];
                        i++;
                        j++;
                    }
                }
                String StrInto=StrNew[0];
                for(int x=1;x<StrNew.length;x++){
                    StrInto=StrInto+", "+StrNew[x];
                }
                pstB=con.prepareStatement("UPDATE friendrelationship SET FSIDList=? WHERE ID=?");
                pstB.setString(1,StrInto);
                pstB.setInt(2,StuID);
                pstB.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }
    public List<Message> MesageShow(int OutID,int RecID){
        List<Message> listofmessage=new ArrayList<Message>();
        Connection con=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        PreparedStatement pstC=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstB=con.prepareStatement("SELECT * FROM student WHERE ID=?");
            pstB.setInt(1,RecID);
            pstC=con.prepareStatement("SELECT * FROM teacher WHERE ID=?");
            pstC.setInt(1,RecID);
            ResultSet rstB=pstB.executeQuery();
            ResultSet rstC=pstC.executeQuery();
            if((rstB.first())||(rstC.first())){
                pstA=con.prepareStatement("SELECT * FROM message WHERE (OutID=? AND RecID=?)OR(OutID=? AND RecID=?)");
                pstA.setInt(1,OutID);
                pstA.setInt(2,RecID);
                pstA.setInt(3,RecID);
                pstA.setInt(4,OutID);
                ResultSet rstA=pstA.executeQuery();
                while(rstA.next()){
                    Message message=new Message();
                    message.setMessageID(rstA.getInt("ID"));
                    message.setMessagecol(rstA.getString("Messagecol"));
                    message.setOutID(rstA.getInt("OutID"));
                    message.setRecID(rstA.getInt("RecID"));
                    listofmessage.add(message);
                }
            }else{
                return null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return listofmessage;
    }
    public int MessageInsert(int OutID,int RecID,String mess){
        Connection con=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        PreparedStatement pstC=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);

              if(!mess.equals("")){
                    pstA=con.prepareStatement("INSERT INTO message (Messagecol, OutID, RecID) VALUES (?,?,?)");
                    pstA.setString(1,mess);
                    pstA.setInt(2,OutID);
                    pstA.setInt(3,RecID);
                    pstA.executeUpdate();
                    pstB=con.prepareStatement("SELECT * FROM persionserver WHERE ID=?");
                    pstB.setInt(1,OutID);
                    ResultSet rstB=pstB.executeQuery();
                    if(rstB.first()){
                        int num=rstB.getInt("MessageNumber");
                        pstC=con.prepareStatement("Update persionserver SET MessageNumber=? WHERE ID=?");
                        pstC.setInt(1,num+1);
                        pstC.setInt(2,OutID);
                        pstC.executeUpdate();
                    }
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
//    public void MessageAttention(int StuID){
//        Connection con=null;
//        PreparedStatement pstA=null;
//        try {
//            Class.forName(driver);
//            con=DriverManager.getConnection(url,username,pswd);
//            pstA
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//
//        }
//
//    }
    public static void main(String[] args) {
        Dao dao=new Dao();
        dao.MessageInsert(1001,2000,"呵呵");
//        List<Message> list=dao.MesageShow(1001,2000);
//       for(int i=0;i<list.size();i++){
//           System.out.println(list.get(i).getMessagecol());
//
//       }
       //        dao.KillFriends(2024,1001);
//        List<Teacher> listofteacher=new ArrayList<Teacher>();
//        listofteacher=dao.Friendlist(1037);
//        for(int i=0;i<listofteacher.size();i++){
//            System.out.println(listofteacher.get(i).getNickName());
//
//        }
//        int flag=dao.MakeFriend(1001,2022);
//        System.out.println(flag);
//        List<BSTeacher> listofbstea=new ArrayList<BSTeacher>();
//        listofbstea=dao.AllTheTea();

//        BSTeacher bsTeacher=new BSTeacher();
//        bsTeacher=dao.SingleTea(2021);
//        System.out.println(bsTeacher.getTeacher().getNickName()+" "+bsTeacher.getTeaREIN().getTime());
//        Teacher teacher=new Teacher();
//        teacher.setNickName("shi");
//        teacher.setPassWord("1232");
//        dao.TeaInsert(teacher);
//          dao.MatchForStu(1001);
//        TeaREIN teaREIN=new TeaREIN();
//        teaREIN.setID(2013);
//        teaREIN.setSex(1);
//        teaREIN.setEducation(1);
//        teaREIN.setSubject("数学");
//        teaREIN.setTime("晚上");
//        teaREIN.setGrade("高中");
//        dao.TeaReInUpdate(teaREIN);
//        StuREIN stuREIN=new StuREIN();
//        stuREIN.setID(1001);
//        stuREIN.setSex("男");
//        stuREIN.setSexWanted("男");
//        stuREIN.setTime("晚上");
//        stuREIN.setSubject("数学");
//        stuREIN.setGrade("高中");
//        dao.StuReInUpdate(stuREIN);

//        dao.Contest();
//        BasicServe bss=new BasicServe();
//        StuREIN stuREIN=new StuREIN();
//        String A="0, 1, 2";
//        String B="0, 1, 2";
//        System.out.println(bss.MatchON(bss.StringIntoArray(A),bss.StringIntoArray(B)));
//
//        stuREIN.setID(1030);
//        List<TeaREIN> listoftri=new ArrayList<TeaREIN>();
//        listoftri=dao.MatchForStu(1030);
//        System.out.println(listoftri.size());
//        for(int i=0;i<listoftri.size();i++){
//            System.out.println(listoftri.get(i).getID()+" "+
//            listoftri.get(i).getSex()+" "+
//            listoftri.get(i).getEducation());
//        }
        ////////////////////////
//        Student student=new Student();
//        TeaREIN teaREIN=new TeaREIN();
//        teaREIN.setID(2002);
//        teaREIN.setSex(0);
//        teaREIN.setEducation(0);
//        teaREIN.setTime("012");
//        teaREIN.setSubject("012");
//        teaREIN.setGrade("012");
//        dao.TeaReInUpdate(teaREIN);
//        student.setNickName("测试");
//        student.setPassWord("2423");
//        dao.StuInsert(student);
//        student.setID(1027);
//        student.setPassWord("435345");
//        Student studemo=dao.StuLog(student);
//        System.out.println(studemo.getID()+" "+studemo.getNickName()+" "+studemo.getPassWord());
//        Teacher teacher=new Teacher();
////        teacher.setNickName("peter");
//        teacher.setID(2008);
//        teacher.setPassWord("5456");
////        Teacher teademo=dao.TeaInsert(teacher);
//        Teacher teademo=dao.TeaLog(teacher);
//        System.out.println(teademo.getID()+" "+teademo.getNickName()+" "+teademo.getPassWord());

    }
}
