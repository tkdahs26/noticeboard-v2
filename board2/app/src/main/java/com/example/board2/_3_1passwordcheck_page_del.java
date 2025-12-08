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

public class _3_1passwordcheck_page_del extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._3_1activity_passwordcheck_page_del);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        if (staticmethod.requestQueue == null) {
            staticmethod.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        ImageButton passwordcheck_button = (ImageButton) findViewById(R.id.passwordcheck_button_del);
        passwordcheck_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view) {
                EditText passwordcheck_edit = (EditText) findViewById(R.id.passwordcheck_edit_del);
                String check_edit = passwordcheck_edit.getText().toString();
                System.out.println("first_page"+ _1_0first_page.json2);
                System.out.println("check_edit"+check_edit);
                if (_1_0first_page.json2.equals(check_edit)) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(_3_1passwordcheck_page_del.this);
                    builder.setTitle("정말 삭제하시겠습니까?");
                    builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            System.out.println("버튼클릭");
                            del_method();
                            Intent registerintent = new Intent(_3_1passwordcheck_page_del.this, _2_0homepage.class);
                            _3_1passwordcheck_page_del.this.startActivity(registerintent);
                        }
                    });
                    builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent registerintent = new Intent(_3_1passwordcheck_page_del.this, _3_0content_page.class);
                            _3_1passwordcheck_page_del.this.startActivity(registerintent);
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(_3_1passwordcheck_page_del.this);
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
        Intent registerintent = new Intent(_3_1passwordcheck_page_del.this, _3_0content_page.class);
        _3_1passwordcheck_page_del.this.startActivity(registerintent);
        super.onBackPressed();
    }

    public void del_method ()  {

        String url = "http://tidahk.dothome.co.kr/delete.php";


        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override //응답성공시 행동코드 ajax done이랑 비슷
                    public void onResponse(String response) {
                        System.out.println("response"+response + "성공");


                        AlertDialog.Builder builder = new AlertDialog.Builder(_3_1passwordcheck_page_del.this);
                        builder.setTitle("삭제성공");
                        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("버튼클릭");
                                Intent registerintent = new Intent(_3_1passwordcheck_page_del.this, _3_0content_page.class);
                                _3_1passwordcheck_page_del.this.startActivity(registerintent);
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        System.out.println("삭제성공");

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(_3_1passwordcheck_page_del.this);
                        builder.setTitle("서버통신오류");
                        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
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
                params.put("json3_id_php", _3_0content_page.json3_index);

                return params;
            }
        };

        staticmethod.requestQueue.add(request);
    }



}