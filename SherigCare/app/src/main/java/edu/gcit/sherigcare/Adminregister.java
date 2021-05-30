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

public class Adminregister extends AppCompatActivity {
    EditText id,emailm,passwordm;
    ProgressDialog progressDialog;
    Button resetb;
    //    String userId;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    FirebaseDatabase rootNode;
    DatabaseReference databasereference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminregister);
        firebaseAuth = FirebaseAuth.getInstance();
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));
        resetb = findViewById(R.id.mainlogin);
        id = findViewById(R.id.mainid);
        emailm = findViewById(R.id.mainemail);
        passwordm = findViewById(R.id.mainPassword);
        user = firebaseAuth.getCurrentUser();
        progressDialog = new ProgressDialog(Adminregister.this);
        firebaseAuth = FirebaseAuth.getInstance();

        resetb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                databasereference = rootNode.getReference("admin");
                String Email=emailm.getText().toString();
                String Schoolcode=id.getText().toString();
                String Password=passwordm.getText().toString();
                checkCrededentials();
            }
        });
    }
    private void checkCrededentials() {
        String schoolcode = id.getText().toString();
        String email = emailm.getText().toString();
        String password = passwordm.getText().toString();
        if (email.isEmpty() || !email.contains("@")) {
            emailm.setError("email.is not valid");
            emailm.requestFocus();
        }
        else if (password.isEmpty() || password.length() <8) {
            passwordm.setError("Password is not valid");
            passwordm.requestFocus();
        }
        else if (schoolcode.isEmpty() || schoolcode.length() != 4) {
            id.setError("invalid number");
            id.requestFocus();
        }
        else if(!isVallidedEmail(email)) {
            emailm.setError("invalid email");
            emailm.requestFocus();

        }
        else {
            progressDialog.setMessage("please wait...");
            progressDialog.show();
            progressDialog.setCanceledOnTouchOutside(false);
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        AdminHelperClass helper = new AdminHelperClass(schoolcode,email,password);
                        databasereference.child(schoolcode).setValue(helper);

                        Toast.makeText(Adminregister.this, "successfully registered", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Adminregister.this,Parent.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(Adminregister.this, " register fail", Toast.LENGTH_LONG).show();
                    }


                    progressDialog.dismiss();
                }
            });
        }
    }
    private Boolean isVallidedEmail(CharSequence target){

        return(!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

//    public void login(View view) {
//        Intent intent = new Intent(MainActivity.this, AdminDashBoard.class);
//        startActivity(intent);
//    }
}