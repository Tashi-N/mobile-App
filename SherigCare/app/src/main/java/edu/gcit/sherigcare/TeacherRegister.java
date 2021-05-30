package edu.gcit.sherigcare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TeacherRegister extends AppCompatActivity {

    private EditText temail,tpassword, tconfrimpasword,tuserid,tsubject,tclass;
    private Button tsignup;
    private ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_register);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));
        temail=findViewById(R.id.teacherrEmail);
        tuserid=findViewById(R.id.teacherrId);
        tpassword=findViewById(R.id.teacherrPword);
        tsubject=findViewById(R.id.teachersub);
        tclass=findViewById(R.id.teacherclass);
        tconfrimpasword=findViewById(R.id.teacherrCPword);
        tsignup=findViewById(R.id.teacherregbtn);

        firebaseAuth = FirebaseAuth.getInstance();
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Teacher");
        progressDialog = new ProgressDialog(TeacherRegister.this);

        tsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCrededentials();
            }
        });
    }

    private void checkCrededentials() {
        String email = temail.getText().toString();
        String password = tpassword.getText().toString();
        String cpassword=tconfrimpasword.getText().toString();
        String teacherid = tuserid.getText().toString();
        String subject=tsubject.getText().toString();
        String Class=tclass.getText().toString();
       if (email.isEmpty() || !email.contains("@")) {
            temail.setError( "email is not valid");
            temail.requestFocus();
        }


        else if (password.isEmpty() || password.length() < 6) {
            tpassword.setError("Password is not valid");
            tpassword.requestFocus();
        }
       else if(!password.equals(cpassword)) {
           tconfrimpasword.setError("Different password");
           tconfrimpasword.requestFocus();
       }

        else if (teacherid.isEmpty() || teacherid.length() != 8) {
            tuserid.setError("invalid number");
            tuserid.requestFocus();
        }
        else{
            progressDialog.setTitle("Signing Up");
            progressDialog.setMessage("Please wait while Signing Up");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        TeacherHelperClass helperClass = new TeacherHelperClass(email, password,teacherid,subject,Class);
                        reference.child(teacherid).setValue(helperClass);

                        Toast.makeText(TeacherRegister.this, "successfully registered", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(TeacherRegister.this,AdminDashBoard.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(TeacherRegister.this, " register fail", Toast.LENGTH_LONG).show();
                    }


                    progressDialog.dismiss();
                }
            });

        }
    }

}
