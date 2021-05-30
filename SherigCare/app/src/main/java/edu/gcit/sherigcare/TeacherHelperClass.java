package edu.gcit.sherigcare;

public class TeacherHelperClass {
    String Email, Passowrd, Teacherid,Subject,TeacherClass;

    public TeacherHelperClass(){

    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassowrd() {
        return Passowrd;
    }

    public void setPassowrd(String passowrd) {
        Passowrd = passowrd;
    }

    public String getTeacherid() {
        return Teacherid;
    }

    public void setTeacherid(String teacherid) {
        Teacherid = teacherid;
    }


    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getTeacherClass() {
        return TeacherClass;
    }

    public void setTeacherClass(String teacherClass) {
        TeacherClass = teacherClass;
    }

    public TeacherHelperClass(String email, String password, String teacherid,String subject,String Class){
        Email = email;
        Passowrd = password;
        Teacherid = teacherid;
        Subject=subject;
        TeacherClass=Class;

    }
}
