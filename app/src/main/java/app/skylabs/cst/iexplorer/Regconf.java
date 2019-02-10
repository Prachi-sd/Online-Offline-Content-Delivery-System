package app.skylabs.cst.iexplorer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.R.color.holo_green_light;

/**
 * Created by HP on 7/12/2017.
 */

public class Regconf extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_conf);
        Button b1;

        final ConnectivityManager cm = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);


        b1 = (Button) findViewById(R.id.button5);

        final TextView t1 = (TextView) findViewById(R.id.editText34);






        new Thread(new Runnable() {
            @Override
            public void run() {

                int a=0;


                while(a != 1)
                {
                    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                    boolean isConnected = activeNetwork != null &&
                            activeNetwork.isConnected();

                    if (isConnected) {

                        System.out.println("Thread exicuting LOL");

                        OutputStream os = null;
                        InputStream is = null;
                        HttpURLConnection conn = null;
                        try {
                            //constants
                            Cursor c;
                            SQLiteDatabase db = openOrCreateDatabase("REG", Context.MODE_PRIVATE, null);

                            URL url = new URL("http://aseemitsec.com/app/index.php");
                            JSONObject jsonObject = new JSONObject();


                            c = db.rawQuery("SELECT * FROM individual5 ", null);

                            c.moveToLast();

                            jsonObject.put("name", c.getString(0));
                            jsonObject.put("dob", c.getString(1));
                            jsonObject.put("address", c.getString(2));
                            jsonObject.put("city", c.getString(3));
                            jsonObject.put("phone", c.getString(4));
                            jsonObject.put("email", c.getString(5));
                            jsonObject.put("occupation", c.getString(6));
                            jsonObject.put("workadd", c.getString(7));
                            jsonObject.put("workcontact", c.getString(8));
                            jsonObject.put("csubject", c.getString(9));
                            jsonObject.put("orgname", c.getString(10));
                            jsonObject.put("orgcontact", c.getString(11));
                            jsonObject.put("yearsxp", c.getString(12));
                            jsonObject.put("information", c.getString(13));
                            jsonObject.put("coordinator", c.getString(14));
                            jsonObject.put("transaction", c.getString(15));
                            jsonObject.put("bname", c.getString(16));


                            String message = jsonObject.toString();

                            c.close();

                            conn = (HttpURLConnection) url.openConnection();
                            conn.setReadTimeout(100000 /*milliseconds*/);
                            conn.setConnectTimeout(150000 /* milliseconds */);
                            conn.setRequestMethod("POST");
                            conn.setDoInput(true);
                            conn.setDoOutput(true);
                            conn.setFixedLengthStreamingMode(message.getBytes().length);

                            //make some HTTP header nicety
                            conn.setRequestProperty("Content-Type", "application/json");
                            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

                            //open
                            Thread.sleep(1000);

                            conn.connect();

                            //setup send
                            os = new BufferedOutputStream(conn.getOutputStream());
                            os.write(message.getBytes());
                            //clean up
                            os.flush();

                            //do somehting with response
                            is = conn.getInputStream();
                            System.out.println("This should Print someting ");

                            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                            StringBuilder result = new StringBuilder();
                            String line;
                            while ((line = reader.readLine()) != null) {
                                result.append(line);
                            }
                            System.out.println(result.toString());

                           // t1.setText(" Registered Successfully !! ");
                          //  t1.setTextColor(getResources().getColor(holo_green_light));



                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {

                            a =1;
                        }


                    }

                }

            }

        }).start();














        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class



                finish();
            }
        });

    }
}
