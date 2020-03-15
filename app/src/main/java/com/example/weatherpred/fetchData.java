package com.example.weatherpred;

import android.net.Uri;
import android.os.AsyncTask;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void,Void,Void> {

    String data = "";
    String dataParsed ="";
    String singleParsed = "";
    String imageParsed = "";
    @Override
    protected Void doInBackground(Void... voids) {
        //Used to have Changes in Background
        try {
            String url1 = "http://api.weatherstack.com/current?access_key=f98282f5f15d384388c661a4a6bc46f9&query="+Dashboard.loc.trim();
            URL url = new URL(url1.trim());
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream =httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line!= null)
            {
                line = bufferedReader.readLine();
                data = data + line;
            }
          JSONObject JO = new JSONObject(data);
           JSONObject cur = (JSONObject) JO.get("current");
           singleParsed = cur.get("temperature").toString();

           dataParsed = cur.get("weather_descriptions").toString();
           dataParsed = dataParsed.substring(2,dataParsed.length()-2);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        //Used to Change Ui
        Dashboard.tempValue.setText(singleParsed);
        Dashboard.tempString.setText(dataParsed);
        super.onPostExecute(aVoid);
    }
}
