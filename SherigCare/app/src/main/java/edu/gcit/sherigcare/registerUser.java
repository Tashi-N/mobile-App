package edu.gcit.sherigcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registerUser extends AppCompatActivity {
    private EditText email,password, confrimpasword,cid,child,stdID;
    private Button signup;
    private ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));
        firebaseAuth=FirebaseAuth.getInstance();
        cid=findViewById(R.id.edituId);
        email=findViewById(R.id.edituEmail);
        password=findViewById(R.id.edituPword);
        child=findViewById(R.id.editstd);
        stdID=findViewById(R.id.editid);
        confrimpasword=findViewById(R.id.edituCPword);
        signup=findViewById(R.id.regbtn);
        progressDialog= new ProgressDialog(this);
        signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             rootNode= FirebaseDatabase.getInstance();
             reference=rootNode.getReference("Parent");
             String Email=email.getText().toString();
             String CID=cid.getText().toString();
            String Password=password.getText().toString();
            String ChildName=child.getText().toString();
            String studentID=stdID.getText().toString();
            Register();
         }
       });
    }
    private void Register(){
        String edutuID = cid.getText().toString();
        String editstd=child.getText().toString();
        String stdid=stdID.getText().toString();
        String edituEmail=email.getText().toString();
        String mainActivity2registerPword=password.getText().toString();
        String mainActivity2registerConfirmPword=confrimpasword.getText().toString();

        if (TextUtils.isEmpty(edituEmail)) {
            email.setError("enter your email");
            return;
        }
        else if(TextUtils.isEmpty(mainActivity2registerPword)) {
            password.setError("enter your password");
            return;
        }
        else if (mainActivity2registerPword.length()<6){
            password.setError("password should not be less than 6");
        }
        else if(TextUtils.isEmpty(mainActivity2registerConfirmPword)) {
            confrimpasword.setError("confrim your password");
            return;
        }
        else if(!mainActivity2registerPword.equals(mainActivity2registerConfirmPword)) {
            confrimpasword.setError("Different password");
            return;
        }
//        else if(mainActivity2registerPword.length()<4) {
//            password.setError("length should be >4");
//            return;
//        }
        else if (TextUtils.isEmpty(edutuID) || cid.length() != 11) {
            cid.setError("invalid number");
            cid.requestFocus();
        }
        else if(!isVallidedEmail(edituEmail)) {
            email.setError("invalid email");
            return;
        }
        progressDialog.setMessage("please wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.createUserWithEmailAndPassword(edituEmail, mainActivity2registerPword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    hleperClass hleper = new hleperClass(edituEmail,mainActivity2registerPword,edutuID,editstd,stdid);
                    reference.child(edutuID).setValue(hleper);

                    Toast.makeText(registerUser.this, "successfully registered", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(registerUser.this,AdminDashBoard.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(registerUser.this, " register fail", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
                }
            });
    }
    private Boolean isVallidedEmail(CharSequence target){

        return(!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
//    private void showError(EditText input,String s){
//        input.setError(s);
//        input.requestFocus();
//
//
//
//    }
}