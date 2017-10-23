package Actionpackage;

import localpackage.LogInfoDao;
import localpackage.Stuloginfo;

public class Action {
    private LogInfoDao dao=new LogInfoDao();
    private Stuloginfo stuloginfo=new Stuloginfo();
    private Stuloginfo stu=new Stuloginfo();
    private String message=new String();
    private String password=new String();
    public String StuLog(){
        int flag=dao.StuLog(message,password);
        if(flag==0){
            return "FAILLOG";
        }else{
            return "SUCCESSLOG";
        }
    }
    public String StuRegister(){
        stu=dao.Stuinsert(stuloginfo);
       if(stu==null){
           return "FAILREGISTER";
       }else{
           return "SUCCESSREGISTER";
       }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Stuloginfo getStu() {
        return stu;
    }

    public void setStu(Stuloginfo stu) {
        this.stu = stu;
    }

    public Stuloginfo getStuloginfo() {
        return stuloginfo;
    }

    public void setStuloginfo(Stuloginfo stuloginfo) {
        this.stuloginfo = stuloginfo;
    }

    public LogInfoDao getDao() {
        return dao;
    }

    public void setDao(LogInfoDao dao) {
        this.dao = dao;
    }
}
