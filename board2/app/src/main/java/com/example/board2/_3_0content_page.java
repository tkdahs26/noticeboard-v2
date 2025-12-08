package com.example.board2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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

public class _3_0content_page extends AppCompatActivity {
    static String json1_title="";
    static String json2_content="";
    static String json3_index="";
    static String json4_writer="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._3_0activity_content_page);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);


        }



        if (staticmethod.requestQueue == null) {
            staticmethod.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }




        ImageButton writerview_textview = (ImageButton) findViewById(R.id.fix_button);
        writerview_textview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(_3_0content_page.this, _3_2passwordcheck_page_fix.class);
                _3_0content_page.this.startActivity(registerintent);
            }
        });


        ImageButton delete_button = (ImageButton) findViewById(R.id.delete_button);
        delete_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(_3_0content_page.this, _3_1passwordcheck_page_del.class);
                _3_0content_page.this.startActivity(registerintent);
            }
        });




        TextView contentview_textview = (TextView) findViewById(R.id.fixcontent_edit);
        TextView titleview_textview = (TextView) findViewById(R.id.fixtitle_edit);
        TextView writerview_textview2 = (TextView) findViewById(R.id.fixwriter_textview);


        new constructor_stringrequest(
                "http://tidahk.dothome.co.kr/contentpage.php",
                "POST",
                new constructor_stringrequest.i_Listener() {
                    @Override
                    public void i_onResponse(String i_response) {

                        try {
                            JSONParser jsonParser = new JSONParser();
                            JSONObject jsonObject = (JSONObject) jsonParser.parse(i_response);
                            JSONObject json0 = (JSONObject) jsonObject.get("result");
                            json1_title = (String) json0.get("title");
                            json2_content = (String) json0.get("content");
                            json3_index= (String) json0.get("index");
                            json4_writer = (String) json0.get("writer");
                            contentview_textview.setText(json2_content);
                            titleview_textview.setText(json1_title);
                            writerview_textview2.setText(json4_writer);
                        } catch (NullPointerException| ParseException e) {
                            System.out.println(e);
                        }


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
                params.put("title_php", _2_0homepage.gettitle);
                return params;

            }

        }).standard()  ;
















    }

    @Override
    public void onBackPressed() {
        Intent registerintent = new Intent(_3_0content_page.this, _2_0homepage.class);
        _3_0content_page.this.startActivity(registerintent);
        super.onBackPressed();
    }
/*
    public void overlapmethod() {

        TextView contentview_textview = (TextView) findViewById(R.id.fixcontent_edit);
        TextView titleview_textview = (TextView) findViewById(R.id.fixtitle_edit);
        TextView writerview_textview = (TextView) findViewById(R.id.fixwriter_textview);




        String url = "http://tidahk.dothome.co.kr/contentpage.php";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println("response2"+response);

                        try {
                            JSONParser jsonParser = new JSONParser();
                            JSONObject jsonObject = (JSONObject) jsonParser.parse(response);
                            JSONObject json0 = (JSONObject) jsonObject.get("result");
                             json1_title = (String) json0.get("title");
                             json2_content = (String) json0.get("content");
                             json3_index= (String) json0.get("index");
                            json4_writer = (String) json0.get("writer");
                            contentview_textview.setText(json2_content);
                            titleview_textview.setText(json1_title);
                            writerview_textview.setText(json4_writer);
                        } catch (NullPointerException| ParseException e) {
                            System.out.println(e);
                        }

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
                params.put("title_php", _2_0homepage.gettitle);
                return params;
            }
        };

        staticmethod.requestQueue.add(request); //스태틱제네릭메소드 호출방법


    }

*/




}