package app.skylabs.cst.iexplorer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = openOrCreateDatabase("REG", Context.MODE_PRIVATE, null);




        db.execSQL("CREATE TABLE IF NOT EXISTS info(name VARCHAR, phone VARCHAR,city VARCHAR);");
        String countQuery = "SELECT  * FROM info";

        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();

        System.out.println("No of rows = " + cnt);

        if (cnt > 0) {

            Intent myIntent = new Intent(MainActivity.this,
                    Info.class);
            startActivity(myIntent);
            finish();

        }

        InputStream inputStream = getResources().openRawResource(R.raw.table_1);

        read(inputStream);


        final EditText e1, e2, e3;
        Button b1;

        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);

        b1 = (Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                if (e1.getText().toString().length() == 0)
                    e1.setError("Name is required!");
                if (e2.getText().toString().length() == 0)
                    e2.setError("Phone No. is required!");
                if (e3.getText().toString().length() == 0)
                    e3.setError("City is required!");


                // Start NewActivity.class


                if (e1.getText().toString().length() != 0 && e2.getText().toString().length() != 0 && e3.getText().toString().length() != 0) {
                    Cursor c;


                    SQLiteDatabase db = openOrCreateDatabase("REG", Context.MODE_PRIVATE, null);

                    db.execSQL("INSERT INTO info VALUES('" + e1.getText() + "','" + e2.getText() + "','" + e3.getText() + "');");
                    c = db.rawQuery("SELECT * FROM info ", null);
                    c.moveToLast();

                    Intent myIntent = new Intent(MainActivity.this,
                            Info.class);
                    startActivity(myIntent);

                    finish();

                }
            }
        });


    }


    public void read(InputStream inputStream) {

        SQLiteDatabase db = openOrCreateDatabase("REG", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS test1(rid integer,qcode integer,question VARCHAR, A VARCHAR, B VARCHAR,  C VARCHAR, D VARCHAR, Correct VARCHAR);");

        List resultList = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {


            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
                System.out.println("hello  :  " + row[1]);

                String s= "INSERT INTO test1 VALUES('" +row[0] + "','" +row[1] + "','" + row[2] + "','" +row[3] + "','" +row[4] + "','" +row[5] + "','" +row[6] + "','" +row[7] +"');";

                System.out.println("1234" + s);

                db.execSQL("INSERT INTO test1 VALUES('" +row[0] + "','" +row[1] + "','" + row[2] + "','" +row[3] + "','" +row[4] + "','" +row[5] + "','" +row[6] + "','" +row[7] +"');");
                resultList.add(row);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: " + ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: " + e);
            }
        }


    }

}

