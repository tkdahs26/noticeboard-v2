package com.example.board2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class _3_2passwordcheck_page_fix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._3_2activity_passwordcheck_page_fix);



        ImageButton passwordcheck_button = (ImageButton) findViewById(R.id.passwordcheck_button_del);
            passwordcheck_button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void  onClick(View view) {
                    EditText passwordcheck_edit = (EditText) findViewById(R.id.passwordcheck_edit_del);
                    String check_edit = passwordcheck_edit.getText().toString();
                    System.out.println("first_page"+ _1_0first_page.json2);
                    System.out.println("check_edit"+check_edit);
                    if (_1_0first_page.json2.equals(check_edit)) {

                        Intent registerintent = new Intent(_3_2passwordcheck_page_fix.this, _3_3fixcontent_page.class);
                        _3_2passwordcheck_page_fix.this.startActivity(registerintent);
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(_3_2passwordcheck_page_fix.this);
                        builder.setTitle("비밀번호가 일치하지 않습니다");
                        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("버튼클릭");
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }

                }
            });





    }

    @Override
    public void onBackPressed() {
        Intent registerintent = new Intent(_3_2passwordcheck_page_fix.this, _3_0content_page.class);
        _3_2passwordcheck_page_fix.this.startActivity(registerintent);
        super.onBackPressed();
    }


}