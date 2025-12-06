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
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class _1_1register_page extends AppCompatActivity {


    boolean id_check=false;

    EditText joinid_edit = (EditText) findViewById(R.id.joinid_edit);
    EditText password_edit = (EditText) findViewById(R.id.password_edit);
    EditText password2_edit = (EditText) findViewById(R.id.password2_edit);
    EditText email_edit = (EditText) findViewById(R.id.email_edit);
    final String joinid_str = joinid_edit.getText().toString();
    final String password_str = password_edit.getText().toString();
    final String password2_str = password2_edit.getText().toString();
    final String email_str = email_edit.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._1_1activity_registerclass);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }



        ImageButton backbtn = (ImageButton) findViewById(R.id.back_btn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(_1_1register_page.this, _1_0first_page.class);
                _1_1register_page.this.startActivity(registerintent);
            }
        });



        ImageButton joinbtn = (ImageButton) findViewById(R.id.join_btn);
        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {       //onclick함수를 재정의
                if (joinid_edit.getText().toString().isEmpty() || password_edit.getText().toString().isEmpty() || email_edit.getText().toString().isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(_1_1register_page.this);
                    builder.setMessage("빈칸이 있습니다");
                    builder.create();
                    builder.show();
                } else if (!password_edit.getText().toString().equals(password2_edit.getText().toString())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(_1_1register_page.this);
                    builder.setMessage("비밀번호가 맞지않습니다");
                    builder.create();
                    builder.show();
                } else if (!id_check) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(_1_1register_page.this);
                    builder.setMessage("중복확인을 눌러주세요");
                    builder.create();
                    builder.show();
                }else {//constructor_stringrequest constructor_stringrequest=
                    new constructor_stringrequest(
                            "http://tidahk.dothome.co.kr/register_php.php",
                            "POST",
                            new constructor_stringrequest.i_Listener() {
                                @Override
                                public void i_onResponse(String i_response) {

                                    AlertDialog.Builder builder = new AlertDialog.Builder(_1_1register_page.this);
                                    builder.setTitle("회원가입 성공");
                                    builder.setPositiveButton("로그인하기", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            System.out.println("버튼클릭");
                                            Intent registerintent = new Intent(_1_1register_page.this, _1_0first_page.class);
                                            _1_1register_page.this.startActivity(registerintent);
                                        }
                                    });
                                    builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            System.out.println("버튼클릭");
                                        }
                                    });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();

                                }
                            },
                            new constructor_stringrequest.i_ErrorListener(){
                                @Override
                                public void i_onResponse(VolleyError i_error) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(_1_1register_page.this);
                                    builder.setTitle("회원가입 실패");
                                    builder.setPositiveButton("뒤로가기", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            System.out.println("버튼클릭");
                                            Intent registerintent = new Intent(_1_1register_page.this, _1_0first_page.class);
                                            _1_1register_page.this.startActivity(registerintent);
                                        }
                                    });
                                    builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            System.out.println("버튼클릭");
                                        }
                                    });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                    System.out.println(i_error + "통신실패");

                                }
                            }, new constructor_stringrequest.i_getParams(){
                        @Override
                        public Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("joinid", joinid_str);
                            params.put("joinpassword", password_str);
                            params.put("joinpassword2", password2_str);
                            params.put("joinemail",email_str);

                            return params;

                        }

                    }) ;

                }


            }
        });




        ImageButton overlapbtn = (ImageButton) findViewById(R.id.overlap_btn);
        overlapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(joinid_edit.getText().toString().isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(_1_1register_page.this);
                    builder.setMessage("아이디를 입력해주세요");
                    builder.create();
                    builder.show();
                }
                else{
                    overlapmethod();
                }
            }
        });


        if (staticmethod.requestQueue == null) {
            staticmethod.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }





    }
    @Override
    public void onBackPressed() {
        Intent registerintent = new Intent(_1_1register_page.this, _1_0first_page.class);
        _1_1register_page.this.startActivity(registerintent);
        super.onBackPressed();
    }






}






















/*

public void send() {
    String url = "http://tidahk.dothome.co.kr/register_php.php";
    EditText joinid_edit = (EditText) findViewById(R.id.joinid_edit);
    EditText password_edit = (EditText) findViewById(R.id.password_edit);
    EditText password2_edit = (EditText) findViewById(R.id.password2_edit);
    EditText email_edit = (EditText) findViewById(R.id.email_edit);
    final String joinid_str = joinid_edit.getText().toString();
    final String password_str = password_edit.getText().toString();
    final String password2_str = password2_edit.getText().toString();
    final String email_str = email_edit.getText().toString();

    StringRequest request = new StringRequest(
            Request.Method.POST,

            url,
            new Response.Listener<String>() {
                @Override //응답성공시 행동코드 ajax done이랑 비슷
                public void onResponse(String response) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(_1_1register_page.this);
                    builder.setTitle("회원가입 성공");
                    builder.setPositiveButton("로그인하기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            System.out.println("버튼클릭");
                            Intent registerintent = new Intent(_1_1register_page.this, _1_0first_page.class);
                            _1_1register_page.this.startActivity(registerintent);
                        }
                    });
                    builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            System.out.println("버튼클릭");
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();


                    System.out.println(response + "통신성공");
                }
            }
            ,
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(_1_1register_page.this);
                    builder.setTitle("회원가입 실패");
                    builder.setPositiveButton("뒤로가기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            System.out.println("버튼클릭");
                            Intent registerintent = new Intent(_1_1register_page.this, _1_0first_page.class);
                            _1_1register_page.this.startActivity(registerintent);
                        }
                    });
                    builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            System.out.println("버튼클릭");
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    System.out.println(error + "통신실패");
                }
            }
    ) {
        @Override
        public Map<String, String> getParams() {
            Map<String, String> params = new HashMap<String, String>();
            params.put("joinid", joinid_str);
            params.put("joinpassword", password_str);
            params.put("joinpassword2", password2_str);
            params.put("joinemail",email_str);

            return params;
        }
    };

    staticmethod.requestQueue.add(request); //스태틱제네릭메소드 호출방법


}


public void overlapmethod() {
    EditText joinid_edit = (EditText) findViewById(R.id.joinid_edit);
    final String joinid_str = joinid_edit.getText().toString();

    String url = "http://tidahk.dothome.co.kr/overlap.php";
    StringRequest request = new StringRequest(
            Request.Method.POST,
            url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    System.out.println(response);
                    AlertDialog.Builder builder = new AlertDialog.Builder(_1_1register_page.this);
                    if (response.contains("중복아이디있다")){
                        builder.setMessage("중복아이디가 있습니다");
                        id_check=false;
                    }
                    else if(response.contains("중복아이디없다")){
                        builder.setMessage("중복된 아이디가 없습니다");
                        id_check=true;
                    }

                    builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            System.out.println("버튼클릭");
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
            params.put("joinid_dup", joinid_str);
            return params;
        }
    };

    staticmethod.requestQueue.add(request); //스태틱제네릭메소드 호출방법


}

}*/