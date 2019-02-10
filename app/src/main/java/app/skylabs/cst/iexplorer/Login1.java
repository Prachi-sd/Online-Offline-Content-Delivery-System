package app.skylabs.cst.iexplorer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

import static android.os.SystemClock.sleep;


/**
 * Created by HP on 9/7/2017.
 */

public class Login1 extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    static String op="test";
    TextView tx1;
    EditText user,pass;
    //int count = 3;
    Button b1;
    //EditText e0, e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        final ConnectivityManager cm = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        final SQLiteDatabase db = openOrCreateDatabase("REG", Context.MODE_PRIVATE, null);
        user = (EditText) findViewById(R.id.editText35);
        pass = (EditText) findViewById(R.id.editText36);


        b1 = (Button) findViewById(R.id.button14);

        tx1 = (TextView) findViewById(R.id.textView68);
        tx1.setVisibility(View.GONE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String foo = user.getText().toString();
                final String bar = foo.substring(0, 1);
                System.out.println("***"+bar);
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        int a=0;

                        String ret;


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

                                    URL url = new URL("http://aseemitsec.com/app/login.php");
                                    JSONObject jsonObject = new JSONObject();




                                    jsonObject.put("uname", user.getText());
                                    jsonObject.put("pass", pass.getText());
                                    String u=user.getText().toString();
                                    String p=pass.getText().toString();







                                    String message = jsonObject.toString();



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


                                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                                    StringBuilder result = new StringBuilder();
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        result.append(line);
                                    }
                              ret = result.toString();

                                     String xyz  =ret.substring(ret.length()-1);
                                    System.out.println("This should Print someting "+xyz);

                                    System.out.println(xyz.equals("A"));

                                    if(xyz.equals("A"))
                                    {

                                        String quer="INSERT INTO userpass VALUES('"+u+"','"+p+"');";

                                        System.out.println(quer);
                                        SQLiteDatabase db = openOrCreateDatabase("REG", Context.MODE_PRIVATE, null);
                                        db.execSQL("CREATE TABLE IF NOT EXISTS userpass(  Name VARCHAR, Pass VARCHAR)");
                                        db.execSQL(quer);

                                        /*if(bar.equals("A")) {

                                            Intent myIntent = new Intent(Login1.this,
                                                    Astro.class);

                                            startActivity(myIntent);
                                        }


                                        if(bar.equals("B")) {

                                            Intent myIntent = new Intent(Login1.this,
                                                    Bio.class);

                                            startActivity(myIntent);
                                        }


                                        if(bar.equals("C")) {

                                            Intent myIntent = new Intent(Login1.this,
                                                    Next.class);

                                            startActivity(myIntent);
                                        }*/




                                    }



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



                /////

                sleep(10);
                String countQuery = "SELECT  * FROM userpass WHERE Name='"+user.getText().toString()+"' AND Pass='"+pass.getText().toString()+"'";
                System.out.println(countQuery);
                Cursor cursor = db.rawQuery(countQuery, null);
                int cnt = cursor.getCount();
                cursor.close();

                System.out.println("No of rows = " + cnt);

                if (cnt > 0) {

                    if(bar.equals("A")) {

                        Intent myIntent = new Intent(Login1.this,
                                Astro.class);

                        startActivity(myIntent);
                    }


                    if(bar.equals("B")) {

                        Intent myIntent = new Intent(Login1.this,
                                Bio.class);

                        startActivity(myIntent);
                    }


                    if(bar.equals("C")) {

                        Intent myIntent = new Intent(Login1.this,
                                Next.class);

                        startActivity(myIntent);
                    }
                    finish();
                }


            }
        });



    }



}