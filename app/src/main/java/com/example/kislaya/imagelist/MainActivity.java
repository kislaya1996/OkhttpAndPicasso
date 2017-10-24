package com.example.kislaya.imagelist;

import android.app.DownloadManager;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
class GetExample {
    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LoadImg(View view) throws Exception
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        EditText txtUrl = (EditText) findViewById(R.id.txtUrl);
        TextView textview2 = (TextView) findViewById(R.id.textView2);
        String msg = txtUrl.getText().toString();
        //OkHttpClient client = new OkHttpClient();
        GetExample example = new GetExample();
        String response = example.run(msg);
        //textview.append(response);
        Log.d("msg", response);
    }
}

