package com.example.board2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class _2_1write_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._2_1activity_writepage);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        ImageButton backbtn = (ImageButton) findViewById(R.id.write_back_btn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(_2_1write_page.this, _2_0homepage.class);
                _2_1write_page.this.startActivity(registerintent);
            }
        });
        ImageButton writesubmitbtn = (ImageButton) findViewById(R.id.write_submit_btn);
        writesubmitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText write_title_edit = (EditText) findViewById(R.id.write_title_edit);
                EditText write_content_edit = (EditText) findViewById(R.id.write_content_edit);

                final String writetitle = write_title_edit.getText().toString();
                final String writecontent = write_content_edit.getText().toString();


                new constructor_stringrequest(
                        "http://tidahk.dothome.co.kr/write.php",
                        "POST",
                        new constructor_stringrequest.i_Listener() {
                            @Override
                            public void i_onResponse(String i_response) {

                                AlertDialog.Builder builder = new AlertDialog.Builder(_2_1write_page.this);
                                builder.setTitle("글쓰기 성공");
                                builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        System.out.println("버튼클릭");
                                    }
                                });
                                builder.setPositiveButton("나가기", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent registerintent = new Intent(_2_1write_page.this, _2_0homepage.class);
                                        _2_1write_page.this.startActivity(registerintent);
                                    }
                                });
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();


                            }
                        },
                        new constructor_stringrequest.i_ErrorListener(){
                            @Override
                            public void i_onResponse(VolleyError i_error) {
                                System.out.println(i_error + "통신실패");

                            }
                        }, new constructor_stringrequest.i_getParams(){
                    @Override
                    public Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("writetitle_php", writetitle);
                        params.put("writecontent_php", writecontent);
                        params.put("writer", _1_0first_page.json1);
                        return params;

                    }

                }).standard()  ;














            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent registerintent = new Intent(_2_1write_page.this, _2_0homepage.class);
        _2_1write_page.this.startActivity(registerintent);
        super.onBackPressed();
    }

/*
    public void write_method() {
        EditText write_title_edit = (EditText) findViewById(R.id.write_title_edit);
        EditText write_content_edit = (EditText) findViewById(R.id.write_content_edit);

        final String writetitle = write_title_edit.getText().toString();
        final String writecontent = write_content_edit.getText().toString();

        String url = "http://tidahk.dothome.co.kr/write.php";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);

                        AlertDialog.Builder builder = new AlertDialog.Builder(_2_1write_page.this);
                        builder.setTitle("글쓰기 성공");
                        builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("버튼클릭");
                            }
                        });
                        builder.setPositiveButton("나가기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent registerintent = new Intent(_2_1write_page.this, _2_0homepage.class);
                                _2_1write_page.this.startActivity(registerintent);
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }
                ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error + "통신실패");
                    }
                }
        ) {
            @Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("writetitle_php", writetitle);
                params.put("writecontent_php", writecontent);
                params.put("writer", _1_0first_page.json1);
                return params;
            }
        };

        staticmethod.requestQueue.add(request);


    }

*/




}