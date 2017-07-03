package com.kwave.android.firebaseuser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kwave.android.firebaseuser.domain.User;

public class SignUpActivity extends AppCompatActivity {

    EditText editName, editEmail, editPassword;
    Button btnSignUp;
    FirebaseDatabase database;
    DatabaseReference userRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editEmail = (EditText) findViewById(R.id.editEmail);
        editName = (EditText) findViewById(R.id.editName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        database = FirebaseDatabase.getInstance();
        // root 노드인 user를 레퍼런스로 사용
        userRef = database.getReference("user");

    }
    // Sign Up 버튼의 onClick 속성에 직접 연결
    // android:onClick="postData"
    public void postData(View view){
        String email = editEmail.getText().toString();
        String name = editName.getText().toString();
        String password = editPassword.getText().toString();

        // 정규식으로 이메일이 맞는지 체크 후


        // 패스워드 자릿 수 체크


        // 파이어베이스에 저장할 User 객체 생성
        User user = new User(name, email, password);

        // 파이어 베이스에 키를 자동으로 생성하는 방법
        String chiledKey = userRef.push().getKey();   // << hash 코드로 된 키를 레퍼런스 아래에 삽입해준다.

        userRef.child(chiledKey).setValue(user);

    }
}
