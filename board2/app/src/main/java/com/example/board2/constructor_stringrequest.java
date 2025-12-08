package com.example.board2;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class constructor_stringrequest {

    String url;
    String POST_GET;
    int method;
    private i_Listener i_Listener;
    private i_ErrorListener i_ErrorListener;

    private i_getParams i_getParams;


    public interface i_Listener {
        void i_onResponse(String i_response);
    }

    public interface i_ErrorListener {
        void i_onResponse(VolleyError i_error);
    }

    public interface i_getParams {
        Map<String, String> getParams() throws AuthFailureError;
    }

    public constructor_stringrequest(String url, String POST_GET, i_Listener i_listener, i_ErrorListener i_errorListener, i_getParams i_getParams) {
        this.url = url;
        this.POST_GET = POST_GET;
        this.i_Listener = i_listener;
        this.i_ErrorListener = i_errorListener;
        this.i_getParams = i_getParams;

        if (POST_GET.equalsIgnoreCase("POST")) {
            method = Request.Method.POST;
        } else {
            method = Request.Method.GET;
        }

    }
    public constructor_stringrequest(String url, String POST_GET, i_Listener i_listener, i_ErrorListener i_errorListener) {
        this.url = url;
        this.POST_GET = POST_GET;
        this.i_Listener = i_listener;
        this.i_ErrorListener = i_errorListener;
        //this.i_getParams = i_getParams;

        if (POST_GET.equalsIgnoreCase("POST")) {
            method = Request.Method.POST;
        } else {
            method = Request.Method.GET;
        }

    }

    public void standard() {
        StringRequest request = new StringRequest(
                method,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            i_Listener.i_onResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                            i_ErrorListener.i_onResponse(error);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (method == Request.Method.POST) {
                    return i_getParams.getParams();
                }
                return super.getParams();

            }

        };

        staticmethod.requestQueue.add(request);

    }
}




        /*      생성자 빈 예제
                            new constructor_stringrequest(
                            "http://tidahk.dothome.co.kr/register_php.php",
                            "POST",
                            new constructor_stringrequest.i_Listener() {
                                @Override
                                public void i_onResponse(String i_response) {



                                }
                            },
                            new constructor_stringrequest.i_ErrorListener(){
                                @Override
                                public void i_onResponse(VolleyError i_error) {


                                }
                            }, new constructor_stringrequest.i_getParams(){
                        @Override
                        public Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();


                            return params;

                        }

                    }).standard()  ;

*/