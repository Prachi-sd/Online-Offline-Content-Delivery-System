package app.skylabs.cst.iexplorer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

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

import app.skylabs.cst.iexplorer.R;
import app.skylabs.cst.iexplorer.entry;

/**
 * Created by HP on 7/18/2017.
 */

public class Info extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        TextView t1, t2, t3;
        Button b1, b2;
        final ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        b1 = (Button) findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.button13);
        t2 = (TextView) findViewById(R.id.textView7);
        t1 = (TextView) findViewById(R.id.textView63);
        t3 = (TextView) findViewById(R.id.textView64);

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://aseemitsec.com/type.html"));
                startActivity(browserIntent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Info.this,
                        Login1.class);
                startActivity(myIntent);
            }

        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://aseemitsec.com/syllabus/bio.pdf"));
                startActivity(browserIntent);
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://aseemitsec.com/syllabus/Astro.pdf"));
                startActivity(browserIntent);


            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Info.this,
                        entry.class);
                startActivity(myIntent);
            }

        });


        new Thread(new Runnable() {
            @Override
            public void run() {

                int a = 0;


                while (a != 1) {

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
                            System.out.println("Global Accesed");
                            URL url = new URL("http://aseemitsec.com/app/main.php");
                            JSONObject jsonObject = new JSONObject();


                            c = db.rawQuery("SELECT * FROM info", null);

                            c.moveToLast();

                            jsonObject.put("name", c.getString(0));
                            jsonObject.put("phone", c.getString(1));
                            jsonObject.put("city", c.getString(2));


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

                            a = 1;
                        }


                    }

                }

            }

        }).start();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Info Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
