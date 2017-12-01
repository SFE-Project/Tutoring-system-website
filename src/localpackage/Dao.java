package localpackage;

import com.sun.org.apache.regexp.internal.RE;

import javax.xml.transform.Result;
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
    public Student StuInsert(Student student,StuREIN stuRein){
        Student studemo=new Student();
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
            pstB.setString(3,student.getPassword());
            pstB.executeUpdate ();
            pstA=con.prepareStatement("select * from student where id = (select max(id) from student)");
            ResultSet rstA=pstA.executeQuery();
            if(rstA.first()){
                studemo.setID(rstA.getInt("ID"));
                studemo.setNickName(rstA.getString("NickName"));
                studemo.setPassword(rstA.getString("Password"));
                pstC=con.prepareStatement("INSERT INTO sturein VALUES (?,?,?,?,?,?,?)");
                pstC.setInt(1,rstA.getInt("ID"));
                pstC.setString(2,stuRein.getSex());
                pstC.setString(3,stuRein.getSexWanted());
                pstC.setString(4,stuRein.getTime());
                pstC.setString(5,stuRein.getSubject());
                pstC.setString(6,stuRein.getGrade());
                pstC.setString(7,stuRein.getEmail());
                pstC.executeUpdate();
                pstD=con.prepareStatement("INSERT INTO friendrelationship VALUES (?,?)");
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
        return studemo;
    }
    public Student StuLog(Student student){
        Student studemo=new Student();
        Connection con=null;
        PreparedStatement pstS=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstS=con.prepareStatement("SELECT * FROM student WHERE ID=? AND Password=?");
            pstS.setInt(1,student.getID());
            pstS.setString(2,student.getPassword());
            ResultSet rstS=pstS.executeQuery();
            if(rstS.first()){
               studemo.setID(rstS.getInt("ID"));
               studemo.setNickName(rstS.getString("NickName"));
               studemo.setPassword(rstS.getString("Password"));
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
    public Teacher TeaInsert(Teacher teacher,TeaREIN teaREIN){
        Teacher teademo=new Teacher();

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
            pstB.setString(3,teacher.getPassword());
            pstB.executeUpdate ();
            pstA=con.prepareStatement("select * from teacher where id = (select max(id) from teacher)");
            ResultSet rstA=pstA.executeQuery();
            if(rstA.first()){
                teademo.setID(rstA.getInt("ID"));
                teademo.setNickName(rstA.getString("NickName"));
                teademo.setPassword(rstA.getString("Password"));
                pstC=con.prepareStatement("INSERT INTO tearein VALUES (?,?,?,?,?,?,?)");
                pstC.setInt(1,rstA.getInt("ID"));
                pstC.setString(2,teaREIN.getSex());
                pstC.setString(3,teaREIN.getEducation());
                pstC.setString(4,teaREIN.getTime());
                pstC.setString(5,teaREIN.getSubject());
                pstC.setString(6,teaREIN.getGrade());
                pstC.setString(7,teaREIN.getEmail());
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
        return teademo;
    }
    public Teacher TeaLog(Teacher teacher){
        Teacher teademo=new Teacher();
        Connection con=null;
        PreparedStatement pstS=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstS=con.prepareStatement("SELECT * FROM teacher WHERE ID=? AND Password=?");
            pstS.setInt(1,teacher.getID());
            pstS.setString(2,teacher.getPassword());
            ResultSet rstS=pstS.executeQuery();
            if(rstS.first()){
                teademo.setID(rstS.getInt("ID"));
                teademo.setNickName(rstS.getString("NickName"));
                teademo.setPassword(rstS.getString("Password"));
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
            pstT=con.prepareStatement("UPDATE tearein SET Sex=?,Education=?,Time=?,Subject=?,Grade=?,AddressAccess=?,Date=?,Type=?,Price=? WHERE ID=?");
//            pstT=con.prepareStatement("UPDATE tearein SET Sex=?,Education=?,Time=?,Subject=?,Grade=? WHERE ID=?");
            pstT.setString(1,teaREIN.getSex());
            pstT.setString(2,teaREIN.getEducation());
            pstT.setString(3,teaREIN.getTime());
            pstT.setString(4,teaREIN.getSubject());
            pstT.setString(5,teaREIN.getGrade());
            pstT.setString(6,teaREIN.getAddressAccess());
            pstT.setString(7,teaREIN.getDate());
            pstT.setString(8,teaREIN.getType());
            pstT.setString(9,teaREIN.getPrice());
            pstT.setInt(10,teaREIN.getID());
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
                pstT=con.prepareStatement("UPDATE sturein SET Sex=?,SexWanted=?,Time=?,Subject=?,Grade=?,AddressAccess=?,Price=?,Date=?,Type=? WHERE ID=?");
                pstT.setString(1,stuREIN.getSex());
                pstT.setString(2,stuREIN.getSexWanted());
                pstT.setString(3,stuREIN.getTime());
                pstT.setString(4,stuREIN.getSubject());
                pstT.setString(5,stuREIN.getGrade());
                pstT.setString(6,stuREIN.getAddressAccess());
                pstT.setString(7,stuREIN.getPrice());
                pstT.setString(8,stuREIN.getDate());
                pstT.setString(9,stuREIN.getType());
                pstT.setInt(10,stuREIN.getID());
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
    //为教师提供有用的学生信息加强版
    public StuListAndOneTea MatchForTeaPlus(int TeaID){
        StuListAndOneTea stuListAndOneTea=new StuListAndOneTea();
        stuListAndOneTea.setTeaID(TeaID);
        List<StuREIN> listofstu=new ArrayList<StuREIN>();
        Connection connection=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        PreparedStatement pstC=null;
        BasicServe bss=new BasicServe();
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,pswd);
            pstA=connection.prepareStatement("SELECT * FROM tearein WHERE ID=?");
            pstA.setInt(1,TeaID);
            ResultSet rstA=pstA.executeQuery();
            if(rstA.first()){
                String Sex=rstA.getString("Sex");
                String Time=rstA.getString("Time");
                String Education=rstA.getString("Education");
                String Subject=rstA.getString("Subject");
                String Grade=rstA.getString("Grade");
                String Email=rstA.getString("Email");
                String AddressAccess=rstA.getString("AddressAccess");
                String Price=rstA.getString("Price");
                String Date=rstA.getString("Date");
                String Type=rstA.getString("Type");
                System.out.println(Sex+" "+Time+" "+Education+" "+Subject+" "+Grade+" "+AddressAccess+" "+Price+" "+Date+" "+Type);
                pstB=connection.prepareStatement("SELECT * FROM sturein");
                ResultSet rstB=pstB.executeQuery();
                while(rstB.next()){
                    int flaggrade=0;
                    int flagdate=0;
                    int flagsub=0;
                    int flagtime=0;
                    String Sexresp=rstB.getString("SexWanted");
                    String Timeresp=rstB.getString("Time");
                    String Subjectresp=rstB.getString("Subject");
                    String Graderesp=rstB.getString("Grade");
                    String AddressAccessresp=rstB.getString("AddressAccess");
                    String Priceresp=rstB.getString("Price");
                    String Dateresp=rstB.getString("Date");
                    String Typeresp=rstB.getString("Type");

                    if((Sexresp.equals(Sex)||Sexresp.equals("不限"))&&(Typeresp.equals(Type))&&(AddressAccess.equals(AddressAccessresp))&&(Price.equals(Priceresp))) {
                        String DateArray[] = bss.StringIntoArray(Date);
                        String SubArray[] = bss.StringIntoArray(Subject);
                        String TimeArray[] = bss.StringIntoArray(Time);
                        String GradeArray[] = bss.StringIntoArray(Grade);
                        for (int i = 0; i < DateArray.length; i++) { if (DateArray[i].equals(Dateresp)) { flagdate = 1; } }
                        for (int i = 0; i < SubArray.length; i++) { if (SubArray[i].equals(Subjectresp)) { flagsub = 1; } }
                        for (int i = 0; i <TimeArray.length;i++) { if(TimeArray[i].equals(Timeresp)){ flagtime=1; } }
                        for(int i=0;i<GradeArray.length;i++){ if(GradeArray[i].equals(Graderesp)){ flaggrade=1; } }
                        if(flagdate==1&&flaggrade==1&&flagsub==1&&flagtime==1){
                            System.out.println(rstB.getString("ID"));
                            StuREIN stuREIN=new StuREIN();
                            stuREIN.setID(rstB.getInt("ID"));
                            stuREIN.setSex(rstB.getString("Sex"));
                            stuREIN.setSexWanted(rstB.getString("SexWanted"));
                            stuREIN.setSubject(rstB.getString("Subject"));
                            stuREIN.setEmail(rstB.getString("Email"));
                            stuREIN.setTime(rstB.getString("Time"));
                            stuREIN.setGrade(rstB.getString("Grade"));
                            stuREIN.setAddressAccess(rstB.getString("AddressAccess"));
                            stuREIN.setDate(rstB.getString("Date"));
                            stuREIN.setPrice(rstB.getString("Price"));
                            stuREIN.setType(rstB.getString("Type"));
                            listofstu.add(stuREIN);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        stuListAndOneTea.setListofStu(listofstu);
        return stuListAndOneTea;
    }
    //为学生匹配家教
    //改进为学生匹配
    public TeaListAndOneStu MatchForStuPlus(int StuID){
        TeaListAndOneStu teaListAndOneStu=new TeaListAndOneStu();
        teaListAndOneStu.setStuID(StuID);
        List<TeaREIN> listoftea=new ArrayList<TeaREIN>();
        Connection connection=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        PreparedStatement pstC=null;
        BasicServe bss=new BasicServe();
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,pswd);
            pstA=connection.prepareStatement("SELECT * FROM sturein WHERE ID=?");
            pstA.setInt(1,StuID);
            ResultSet rstA=pstA.executeQuery();
            if(rstA.first()){
               String SexWanted=rstA.getString("SexWanted");
               String Time=rstA.getString("Time");
               String Subject=rstA.getString("Subject");
               String Grade=rstA.getString("Grade");
               String AddressAccess=rstA.getString("AddressAccess");
               String Price=rstA.getString("Price");
               String Date=rstA.getString("Date");
               String Type=rstA.getString("Type");
                System.out.println(SexWanted+" "+Time+" "+Subject+" "+Grade+" "+AddressAccess+" "+Price+" "+Date+" "+Type);
                pstB=connection.prepareStatement("SELECT * FROM tearein");
                ResultSet rstB=pstB.executeQuery();
                while(rstB.next()){
                    int flaggrade=0;
                    int flagdate=0;
                    int flagsub=0;
                    int flagtime=0;
                    String Sexresp=rstB.getString("Sex");//
                    String Timeresp=rstB.getString("Time");
                    String Subjectresp=rstB.getString("Subject");
                    String Graderesp=rstB.getString("Grade");
                    String AddressAccessresp=rstB.getString("AddressAccess");//
                    String Priceresp=rstB.getString("Price");//
                    String Dateresp=rstB.getString("Date");
                    String Typeresp=rstB.getString("Type");//
                    if((Sexresp.equals(SexWanted)||SexWanted.equals("不限"))&&(Typeresp.equals(Type))&&(AddressAccess.equals(AddressAccessresp))&&(Price.equals(Priceresp))){
                        String DateArray[]=bss.StringIntoArray(Dateresp);
                        String SubArray[]=bss.StringIntoArray(Subjectresp);
                        String TimeArray[]=bss.StringIntoArray(Timeresp);
                        String GradeArray[]=bss.StringIntoArray(Graderesp);
                        for(int i=0;i<DateArray.length;i++){ if(DateArray[i].equals(Date)){ flagdate=1; } }
                        for(int i=0;i<SubArray.length;i++){ if(SubArray[i].equals(Subject)){ flagsub=1; } }
                        for(int i=0;i<TimeArray.length;i++){ if(TimeArray[i].equals(Time)){ flagtime=1;} }
                        for(int i=0;i<GradeArray.length;i++){
                            if(GradeArray[i].equals(Grade)){
                                flaggrade=1;
                            }
                        }
                        if(flagdate==1&&flagsub==1&&flagtime==1&&(flaggrade==1)){
                           TeaREIN teaREIN=new TeaREIN();
                           teaREIN.setID(rstB.getInt("ID"));
                           teaREIN.setSex(rstB.getString("Sex"));
                           teaREIN.setEducation(rstB.getString("Education"));
                           teaREIN.setTime(rstB.getString("Time"));
                           teaREIN.setSubject(rstB.getString("Subject"));
                           teaREIN.setGrade(rstB.getString("Grade"));
                           teaREIN.setEmail(rstB.getString("Email"));
                           teaREIN.setAddressAccess(rstB.getString("AddressAccess"));
                           teaREIN.setDate(rstB.getString("Date"));
                           teaREIN.setType(rstB.getString("Type"));
                           teaREIN.setPrice(rstB.getString("Price"));
                           listoftea.add(teaREIN);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        teaListAndOneStu.setTeaREINS(listoftea);
        return teaListAndOneStu;
    }
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
                teacher.setPassword(rstA.getString("Password"));
                TeaREIN teaREIN=new TeaREIN();
                teaREIN.setID(rstB.getInt("ID"));
                teaREIN.setSex(rstB.getString("Sex"));
                teaREIN.setEducation(rstB.getString("Education"));
                teaREIN.setTime(rstB.getString("Time"));
                teaREIN.setSubject(rstB.getString("Subject"));
                teaREIN.setGrade(rstB.getString("Grade"));
                teaREIN.setEmail(rstB.getString(("Email")));
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
                        teacher.setPassword(rstA.getString("Password"));
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
                        teacher.setPassword(rstB.getString("Password"));
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
                  System.out.println(OutID);
                    ResultSet rstB=pstB.executeQuery();
                  System.out.println("num11");
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

    public List<BSTeacher> ProfileTea(String subject){
        List<BSTeacher> listofbstea=new ArrayList<BSTeacher>();

        Connection con=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstA=con.prepareStatement("SELECT * FROM tearein WHERE Subject=?");
            pstA.setString(1,subject);
            ResultSet rstA=pstA.executeQuery();
            int counter=0;
            while(rstA.next()&&counter<9){
                pstB=con.prepareStatement("SELECT * FROM teacher WHERE ID=?");
                pstB.setInt(1,rstA.getInt("ID"));
                ResultSet rstB=pstB.executeQuery();
                while(rstB.next()){
                    BSTeacher bsTeacher=new BSTeacher();
                    Teacher teacher=new Teacher();
                    teacher.setID(rstB.getInt("ID"));
                    teacher.setNickName(rstB.getString("NickName"));
                    teacher.setPassword(rstB.getString("Password"));
                    TeaREIN teaREIN=new TeaREIN();
                    teaREIN.setID(rstA.getInt("ID"));
                    teaREIN.setSex(rstA.getString("Sex"));
                    teaREIN.setEducation(rstA.getString("Education"));
                    teaREIN.setTime(rstA.getString("Time"));
                    teaREIN.setSubject(rstA.getString("Subject"));
                    teaREIN.setGrade(rstA.getString("Grade"));
                    bsTeacher.setTeaREIN(teaREIN);
                    bsTeacher.setTeacher(teacher);
                    listofbstea.add(bsTeacher);
                }
                counter++;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return listofbstea;
    }


    public List<BSTeacher> TopTea(){
        List<BSTeacher> listofbstea=new ArrayList<BSTeacher>();

        Connection con=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstA=con.prepareStatement("SELECT * FROM tearein");
            ResultSet rstA=pstA.executeQuery();
            int counter=0;
            while(rstA.next()&&counter<8){
                pstB=con.prepareStatement("SELECT * FROM teacher WHERE ID=?");
                pstB.setInt(1,rstA.getInt("ID"));
                ResultSet rstB=pstB.executeQuery();
                while(rstB.next()){
                    BSTeacher bsTeacher=new BSTeacher();
                    Teacher teacher=new Teacher();
                    teacher.setID(rstB.getInt("ID"));
                    teacher.setNickName(rstB.getString("NickName"));
                    teacher.setPassword(rstB.getString("Password"));
                    TeaREIN teaREIN=new TeaREIN();
                    teaREIN.setID(rstA.getInt("ID"));
                    teaREIN.setSex(rstA.getString("Sex"));
                    teaREIN.setEducation(rstA.getString("Education"));
                    teaREIN.setTime(rstA.getString("Time"));
                    teaREIN.setSubject(rstA.getString("Subject"));
                    teaREIN.setGrade(rstA.getString("Grade"));
                    bsTeacher.setTeaREIN(teaREIN);
                    bsTeacher.setTeacher(teacher);
                    listofbstea.add(bsTeacher);
                }
                counter++;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return listofbstea;
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
//    学生评价教师功能
    public List<StuEvaluationtoTea> EvaluationShow(int TeaID){
        int existflag=1;
       List<StuEvaluationtoTea> listofEvaluation=new ArrayList<StuEvaluationtoTea>();
        Connection connection=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,pswd);
            pstA=connection.prepareStatement("SELECT * FROM evaluation WHERE Evaluated=?");
            pstB=connection.prepareStatement("SELECT * FROM evaluation WHERE Evaluated=?");
            pstA.setInt(1,TeaID);
            pstB.setInt(1,TeaID);
            ResultSet rstA=pstA.executeQuery();
            ResultSet rstB=pstB.executeQuery();
            if(rstB.first()){
                while(rstA.next()){
                    StuEvaluationtoTea stuEvaluationtoTea=new StuEvaluationtoTea();
                    stuEvaluationtoTea.setEvaluatorID(rstA.getInt("Evaluator"));
                    stuEvaluationtoTea.setEvaluatedID(rstA.getInt("Evaluated"));
                    stuEvaluationtoTea.setEvaluateContent(rstA.getString("Content"));
                    stuEvaluationtoTea.setStar(rstA.getInt("Star"));
                    listofEvaluation.add(stuEvaluationtoTea);
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
        return listofEvaluation;
    }
//   教师评价米密钥设置
    public void UpdateEvaluationPassword(int TeaID,String PASSWORD){
        Connection connection=null;
        PreparedStatement pstA=null;
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,pswd);
            pstA=connection.prepareStatement("UPDATE tearein SET EvaluationPassword=? WHERE ID=?");
            pstA.setString(1,PASSWORD);
            pstA.setInt(2,TeaID);
            pstA.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
    //敏感操作，教师查看自己评价密钥
    public String EvaluationPasswordShow(int TeaID){
        Connection connection=null;
        PreparedStatement pstA=null;
        String EEvaluationPassword=new String();
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,pswd);
            pstA=connection.prepareStatement("SELECT * FROM tearein WHERE ID=?");
            pstA.setInt(1,TeaID);
            ResultSet rstA=pstA.executeQuery();
            if(rstA.first()){
                EEvaluationPassword=rstA.getString("EvaluationPassword");
                if(EEvaluationPassword.equals("")){
                    return "NULL";
                }
//                System.out.println(EEvaluationPassword);
            }else{
                return null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return EEvaluationPassword;
    }
//    
    public static void main(String[] args) {
//        Dao dao=new Dao();
//        dao.MessageInsert(1001,2000,"呵呵");
//        TeaListAndOneStu teaListAndOneStu=new TeaListAndOneStu();
//        List<TeaREIN> listoftea=new ArrayList<TeaREIN>();
        Dao dao=new Dao();
        String ww=dao.EvaluationPasswordShow(2001);

//        dao.UpdateEvaluationPassword(2000,"1111");
//        List<StuEvaluationtoTea> stuEvaluationtoTeaList=new ArrayList<StuEvaluationtoTea>();
//        stuEvaluationtoTeaList=dao.EvaluationShow(2000);
//        if(stuEvaluationtoTeaList==null){
//            System.out.println("23rcr44vr");
//        }
//        for(int i=0;i<stuEvaluationtoTeaList.size();i++){
//            System.out.println(stuEvaluationtoTeaList.get(i).getEvaluatedID()+" "+
//            stuEvaluationtoTeaList.get(i).getEvaluatorID()+" "+
//            stuEvaluationtoTeaList.get(i).getEvaluateContent()+" "+
//            stuEvaluationtoTeaList.get(i).getStar());
//        }
//        StuListAndOneTea stuListAndOneTea=new StuListAndOneTea();
//        List<StuREIN> listofstu=new ArrayList<StuREIN>();
//        stuListAndOneTea=dao.MatchForTeaPlus(2000);
//        listofstu=stuListAndOneTea.getListofStu();
//        System.out.println(stuListAndOneTea.getListofStu().size());
//        for(int i=0;i<listofstu.size();i++){
//            System.out.println(listofstu.get(i).getID()+" "+
//            listofstu.get(i).getSex()+" "+
//                    listofstu.get(i).getSubject()+" "+
//                    listofstu.get(i).getTime()+" "+
//                    listofstu.get(i).getAddressAccess()+" "+
//                    listofstu.get(i).getSexWanted()+" "+
//                    listofstu.get(i).getGrade()+" "+
//                    listofstu.get(i).getDate()+" "+
//                    listofstu.get(i).getPrice()+" "+
//                    listofstu.get(i).getEmail()+" "+
//                    listofstu.get(i).getType()+" "
//
//            );
//        }
//        teaListAndOneStu=dao.MatchForStuPlus(1001);
//        listoftea=teaListAndOneStu.getTeaREINS();
//        System.out.println(listoftea.size());
//        for(int i=0;i<listoftea.size();i++){
//            System.out.println(listoftea.get(i).getID()+" "+
//            listoftea.get(i).getSex()+" "+
//                    listoftea.get(i).getSubject()+" "+
//                    listoftea.get(i).getTime()+" "+
//                    listoftea.get(i).getAddressAccess()+" "+
//                    listoftea.get(i).getEducation()+" "+
//                    listoftea.get(i).getGrade()+" "+
//                    listoftea.get(i).getDate()+" "+
//                    listoftea.get(i).getPrice()+" "+
//                    listoftea.get(i).getEmail()+" "+
//                    listoftea.get(i).getType()+" "
//
//            );
//        }
//        TeaREIN teaREIN=new TeaREIN();
//        teaREIN.setID(2000);
//        teaREIN.setSex("男");
//        teaREIN.setGrade("初中");
//        teaREIN.setTime("晚上");
//        teaREIN.setSubject("数学");
//        teaREIN.setEducation("本科");
//        teaREIN.setDate("寒假");
//        teaREIN.setAddressAccess("南岗");
//        teaREIN.setPrice("0/80");
//        teaREIN.setType("0");
//        teaREIN=dao.TeaReInUpdate(teaREIN);

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
//        teacher.setPassword("1232");
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
//        student.setPassword("2423");
//        dao.StuInsert(student);
//        student.setID(1027);
//        student.setPassword("435345");
//        Student studemo=dao.StuLog(student);
//        System.out.println(studemo.getID()+" "+studemo.getNickName()+" "+studemo.getPassword());
//        Teacher teacher=new Teacher();
////        teacher.setNickName("peter");
//        teacher.setID(2008);
//        teacher.setPassword("5456");
////        Teacher teademo=dao.TeaInsert(teacher);
//        Teacher teademo=dao.TeaLog(teacher);
//        System.out.println(teademo.getID()+" "+teademo.getNickName()+" "+teademo.getPassword());

    }
}
