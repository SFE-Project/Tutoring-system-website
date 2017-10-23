package Actionpackage;

import localpackage.LogInfoDao;
import localpackage.Stuloginfo;

public class Action {
    private LogInfoDao dao=new LogInfoDao();
    private Stuloginfo stuloginfo=new Stuloginfo();
    private Stuloginfo stu=new Stuloginfo();
    private String A=new String();
    private String password;
    public String Stulog(){
        int flag=dao.Stulog(A,password);
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

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
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
