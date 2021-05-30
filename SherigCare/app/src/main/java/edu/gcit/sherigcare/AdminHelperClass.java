package edu.gcit.sherigcare;

public class AdminHelperClass {
    String Email, Passowrd,Schoolcode;
  public AdminHelperClass(){
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

    public String getSchoolcode() {
        return Schoolcode;
    }

    public void setSchoolcode(String schoolcode) {
        Schoolcode = schoolcode;
    }

    public AdminHelperClass(String schoolcode, String email, String password){
      this.Schoolcode=schoolcode;
      this.Email=email;
      this.Passowrd=password;
  }
}
