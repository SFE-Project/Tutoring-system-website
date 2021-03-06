package localpackage;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.struts2.ServletActionContext;
import org.gjt.mm.mysql.Driver;

import javax.xml.transform.Result;
import javax.xml.ws.soap.Addressing;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://fusslpgsseus.mysql.sae.sina.com.cn:10013/mydatabase";
//     private static final String url="jdbc:mysql://localhost:3306/mydatabase?useSSL=false";
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
                pstC=con.prepareStatement("INSERT INTO sturein VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                pstC.setInt(1,rstA.getInt("ID"));
                pstC.setString(2,stuRein.getSex());
                pstC.setString(3,stuRein.getSexWanted());
                pstC.setString(4,stuRein.getTime());
                pstC.setString(5,stuRein.getSubject());
                pstC.setString(6,stuRein.getGrade());
                pstC.setString(7,stuRein.getEmail());
                pstC.setString(8,stuRein.getAddressAccess());
                pstC.setString(9,stuRein.getPrice());
                pstC.setString(10,stuRein.getDate());
                pstC.setString(11,stuRein.getType());
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
                pstC=con.prepareStatement("INSERT INTO tearein VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pstC.setInt(1,rstA.getInt("ID"));
                pstC.setString(2,teaREIN.getSex());
                pstC.setString(3,teaREIN.getEducation());
                pstC.setString(4,teaREIN.getTime());
                pstC.setString(5,teaREIN.getSubject());
                pstC.setString(6,teaREIN.getGrade());
                pstC.setString(7,teaREIN.getEmail());
                pstC.setString(8,teaREIN.getAddressAccess());
                pstC.setString(9, teaREIN.getDate());
                pstC.setString(10,teaREIN.getType());
                pstC.setString(11,teaREIN.getPrice());
                pstC.setString(12,teaREIN.getEvaluationPassword());
                pstC.setString(13,teaREIN.getPersionalIntroduction());
                pstC.setFloat(14,3);
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
                String DateArrayTea[] = bss.StringIntoArray(Date);
                String SubArrayTea[] = bss.StringIntoArray(Subject);
                String TimeArrayTea[] = bss.StringIntoArray(Time);
                String GradeArrayTea[] = bss.StringIntoArray(Grade);
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
                    String DateArrayStu[] = bss.StringIntoArray(Dateresp);
                    String SubArrayStu[] = bss.StringIntoArray(Subjectresp);
                    String TimeArrayStu[] = bss.StringIntoArray(Timeresp);
                    String GradeArrayStu[] = bss.StringIntoArray(Graderesp);
                    if((Sexresp.equals(Sex)||Sexresp.equals("不限"))&&(Typeresp.equals(Type))
                            &&(AddressAccess.equals(AddressAccessresp))&&(Price.equals(Priceresp))) {

                        for (int i = 0; i < DateArrayStu.length; i++) {
                            for(int j=0;j<DateArrayTea.length;j++){
                                if (DateArrayStu[i].equals(DateArrayTea[j])) { flagdate = 1; }
                            }
                        }
                        for (int i = 0; i < SubArrayStu.length; i++) {
                            for(int j=0;j<SubArrayTea.length;j++){
                                if (SubArrayStu[i].equals(SubArrayTea[j])) { flagsub = 1; }
                            }
                        }
                        for (int i = 0; i <TimeArrayStu.length;i++) {
                            for(int j=0;j<TimeArrayTea.length;j++){
                                if(TimeArrayStu[i].equals(TimeArrayTea[j])){ flagtime=1; }
                            }
                        }
                        for(int i=0;i<GradeArrayStu.length;i++){
                            for(int j=0;j<GradeArrayTea.length;j++){
                                if(GradeArrayStu[i].equals(GradeArrayTea[j])){ flaggrade=1; }
                            }
                        }
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
                String TimeArrayStu[]=bss.StringIntoArray(Time);
                String SubjectArrayStu[]=bss.StringIntoArray(Subject);
                String GradeArrayStu[]=bss.StringIntoArray(Grade);
                String DateArrayStu[]=bss.StringIntoArray(Date);
                System.out.println(SexWanted+" "+Time+" "+Subject+" "+Grade+" "+AddressAccess
                        +" "+Price+" "+Date+" "+Type);
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
                    if((Sexresp.equals(SexWanted)||SexWanted.equals("不限"))&&
                            (Typeresp.equals(Type))&&(AddressAccess.equals(AddressAccessresp))&&(Price.equals
                            (Priceresp))){
                        String DateArray[]=bss.StringIntoArray(Dateresp);
                        String SubArray[]=bss.StringIntoArray(Subjectresp);
                        String TimeArray[]=bss.StringIntoArray(Timeresp);
                        String GradeArray[]=bss.StringIntoArray(Graderesp);
                        for(int i=0;i<DateArray.length;i++){
                            for(int j=0;j<DateArrayStu.length;j++){
                                if(DateArray[i].equals(DateArrayStu[j])){
                                    flagdate=1;
                                }
                            }
                        }
                        for(int i=0;i<SubArray.length;i++){
                            for(int j=0;j<SubjectArrayStu.length;j++){
                                if(SubArray[i].equals(SubjectArrayStu[j])){ flagsub=1; }
                            }
                        }
                        for(int i=0;i<TimeArray.length;i++){
                            for(int j=0;j<TimeArrayStu.length;j++){
                                if(TimeArray[i].equals(TimeArrayStu[j])){ flagtime=1;} }
                        }

                        for(int i=0;i<GradeArray.length;i++){
                            for(int j=0;j<GradeArrayStu.length;j++){
                                if(GradeArray[i].equals(GradeArrayStu[j])){
                                    flaggrade=1;
                                }
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
                teaREIN.setPersionalIntroduction(rstB.getString("PersionalIntroduction"));
                teaREIN.setAddressAccess(rstB.getString("AddressAccess"));
                teaREIN.setPrice(rstB.getString("Price"));
                teaREIN.setType(rstB.getString("Type"));
                teaREIN.setStar(rstB.getFloat("Star"));
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
        int count=0;
        Connection con=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pswd);
            pstA=con.prepareStatement("SELECT * FROM teacher");
            ResultSet rstA=pstA.executeQuery();
            while(rstA.next()&&count<8){
                pstB=con.prepareStatement("SELECT * FROM tearein WHERE ID=?");
                pstB.setInt(1,rstA.getInt("ID"));
                ResultSet rstB=pstB.executeQuery();
                while(rstB.next()&&count<8){
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
                        count++;
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
//    无身份限制加好友加强版
    public int MakeFriendPlus(int UserID,int FollowerID){
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
            pstA.setInt(1,UserID);
            ResultSet rstA=pstA.executeQuery();
            if(rstA.first()){
                String rstAlist=rstA.getString("FSIDList");
                String Oldfriendlist[]=bss.StringIntoArray(rstAlist);
                   for(int i=0;i<Oldfriendlist.length;i++){
                       System.out.println(Oldfriendlist[i]);
                       if(Oldfriendlist[i].equals(String.valueOf(FollowerID))){
                           return 0;//之前已关注
                       }
               }
                rstAlist=rstAlist+", "+String.valueOf(FollowerID);
                pstAT=con.prepareStatement("UPDATE friendrelationship SET FSIDList=? WHERE ID=?");
                pstAT.setString(1,rstAlist);
                pstAT.setInt(2,UserID);
                pstAT.executeUpdate();
                return 1;//此次成功关注
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
       return 2;
    }
    //学生关注老师功能
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
    public int KillFriends(int TeaID,int StuID){
        Connection con=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        BasicServe bss=new BasicServe();
        if(TeaID==2000){
            return 0;//基本用户不能删除
        }
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
        return 1;//成功删除
    }
    public List<Message> MesageShow(int OutID,int RecID,int UserID){
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
            if((rstB.first())||(rstC.first())) {
                pstA = con.prepareStatement("SELECT * FROM message WHERE (OutID=? AND RecID=?)OR(OutID=? AND RecID=?)");
                pstA.setInt(1, OutID);
                pstA.setInt(2, RecID);
                pstA.setInt(3, RecID);
                pstA.setInt(4, OutID);
                ResultSet rstA = pstA.executeQuery();
                while (rstA.next()) {
                    Message message = new Message();
                    message.setMessageID(rstA.getInt("ID"));
                    message.setMessagecol(rstA.getString("Messagecol"));
                    message.setOutID(rstA.getInt("OutID"));
                    message.setRecID(rstA.getInt("RecID"));
                    message.setRON(rstA.getString("RON"));
                    listofmessage.add(message);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return listofmessage;
    }
    public Message SingleMessageshowPlus(int MessageID,int IDnow,int WantOutID){
        Message message=new Message();
        Connection connection=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,pswd);
            pstA=connection.prepareStatement("SELECT * FROM message WHERE ID=?");
            pstA.setInt(1,MessageID);
            ResultSet rstA=pstA.executeQuery();
            if(rstA.first()){
                if(rstA.getInt("RecID")!=IDnow){
                    pstB=connection.prepareStatement("UPDATE message SET RON=? WHERE ID=?");
                    pstB.setString(1,"未读");
                    pstB.setInt(2,MessageID);
                    pstB.executeUpdate();
                    message.setMessageID(rstA.getInt("ID"));
                    message.setOutID(rstA.getInt("OutID"));
                    message.setRecID(rstA.getInt("RecID"));
                    message.setMessagecol(rstA.getString("Messagecol"));
                    message.setRON("未读");
                }else if(rstA.getInt("RecID")==IDnow){
                    pstB=connection.prepareStatement("UPDATE message SET RON=? WHERE ID=?");
                    pstB.setString(1,"已读");
                    pstB.setInt(2,MessageID);
                    pstB.executeUpdate();
                    message.setMessageID(rstA.getInt("ID"));
                    message.setOutID(rstA.getInt("OutID"));
                    message.setRecID(rstA.getInt("RecID"));
                    message.setMessagecol(rstA.getString("Messagecol"));
                    message.setRON("已读");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return message;
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
            pstA=con.prepareStatement("SELECT * FROM tearein ORDER BY Star DESC");
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
//    学生更改昵称和密码功能
    public void StudentUpdate(int ID,String NickName,String PassWord){
        Connection connection=null;
        PreparedStatement pstA=null;
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,pswd);
            pstA=connection.prepareStatement("UPDATE student SET NickName=?,PassWord=?WHERE ID=?");
            pstA.setString(1,NickName);
            pstA.setString(2,PassWord);
            pstA.setInt(3,ID);
            pstA.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
//    教师更改昵称密码功能
    public void TeacherUpdate(int TeaID,String NickName,String PassWord){
        Connection connection=null;
        PreparedStatement pstA=null;
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,pswd);
            pstA=connection.prepareStatement("UPDATE teacher SET NickName=?,PassWord=?WHERE ID=?");
            pstA.setString(1,NickName);
            pstA.setString(2,PassWord);
            pstA.setInt(3,TeaID);
            pstA.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
    public void TeaEditPersionalIntroduction(String PersionalIntroduction,int TeaID){
        Connection connection=null;
        PreparedStatement pstA=null;
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,username,pswd);
            pstA=connection.prepareStatement("UPDATE tearein SET PersionalIntroduction=? WHERE ID=?");
            pstA.setString(1,PersionalIntroduction);
            pstA.setInt(2,TeaID);
            pstA.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
//    学生更改个人信息push账号到下一界面，保存账户
    public void PushUserID(int UserID){

    }
//    教师视角，关注我的
    public List<Student> Followerlist(int TeaID){
        List<Student> listofstudent=new ArrayList<Student>();
        Connection connection=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        BasicServe bss=new BasicServe();
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,pswd);
            pstA=connection.prepareStatement("SELECT * FROM friendrelationship");
            ResultSet rstA=pstA.executeQuery();
            while(rstA.next()){
                String la[]=bss.StringIntoArray(rstA.getString("FSIDList"));
                int ID=rstA.getInt("ID");
                for(int i=0;i<la.length;i++){
                    if(String.valueOf(TeaID).equals(la[i])){
                        pstB=connection.prepareStatement("SELECT * FROM student WHERE ID=?");
                        pstB.setInt(1,ID);
                        ResultSet rstB=pstB.executeQuery();
                        if(rstB.first()){
                            Student student=new Student();
                            student.setID(rstB.getInt("ID"));
                            student.setNickName(rstB.getString("NickName"));
                            student.setPassword(rstB.getString("PassWord"));
                            listofstudent.add(student);
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
        return listofstudent;
    }
//观察者观察学生个人界面
    public StuREIN SingleStu(int TeaID,int StuID){
        StuREIN stuREIN=new StuREIN();
        Connection connection=null;
        PreparedStatement pstA=null;
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,pswd);
            pstA=connection.prepareStatement("SELECT * FROM sturein WHERE ID=?");
            pstA.setInt(1,StuID);
            ResultSet rstA=pstA.executeQuery();
            if(rstA.first()){
                stuREIN.setID(rstA.getInt("ID"));
                stuREIN.setSex(rstA.getString("Sex"));
                stuREIN.setSexWanted(rstA.getString("SexWanted"));
                stuREIN.setTime(rstA.getString("Time"));
                stuREIN.setSubject(rstA.getString("Subject"));
                stuREIN.setGrade(rstA.getString("Grade"));
                stuREIN.setEmail(rstA.getString("Email"));
                stuREIN.setAddressAccess(rstA.getString("AddressAccess"));
                stuREIN.setPrice(rstA.getString("Price"));
                stuREIN.setDate(rstA.getString("Date"));
                stuREIN.setType(rstA.getString("Type"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return stuREIN;

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
                pstA=con.prepareStatement("INSERT INTO message (Messagecol, OutID, RecID, RON) VALUES (?,?,?,?)");
                pstA.setString(1,mess);
                pstA.setInt(2,OutID);
                pstA.setInt(3,RecID);
                pstA.setString(4,"未读");
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
//查询哪些用户给当前用户发过消息，返回发消息User列表
    public List<User> GetListofMessageUser(int RecID){
        List<User>userList=new ArrayList<User>();
        List<Integer> list = new ArrayList<Integer>();
        Connection connection=null;
        PreparedStatement pstA=null;
        PreparedStatement pstB=null;
        PreparedStatement pstC=null;
        PreparedStatement pstD=null;
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,pswd);
            pstA=connection.prepareStatement("SELECT * FROM message WHERE RecID=?");
            pstA.setInt(1,RecID);
            ResultSet rstA=pstA.executeQuery();
            while(rstA.next()){
                int flag=1;//不相同
                for(int i=0;i<list.size();i++){
                    if(list.get(i)==rstA.getInt("OutID")) {
                        flag = 0;
                    }
                }
                if(flag==1){
                    list.add(rstA.getInt("OutID"));
                }
            }
            for(int i=0;i<list.size();i++){
                pstB=connection.prepareStatement("SELECT * FROM student WHERE ID=?");
                pstC=connection.prepareStatement("SELECT * FROM teacher WHERE ID=?");
                pstB.setInt(1,list.get(i));
                pstC.setInt(1,list.get(i));
                ResultSet rstB=pstB.executeQuery();
                ResultSet rstC=pstC.executeQuery();
                User user=new User();
                pstD=connection.prepareStatement("SELECT * FROM message WHERE (RecID=? AND OutID=?) OR(RecID=? AND OutID=?)");
                pstD.setInt(1,RecID);
                pstD.setInt(2,list.get(i));
                pstD.setInt(3,list.get(i));
                pstD.setInt(4,RecID);
                ResultSet rstD=pstD.executeQuery();
                int flagg=0;
                while(rstD.next()){
                    if(rstD.getString("RON").equals("未读")){
                        flagg=1;
                    }
                }
                if(flagg==0){
                    user.setRON("已读");
                }else{
                    user.setRON("未读");
                }
                if(rstB.first()&&!rstC.first()){

                    user.setUserID(rstB.getInt("ID"));
                    user.setNickName(rstB.getString("NickName"));
                    user.setUserType("学生");
                    userList.add(user);
                }else if(!rstB.first()&&rstC.first()){

                    user.setUserID(rstC.getInt("ID"));
                    user.setNickName(rstC.getString("NickName"));
                    user.setUserType("教师");
                    userList.add(user);
                }
                /////
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }

        return userList;
    }
    //    学生添加评价
    public int StuAddEvaluationToTea(StuEvaluationtoTea stuEvaluationtoTea,String EvaluationPassword){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        PreparedStatement preparedStatement1=null;
        PreparedStatement pstA=null;
        try {
            Class.forName(driver);
//            pstB=con.prepareStatement ("INSERT INTO student VALUES(?,?,?)");
//            pstB.setInt (1,student.getID());
//            pstB.setString(2,student.getNickName());
//            pstB.setString(3,student.getPassword());
            connection=DriverManager.getConnection(url,username,pswd);
            preparedStatement1=connection.prepareStatement("SELECT * FROM tearein WHERE ID=?");
            preparedStatement1.setInt(1,stuEvaluationtoTea.getEvaluatedID());
            ResultSet rstA=preparedStatement1.executeQuery();
            if(rstA.first()){
                float Starnow=rstA.getFloat("Star");
                System.out.println(Starnow);
                if(rstA.getString("EvaluationPassword").equals(EvaluationPassword)){
                    preparedStatement=connection.prepareStatement("INSERT INTO evaluation VALUES(?,?,?,?,?)");
                    preparedStatement.setInt(1,0);
                    preparedStatement.setInt(2,stuEvaluationtoTea.getEvaluatorID());
                    preparedStatement.setInt(3,stuEvaluationtoTea.getEvaluatedID());
                    preparedStatement.setString(4,stuEvaluationtoTea.getEvaluateContent());
                    preparedStatement.setInt(5,stuEvaluationtoTea.getStar());
                    preparedStatement.executeUpdate();
                    float finalStar=(Starnow+stuEvaluationtoTea.getStar())/2;
                    pstA=connection.prepareStatement("UPDATE tearein SET Star=? WHERE ID=?");
                    pstA.setFloat(1,finalStar);
                    pstA.setInt(2,stuEvaluationtoTea.getEvaluatedID());
                    pstA.executeUpdate();
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
        }
        return 0;
    }

//    空跳转，传递信息
    public void Jump(int OutID,int RecID){

    }
    public static void main(String[] args) {
        Dao dao=new Dao();
        List<User> listuser=dao.GetListofMessageUser(1001);
        for(int i=0;i<listuser.size();i++){
            System.out.println(listuser.get(i).getUserID());
            System.out.println(listuser.get(i).getNickName());
            System.out.println(listuser.get(i).getUserType());
            System.out.println(listuser.get(i).getRON());
        }

//        dao.MessageInsert(1001,2000,"jfhsuifru");
//        Dao dao=new Dao();
//        dao.MessageInsert(1001,2000,"呵呵");
//        TeaListAndOneStu teaListAndOneStu=new TeaListAndOneStu();
//        List<TeaREIN> listoftea=new ArrayList<TeaREIN>();
//        Dao dao=new Dao();
//        List<Message> messageList=new ArrayList<Message>();
//        messageList=dao.MesageShow(1001,2000);
//        for(int i=0;i<messageList.size();i++){
//            System.out.println(messageList.get(i).getMessageID());
//            System.out.println(messageList.get(i).getMessagecol());
//            System.out.println(messageList.get(i).getOutID());
//            System.out.println(messageList.get(i).getRecID());
//            System.out.println(messageList.get(i).getRON());
//        }
//        Message message=dao.SingleMessageshowPlus(100);
//        System.out.println(message.getMessageID()+" "+message.getRON()+" "+message.getOutID()+" "+message.getRecID()+" "+message.getMessagecol());
//        List<Student> studentList=dao.Followerlist(2001);
//        if (studentList.size()==0){
//            System.out.println("kong1");
//        }
//        for(int i=0;i<studentList.size();i++){
//            System.out.println(studentList.get(i).getID());
//            System.out.println(studentList.get(i).getNickName());
//            System.out.println(studentList.get(i).getPassword());
//        }
//        Teacher teacher=new Teacher();
////        teacher.setID(1031);
//        teacher.setNickName("2423");
//        teacher.setPassword("1111");
//        TeaREIN teaREIN=new TeaREIN();
////        teaREIN.setID(1031);
//        teaREIN.setSex("21");
//        teaREIN.setEducation("gfdgfd");
//        teaREIN.setTime("43534");
//        teaREIN.setPersionalIntroduction("124234");
//        teaREIN.setType("1");
//        teaREIN.setPrice("124234");
//        teaREIN.setEmail("43534");
//        teaREIN.setDate("32435");
//        teaREIN.setAddressAccess("3432");
//        teaREIN.setSubject("4234");
//        teaREIN.setEvaluationPassword("423423");
//        teaREIN.setGrade("sfsdfsd");
//        dao.TeaInsert(teacher,teaREIN);
//        int flag=dao.MakeFriendPlus(1047,2022);
//        System.out.println(flag);
//        String Edit=new String();
//        Edit="本人感觉良好本人感觉良好本人感觉良好本人感觉良好本人感觉良好本人感觉良好本人感觉良好本人感觉良好本人感觉良好本人感觉良好本人感觉良好本人感觉良好本人感觉良好本人感觉良好本人感觉良好本人感觉良好本人感觉";
//        //不能超过一百个字
//        dao.TeaEditPersionalIntroduction(Edit,2000);
//        dao.TeacherUpdate(2000,"测试","1111");
//        String ww=dao.EvaluationPasswordShow(2001);

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
