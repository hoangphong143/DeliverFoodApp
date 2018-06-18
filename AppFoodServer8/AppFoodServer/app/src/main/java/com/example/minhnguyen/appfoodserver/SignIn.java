package com.example.minhnguyen.appfoodserver;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.minhnguyen.appfoodserver.Common.Common;
import com.example.minhnguyen.appfoodserver.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import info.hoang8f.widget.FButton;

public class SignIn extends AppCompatActivity {
    private Button btnSignIn;
    private EditText edtPhone,edtPass;

    FirebaseDatabase db;
    DatabaseReference users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btnSignIn = findViewById(R.id.btnOk);
        edtPhone = findViewById(R.id.edtPhone);
        edtPass = findViewById(R.id.edtPassword);

        //inIt Firebase
        db = FirebaseDatabase.getInstance();
        users = db.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInUser(edtPhone.getText().toString(),edtPass.getText().toString());
            }
        });

    }

    private void signInUser(String phone, String pass) {
        final ProgressDialog dialog = new ProgressDialog(SignIn.this);
        dialog.setMessage("Xin vui lòng đợi...");
        dialog.show();

        final String localPhone = phone;
        final String localPassWord = pass;

        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(localPhone).exists()){
                    dialog.dismiss();
                    User user = dataSnapshot.child(localPhone).getValue(User.class);
                    user.setPhone(localPhone);
                    if (Boolean.parseBoolean(user.getIsStaff())){
                        if (user.getPassword().equals(localPassWord)){
                            Intent login = new Intent(SignIn.this,Home.class);
                            Common.currentUser = user;
                            startActivity(login);
                            finish();


                        }else {
                            Toast.makeText(SignIn.this, "Sai mật khẩu !", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(SignIn.this, "Yêu cầu sử dụng tài khoản nhân viên", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    dialog.dismiss();
                    Toast.makeText(SignIn.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
