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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

public class _1_3find_page_pwd extends AppCompatActivity {

    static String json1;
    static String json2;
    static String response1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._1_3activity_find_page_pwd);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        EditText pwdfindid_edit = (EditText) findViewById(R.id.idfind_by_email_edit);

        ImageButton submit_btn = (ImageButton) findViewById(R.id.submit_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {       //onclick함수를 재정의
                if (pwdfindid_edit.getText().toString().isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(_1_3find_page_pwd.this);
                    builder.setMessage("빈칸이 있습니다");
                    builder.create();
                    builder.show();
                } else {
                    EditText pwdfindid_edit = (EditText) findViewById(R.id.idfind_by_email_edit);
                    final String pwdfindid_text = pwdfindid_edit.getText().toString();

                    new constructor_stringrequest(
                        "http://tidahk.dothome.co.kr/find_pwd.php",
                        "POST",
                        new constructor_stringrequest.i_Listener() {
                            @Override
                            public void i_onResponse(String i_response) {

                                try {
                                    JSONParser jsonParser = new JSONParser();
                                    JSONObject  jsonObject = (JSONObject) jsonParser.parse(i_response);
                                    JSONObject json0 = (JSONObject) jsonObject.get("result");
                                    // String result = (String) jsonObject.get("result");
                                    String json1 = (String) json0.get("joinid");
                                    String json2 = (String) json0.get("joinpassword");

                                    AlertDialog.Builder builder = new AlertDialog.Builder(_1_3find_page_pwd.this);
                                    builder.setTitle("비밀번호찾기 성공").setMessage("아이디:" + json1 + "\n비밀번호" + json2);
                                    builder.setPositiveButton("로그인하기", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            System.out.println("버튼클릭");
                                            Intent registerintent = new Intent(_1_3find_page_pwd.this, _1_0first_page.class);
                                            _1_3find_page_pwd.this.startActivity(registerintent);
                                        }
                                    });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();

                                } catch (NullPointerException|ParseException e) {
                                    System.out.println(e);

                                    AlertDialog.Builder builder = new AlertDialog.Builder(_1_3find_page_pwd.this);
                                    builder.setTitle("비밀번호찾기 실패").setMessage("다시 시도해주세요");
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
                        },
                        new constructor_stringrequest.i_ErrorListener(){
                            @Override
                            public void i_onResponse(VolleyError i_error) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(_1_3find_page_pwd.this);
                                builder.setTitle("서버통신오류");
                                builder.setPositiveButton("다시하기", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        System.out.println("버튼클릭");
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
                                System.out.println("실패"+i_error);
                            }

                            }
                        , new constructor_stringrequest.i_getParams(){
                    @Override
                    public Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("pwdfindid", pwdfindid_text);

                        return params;
                    }
                }).standard()  ;

                }
            }
        });

        ImageButton find_back_btn=(ImageButton)findViewById(R.id.find_back_btn);
        find_back_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(_1_3find_page_pwd.this, _1_0first_page.class);
                _1_3find_page_pwd.this.startActivity(registerintent);

            }
        });


        if (staticmethod.requestQueue == null) {
            staticmethod.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }





    }




    @Override
    public void onBackPressed() {
        Intent registerintent = new Intent(_1_3find_page_pwd.this, _1_0first_page.class);
        _1_3find_page_pwd.this.startActivity(registerintent);
        super.onBackPressed();
    }

    /*
    public void send ()  {

        String url = "http://tidahk.dothome.co.kr/find_pwd.php";
        EditText pwdfindid_edit = (EditText) findViewById(R.id.idfind_by_email_edit);
        final String pwdfindid_text = pwdfindid_edit.getText().toString();



        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override //응답성공시 행동코드 ajax done이랑 비슷
                    public void onResponse(String response) {
                        System.out.println("response"+response + "성공");


                        try {
                            JSONParser jsonParser = new JSONParser();
                            JSONObject  jsonObject = (JSONObject) jsonParser.parse(response);
                            JSONObject json0 = (JSONObject) jsonObject.get("result");
                            // String result = (String) jsonObject.get("result");
                            String json1 = (String) json0.get("joinid");
                            String json2 = (String) json0.get("joinpassword");

                            AlertDialog.Builder builder = new AlertDialog.Builder(_1_3find_page_pwd.this);
                            builder.setTitle("비밀번호찾기 성공").setMessage("아이디:" + json1 + "\n비밀번호" + json2);
                            builder.setPositiveButton("로그인하기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.out.println("버튼클릭");
                                    Intent registerintent = new Intent(_1_3find_page_pwd.this, _1_0first_page.class);
                                    _1_3find_page_pwd.this.startActivity(registerintent);
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();

                        } catch (NullPointerException|ParseException e) {
                            System.out.println(e);

                            AlertDialog.Builder builder = new AlertDialog.Builder(_1_3find_page_pwd.this);
                            builder.setTitle("비밀번호찾기 실패").setMessage("다시 시도해주세요");
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
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(_1_3find_page_pwd.this);
                        builder.setTitle("서버통신오류");
                        builder.setPositiveButton("다시하기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("버튼클릭");
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
                        System.out.println("실패"+error);
                    }
                }
        ) {
            @Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("pwdfindid", pwdfindid_text);

                return params;
            }
        };

        staticmethod.requestQueue.add(request);
    }
*/






}