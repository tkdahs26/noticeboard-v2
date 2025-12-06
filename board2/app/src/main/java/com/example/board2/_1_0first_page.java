package com.example.board2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

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

public class _1_0first_page extends AppCompatActivity {

    private long backpressedTime = 0;

    static String json1;
    static String json2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._1_0activity_first_page);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        ImageButton registerbutton=(ImageButton)findViewById(R.id.register_btn);
        registerbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(_1_0first_page.this, _1_1register_page.class);
                _1_0first_page.this.startActivity(registerintent);
            }
        });

        ImageButton find_password=(ImageButton)findViewById(R.id.find_password);
        find_password.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(_1_0first_page.this, _1_3find_page_pwd.class);
                _1_0first_page.this.startActivity(registerintent);
            }
        });

        ImageButton find_id=(ImageButton)findViewById(R.id.find_id);
        find_id.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(_1_0first_page.this, _1_2find_page_id.class);
                _1_0first_page.this.startActivity(registerintent);
            }
        });







        EditText edit_id = (EditText) findViewById(R.id.edit_id);
        EditText edit_password = (EditText) findViewById(R.id.edit_password);
        ImageButton loginbutton=(ImageButton)findViewById(R.id.btn_login);
        loginbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                if(edit_id.getText().toString().isEmpty()||edit_password.getText().toString().isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(_1_0first_page.this);
                    builder.setMessage("빈칸이 있습니다");
                    builder.create();
                    builder.show();
                }
                else{send();}
            }
        });





        if (staticmethod.requestQueue == null) {
            staticmethod.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

    }



    @Override
    public void onBackPressed() {

        super.onBackPressed();
        if (System.currentTimeMillis() > backpressedTime + 2000) {
            backpressedTime = System.currentTimeMillis();
            Toast.makeText(this, "뒤로버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        } else if (System.currentTimeMillis() <= backpressedTime + 2000) {
            finish();
        }

    }

    public void send() {
        String url = "http://tidahk.dothome.co.kr/login.php";

        EditText edit_id = (EditText) findViewById(R.id.edit_id);
        EditText edit_password = (EditText) findViewById(R.id.edit_password);

        String editid_text = edit_id.getText().toString();
        String editpassword_text = edit_password.getText().toString();


        StringRequest request = new StringRequest(
                Request.Method.POST,
                //GET 방식
                //이 방식은 우리가 서버로부터 어떤 데이터를 받고 싶을 때 사용합니다.
                //POST방식
                //이 방식은 우리가 어떤 데이터를 서버에 보낼 때 사용하게 됩니다
                url,
                new Response.Listener<String>() {
                    @Override //응답성공시 행동코드 ajax done이랑 비슷
                    public void onResponse(String response) {
                        System.out.println("response"+response);
                        try {

                            JSONParser jsonParser = new JSONParser();
                            JSONObject jsonObject1 = (JSONObject) jsonParser.parse(response);
                            JSONObject json0 = (JSONObject) jsonObject1.get("result");
                            json1 = (String) json0.get("joinid");
                            json2 = (String) json0.get("joinpassword");


                            AlertDialog.Builder builder = new AlertDialog.Builder(_1_0first_page.this);
                            builder.setTitle("로그인 성공");
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.out.println("버튼클릭1");
                                    Intent registerintent = new Intent(_1_0first_page.this, _2_0homepage.class);
                                    _1_0first_page.this.startActivity(registerintent);
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();

                        } catch (ParseException  e) {      //ParseException=php오류 출력해줌
                            System.out.println("exeption"+e);

                            System.out.println("catchrespone"+response);


                                AlertDialog.Builder builder = new AlertDialog.Builder(_1_0first_page.this);
                            if(response.contains("아이디오류")) {
                                builder.setTitle("로그인 실패").setMessage("ID를 다시입력해주세요");
                            }else if(response.contains("비밀번호오류")) {
                                builder.setTitle("로그인 실패").setMessage("비밀번호를 다시입력해주세요");
                            }else{builder.setTitle("로그인 실패");
                                System.out.println("예상못한오류");}

                            //if는 조건만걸고 아래버튼은 공통으로사용
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.out.println("버튼클릭2");
                                }
                            });
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();


                        }
                        System.out.println("php통신성공");

                    }
                }
                ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(_1_0first_page.this);
                        builder.setTitle("서버통신 실패");
                        builder.setPositiveButton("뒤로가기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("버튼클릭3");

                                Intent registerintent = new Intent(_1_0first_page.this, _1_0first_page.class);
                                _1_0first_page.this.startActivity(registerintent);
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        System.out.println(error + "실패");
                    }
                }
        ) {
            @Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("editid_php", editid_text);
                params.put("editpassword_php", editpassword_text);

                return params;
            }
        };

        staticmethod.requestQueue.add(request); //스태틱제네릭메소드 호출방법


    }

}