package com.app_dev.aswin_sundar.trialtwo;


import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MoveCommand extends AsyncTask<String,String,String> {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    String mUrl = "http://cropper.azurewebsites.net/move";

    @Override
    protected String doInBackground(String... params) {

        try {
            String result=post(mUrl,params[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
