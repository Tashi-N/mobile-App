package edu.gcit.sherigcare;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import edu.gcit.sherigcare.ui.slideshow.ForgotPassword;

public class Parent extends AppCompatActivity {
    EditText emailp,passwordp;
    Button loginp;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        firebaseAuth= FirebaseAuth.getInstance();
        user= firebaseAuth.getCurrentUser();
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));
        emailp=findViewById(R.id.parentemail);
        passwordp=findViewById(R.id.parentPassword);
        loginp=findViewById(R.id.parentlog);
        loginp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                log();
            }
        });
    }
    private void log(){
        String mainActivityEmail=emailp.getText().toString();
        String mainActivityPassword=passwordp.getText().toString();
        if (TextUtils.isEmpty(mainActivityEmail)) {
            emailp.setError("enter your email");
            return;
        }
        else if(TextUtils.isEmpty(mainActivityPassword)) {
            passwordp.setError("enter your password");
            return;
        }
        else{
            String email = emailp.getText().toString().trim();
            String password = passwordp.getText().toString().trim();
            int count=emailp.length();
            if(count==11) {
                ProgressDialog progressDialog;
                DatabaseReference Reference = FirebaseDatabase.getInstance().getReference("Parent");
                Query checkUser = Reference.orderByChild("cid").equalTo(email);
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            emailp.setError(null);
                            emailp.setEnabled(false);
                            String passwordDB = snapshot.child(email).child("passowrd").getValue(String.class);
                            if(passwordDB.equals(password)){
                                passwordp.setError(null);
                                passwordp.setEnabled(false);
                                startActivity(new Intent(Parent.this, ParentHome.class));
                                finish();
                            }
                            else{
                                passwordp.setError("Wrong password");
                                passwordp.requestFocus();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"No such Account",Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            else if (count==4){
                ProgressDialog progressDialog;
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("admin");
                Query checkUser = reference.orderByChild("schoolcode").equalTo(email);
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            emailp.setError(null);
                            emailp.setEnabled(false);
                            String passwordDB;
                             passwordDB = snapshot.child(email).child("passowrd").getValue(String.class);
                            if(passwordDB.equals(password)){
                                passwordp.setError(null);
                                passwordp.setEnabled(false);
                                startActivity(new Intent(getApplicationContext(),AdminDashBoard.class));
                                finish();
                            }
                            else{
                                passwordp.setError("Wrong password");
                                passwordp.requestFocus();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"No  Account",Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            else{
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Teacher");
                Query checkUser = reference.orderByChild("teacherid").equalTo(email);
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            emailp.setError(null);
                            emailp.setEnabled(false);
                            String passwordDB = snapshot.child(email).child("passowrd").getValue(String.class);
                            if(passwordDB.equals(password)){
                                passwordp.setError(null);
                                passwordp.setEnabled(false);
                                startActivity(new Intent(getApplicationContext(),TeacherHome.class));
                                finish();
                            }
                            else{
                                passwordp.setError("Wrong password");
                                passwordp.requestFocus();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"No such Account",Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

        }
    }


    public void mainfpWord(View view) {
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }
    private Boolean isVallidedEmail(CharSequence target){

        return(!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

//    public void click(View view) {
//        Intent intent =new Intent(this,Adminregister.class);
//        startActivity(intent);
//    }
//    public void pop(View view) {
//        Toast.makeText(getApplicationContext(),"user CID if your are parents and Teacher ID for teachers",Toast.LENGTH_SHORT).show();
//    }
}