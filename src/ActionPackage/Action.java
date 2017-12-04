package ActionPackage;

import localpackage.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Action {
    private String mess;
    private int TeaID;
    private int StuID;
    private int OutID;
    private int RecID;
    private int UserID;
    private int FollowerID;
    private BSTeacher bsTeacher=new BSTeacher();
    private Dao dao =new Dao();
    private Student student =new Student();
    private Student studemo=new Student();
    private Teacher teacher =new Teacher();
    private Teacher teademo=new Teacher();
    private TeaREIN teaREIN=new TeaREIN();
    private TeaREIN tridemo=new TeaREIN();
    private StuREIN stuREIN=new StuREIN();
    private StuREIN sridemo=new StuREIN();
    private List<TeaREIN> listoftri=new ArrayList<TeaREIN>();
    private List<StuREIN> listofsti=new ArrayList<StuREIN>();
    private List<BSTeacher> listofbstea=new ArrayList<BSTeacher>();
    private TeaListAndOneStu teaListAndOneStu=new TeaListAndOneStu();
    private StuListAndOneTea stuListAndOneTea=new StuListAndOneTea();
    private List<Teacher> listofteacher=new ArrayList<Teacher>();
    private Message message=new Message();
    private List<Message> listofmessage=new ArrayList<Message>();
    private List<StuEvaluationtoTea> stuEvaluationtoTeaList=new ArrayList<StuEvaluationtoTea>();
    private String EvaluationPassword;
    private String PassWord;
    private String NickName;
    private String TeaPersionalIntroduction;
    private List<Student> listofstudent=new ArrayList<Student>();
    private int messageID;
    private List<User> listofuser=new ArrayList<User>();
    private int IDnow;
    private int SuperOutID;
    private int SuperRecID;
    private int WantOutID;




    public static void main(String[] args) {
        Action action=new Action();
        action.StuID=1031;
        String str=action.MatchForStu();
        for(int i=0;i<action.listoftri.size();i++){
            System.out.println(action.listoftri.get(i).getID()+" "+
                    action.listoftri.get(i).getSex()+" "+
                    action.listoftri.get(i).getEducation());
        }
    }
    public String Jump(){
        dao.Jump(OutID,RecID);
        return "JUMP";
    }
    public String GetListofMessageUser(){
        listofuser=dao.GetListofMessageUser(RecID);
        if(listofuser.size()==0){
            return "NOMESSAGEATALL";
        }else{
            return "MESSAGESHOW";
        }
    }
    public String SingleMessageShowPlus(){
        message=dao.SingleMessageshowPlus(messageID,IDnow,WantOutID);
        return "SINGLEMESSAGESHOWPLUS";
    }
    public String ShowMyFollowers(){
        listofstudent=dao.Followerlist(TeaID);
        if(listofstudent.size()==0){
            return "NOONEFOLLOWYOU";
        }else{
            return "LISTTOFOLLOWYOU";
        }

    }
    public String PushUserIDofTea(){
        dao.PushUserID(UserID);
        return "1";
    }
    public String PushUserID(){
        dao.PushUserID(UserID);
        return "1";
    }
    public String MakeFriendPlus(){
        int flag=dao.MakeFriendPlus(UserID,FollowerID);
        if(flag==0){
            return "0";
        }else{
            return "1";
        }
    }
    public String TeaEditePersionalIntroduction(){
        dao.TeaEditPersionalIntroduction(TeaPersionalIntroduction,TeaID);
        return "TEAEDITPERSIONALINTRODUCTION";
    }
    public String TeacherUpdate(){
        dao.TeacherUpdate(TeaID,NickName,PassWord);
        return "TEACHERUPDATE";
    }
    public String StudentUpdate(){
        dao.StudentUpdate(StuID,NickName,PassWord);
        return "STUDENTUPDATE";
    }
    public String UpdateEvaluationPassWord(){
        dao.UpdateEvaluationPassword(TeaID,EvaluationPassword);
        return "SUCCESSUPDATEEVALUATIONPASSWPORD";
    }
    public String EvaluationPasswordShow(){
        EvaluationPassword=dao.EvaluationPasswordShow(TeaID);
        if(EvaluationPassword.equals("NULL")){
            return "NULLEVALUATIONPASSWORD";
        }else{
            return "EVALUATIONPASSWORDSHOW";
        }
    }
    public String EvaluationShow(){
        stuEvaluationtoTeaList=dao.EvaluationShow(TeaID);
        if(stuEvaluationtoTeaList==null){
            return "NOEVALUATION";
        }else{
            return "EVALUATIONSHOW";
        }

    }
    public String MatchforTeaPlus(){
        stuListAndOneTea=dao.MatchForTeaPlus(TeaID);
        if(stuListAndOneTea.getListofStu().size()==0){
            return "NOSTUFORTEA";
        }else{
            return "LISTSTUFORTEA";
        }
    }
    public String MatchforStuPlus(){
        teaListAndOneStu=dao.MatchForStuPlus(StuID);
        if(teaListAndOneStu.getTeaREINS().size()==0){
            return "NOTEAFORSTU";
        }else{
            return "LISTTEAFORSTU";
        }
    }
    public String MessageInsert(){
        int flag=dao.MessageInsert(OutID,RecID,mess);
        if(flag==0){
            return "REJECTEMPTYMESSAGE";
        }else{
            return "INSERTMESSAGE";
        }
    }
    public String MessageShow(){
        listofmessage=dao.MesageShow(OutID,RecID,UserID);
        if(listofmessage.size()==0){
            return "NOMESSAGE";
        }else{
            return "THISISMESSAGE";
        }
    }
    public String FriendKill(){
        int flag=dao.KillFriends(TeaID,StuID);
        if(flag==0){
            return "FAILTOKILLFRIEND";
        }else{
            return "KILLFRIEND";
        }

    }
    public String Friendlist(){
        listofteacher=dao.Friendlist(StuID);
        if(listofteacher==null){
            return "NOFRIEND";
        }else{
            return "EXSITFRIEND";
        }
    }
    public String MakeFriends(){
        int flag=dao.MakeFriend(StuID,TeaID);
        if(flag==1){
            return "SUCCESSMAKEFRIEND";
        }else{
            return "FAILEDMAKEFRIEND";
        }
    }
    public String AllTheTea(){
        listofbstea=dao.AllTheTea();
        return "ALLTHETEACHER";

    }
    public String SingleStu(){
        stuREIN=dao.SingleStu(TeaID,StuID);
        return "SINGLESTU";
    }
    public String SingleTea(){
        bsTeacher=dao.SingleTea(TeaID);
            listofbstea=dao.ProfileTea(bsTeacher.getTeaREIN().getSubject());
        return "SINGLETEA";

    }
    public String MatchForStu(){
        teaListAndOneStu=dao.MatchForStu(StuID);
        if(listoftri!=null){
            return "STUSUCCESSMATCH";
        }else{
            return "STUFAILEDMATCH";
        }


    }
    public String StuREINUpdate(){
        sridemo=dao.StuReInUpdate(stuREIN);
        if(sridemo!=null){
            return "STUSUCCESSREIN";
        }else{
            System.out.println(stuREIN.getID());
            System.out.println(stuREIN.getSex());
            System.out.println(stuREIN.getSexWanted());
            System.out.println(stuREIN.getGrade());
            System.out.println(stuREIN.getTime());
            System.out.println(stuREIN.getSubject());
            System.out.println(stuREIN.getEmail());
            System.out.println(stuREIN.getAddressAccess());
            return "STUFAILEDREIN";
        }
    }
    public String TeaREINUpdate(){
        tridemo=dao.TeaReInUpdate(teaREIN);
        if(tridemo!=null){
            System.out.println(tridemo.getSex());
            return "TEASUCCESSREIN";
        }else{
            return "TEAFAILEDREIN";
        }

    }
    public String TeaLog(){
        teademo=dao.TeaLog(teacher);
        listofbstea=dao.TopTea();
        if(teademo!=null){
            return "TEASUCCESSLOG";
        }else{
            return "TEAFAILEDLOG";
        }
    }
    public String TeaInsert(){
        teademo=dao.TeaInsert(teacher,teaREIN);
        if(teademo!=null){
            return "TEASUCCESSREGIST";
        }else{
            return "TEAFAILEDREGIST";
        }
    }
    public String StuInsert(){
        studemo=dao.StuInsert(student,stuREIN);
        if(studemo!=null){
            return "STUSUCCESSREGIST";
        }else{
            return "STUFAILEDREGIST";
        }
    }
    public String StuLog(){
        studemo=dao.StuLog(student);
        listofbstea=dao.TopTea();
        if(studemo!=null){
            return "STUSUCCESSLOG";
        }else{
            return "STUFAILEDLOG";
        }
    }

    public int getWantOutID() {
        return WantOutID;
    }

    public void setWantOutID(int wantOutID) {
        WantOutID = wantOutID;
    }

    public int getSuperRecID() {
        return SuperRecID;
    }

    public void setSuperRecID(int superRecID) {
        SuperRecID = superRecID;
    }

    public int getSuperOutID() {
        return SuperOutID;
    }

    public void setSuperOutID(int superOutID) {
        SuperOutID = superOutID;
    }

    public int getIDnow() {
        return IDnow;
    }

    public void setIDnow(int IDnow) {
        this.IDnow = IDnow;
    }

    public List<User> getListofuser() {
        return listofuser;
    }

    public void setListofuser(List<User> listofuser) {
        this.listofuser = listofuser;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public List<Student> getListofstudent() {
        return listofstudent;
    }

    public void setListofstudent(List<Student> listofstudent) {
        this.listofstudent = listofstudent;
    }

    public int getFollowerID() {
        return FollowerID;
    }

    public void setFollowerID(int followerID) {
        FollowerID = followerID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getTeaPersionalIntroduction() {
        return TeaPersionalIntroduction;
    }

    public void setTeaPersionalIntroduction(String teaPersionalIntroduction) {
        TeaPersionalIntroduction = teaPersionalIntroduction;
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

    public String getEvaluationPassword() {
        return EvaluationPassword;
    }

    public void setEvaluationPassword(String evaluationPassword) {
        EvaluationPassword = evaluationPassword;
    }

    public List<StuEvaluationtoTea> getStuEvaluationtoTeaList() {
        return stuEvaluationtoTeaList;
    }

    public void setStuEvaluationtoTeaList(List<StuEvaluationtoTea> stuEvaluationtoTeaList) {
        this.stuEvaluationtoTeaList = stuEvaluationtoTeaList;
    }

    public StuListAndOneTea getStuListAndOneTea() {
        return stuListAndOneTea;
    }

    public void setStuListAndOneTea(StuListAndOneTea stuListAndOneTea) {
        this.stuListAndOneTea = stuListAndOneTea;
    }

    public List<StuREIN> getListofsti() {
        return listofsti;
    }

    public void setListofsti(List<StuREIN> listofsti) {
        this.listofsti = listofsti;
    }

    public String StuReF(){
        return "1";
    }

    public String TeaReF(){
        return "1";
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public List<Message> getListofmessage() {
        return listofmessage;
    }

    public void setListofmessage(List<Message> listofmessage) {
        this.listofmessage = listofmessage;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
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

    public List<Teacher> getListofteacher() {
        return listofteacher;
    }

    public void setListofteacher(List<Teacher> listofteacher) {
        this.listofteacher = listofteacher;
    }

    public List<BSTeacher> getListofbstea() {
        return listofbstea;
    }

    public TeaListAndOneStu getTeaListAndOneStu() {
        return teaListAndOneStu;
    }

    public void setTeaListAndOneStu(TeaListAndOneStu teaListAndOneStu) {
        this.teaListAndOneStu = teaListAndOneStu;
    }

    public void setListofbstea(List<BSTeacher> listofbstea) {
        this.listofbstea = listofbstea;
    }

    public BSTeacher getBsTeacher() {
        return bsTeacher;
    }

    public void setBsTeacher(BSTeacher bsTeacher) {
        this.bsTeacher = bsTeacher;
    }

    public int getTeaID() {
        return TeaID;
    }

    public void setTeaID(int teaID) {
        TeaID = teaID;
    }

    public List<TeaREIN> getListoftri() {
        return listoftri;
    }

    public void setListoftri(List<TeaREIN> listoftri) {
        this.listoftri = listoftri;
    }

    public int getStuID() {
        return StuID;
    }

    public void setStuID(int stuID) {
        StuID = stuID;
    }

    public StuREIN getSridemo() {
        return sridemo;
    }

    public void setSridemo(StuREIN sridemo) {
        this.sridemo = sridemo;
    }

    public StuREIN getStuREIN() {
        return stuREIN;
    }

    public void setStuREIN(StuREIN stuREIN) {
        this.stuREIN = stuREIN;
    }

    public TeaREIN getTridemo() {
        return tridemo;
    }

    public void setTridemo(TeaREIN tridemo) {
        this.tridemo = tridemo;
    }

    public TeaREIN getTeaREIN() {
        return teaREIN;
    }

    public void setTeaREIN(TeaREIN teaREIN) {
        this.teaREIN = teaREIN;
    }

    public Teacher getTeademo() {
        return teademo;
    }

    public void setTeademo(Teacher teademo) {
        this.teademo = teademo;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudemo() {
        return studemo;
    }

    public void setStudemo(Student studemo) {
        this.studemo = studemo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

}
