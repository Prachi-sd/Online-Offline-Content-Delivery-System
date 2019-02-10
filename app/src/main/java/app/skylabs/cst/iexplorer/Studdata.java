package app.skylabs.cst.iexplorer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by HP on 7/12/2017.
 */

public class Studdata  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stud_data);
        Button b1;
        final EditText e15, e19, e27, e30, e31, e32, e33, e34;
        final RadioGroup r1;
        Button b2;


        e15 = (EditText) findViewById(R.id.editText15);
        e19 = (EditText) findViewById(R.id.editText19);
        e27 = (EditText) findViewById(R.id.editText27);
        e30 = (EditText) findViewById(R.id.editText30);
        e31 = (EditText) findViewById(R.id.editText31);
        e32 = (EditText) findViewById(R.id.editText32);
        e33 = (EditText) findViewById(R.id.editText33);
        e34 = (EditText) findViewById(R.id.editText34);


        r1 = (RadioGroup) findViewById(R.id.rg1);

        b2 = (Button) findViewById(R.id.button3);


        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                int s1, s2;
                s1 = r1.getCheckedRadioButtonId();

                RadioButton selected = (RadioButton) findViewById(s1);

                String x = (String) selected.getText();

                //System.out.println(x);
//String test="INSERT INTO individual VALUES('"+ e1.getText()+"','"+ e2.getText()+"','"+ e3.getText()+"','"+ e4.getText()+"','"+ e5.getText()+"','"+ e6.getText()+"','"+ e7.getText()+"','"+ e8.getText()+"','"+ e9.getText()+"','"+ e10.getText()+"','"+ e11.getText()+"','"+ e12.getText()+"','"+ e13.getText()+"','"+ e14.getText()+"')";
                //System.out.println(test);

                Cursor c;

                SQLiteDatabase db = openOrCreateDatabase("REG", Context.MODE_PRIVATE, null);
                db.execSQL("CREATE TABLE IF NOT EXISTS stud1(  studname VARCHAR,studstd VARCHAR,studdiv VARCHAR,studdob VARCHAR,studsubject VARCHAR, pname VARCHAR, prelation VARCHAR,pcontact VARCHAR,pemail VARCHAR );");
                db.execSQL("INSERT INTO stud1 VALUES('" + e15.getText() + "','" + e19.getText() + "','" + e27.getText() + "','" + e30.getText() + "','" + x + "','" + e31.getText() + "','" + e32.getText() + "','" + e33.getText() + "','" + e34.getText() + "');");
              c = db.rawQuery("SELECT * FROM stud1 ", null);

                c.moveToFirst();
                String name = c.getString(0);
                String dob = c.getString(1);
                String add = c.getString(2);
                String city = c.getString(3);
                System.out.println(name);
                System.out.println(dob);
                System.out.println(add);
                System.out.println(city);


                Intent myIntent = new Intent(Studdata.this,
                        Regconf.class);
                startActivity(myIntent);

            }
        });
    }
}
