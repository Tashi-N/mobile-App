package edu.gcit.sherigcare;

public class hleperClass {
    String Email, Passowrd, CID,ChildName,studentID;

    public hleperClass(){

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


    public String getCID() {
        return CID;
    }

    public void setCID(String cid) {
        this.CID= cid;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getChildName() {
        return ChildName;
    }

    public void setChildName(String childName) {
        ChildName = childName;
    }

    public hleperClass(String email, String password, String cid, String child, String stdid){
        Email = email;
        Passowrd = password;
        ChildName=child;
        studentID=stdid;
        this.CID =cid;
    }
}