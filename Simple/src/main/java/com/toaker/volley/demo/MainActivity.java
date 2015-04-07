package com.toaker.volley.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static com.toaker.volley.demo.R.*;


public class MainActivity extends Activity {

    RequestQueue requestQueue;

    private TextView   mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        mTextView = (TextView) findViewById(id.main_text);
        request.setShouldCache(true);
        requestQueue.add(request);
    }

    /**
     * 创建Request对象
     */
    private StringRequest request = new StringRequest(Request.Method.GET,
            "https://github.com/Toaker/framework-master/blob/master/framework/src/main/java/com/toaker/framework/core/component/ActionBarWrapper.java"
            ,new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            mTextView.setText(response);
        }
    },new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
        }
    });


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            requestQueue.add(request);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
