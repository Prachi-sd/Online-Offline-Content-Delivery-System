package app.skylabs.cst.iexplorer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by HP on 7/26/2017.
 */

public class Techreg extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.techreg);

        TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18;
        final EditText e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
        final RadioGroup r1, r2, r3, r4, r5, r6;
        CheckBox c1;
        Button b1;


        e0 = (EditText) findViewById(R.id.editText);
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        e4 = (EditText) findViewById(R.id.editText4);
        e5 = (EditText) findViewById(R.id.editText5);
        e6 = (EditText) findViewById(R.id.editText6);
        e7 = (EditText) findViewById(R.id.editText7);
        e8 = (EditText) findViewById(R.id.editText8);
        e9 = (EditText) findViewById(R.id.editText9);
        e10 = (EditText) findViewById(R.id.editText10);
        e11 = (EditText) findViewById(R.id.editText11);
        e12 = (EditText) findViewById(R.id.editText12);
        e13 = (EditText) findViewById(R.id.editText13);
        e14 = (EditText) findViewById(R.id.editText14);

        r1 = (RadioGroup) findViewById(R.id.rg1);
        r2 = (RadioGroup) findViewById(R.id.rg2);

        b1 = (Button) findViewById(R.id.button);
        c1 = (CheckBox) findViewById(R.id.checkBox);


        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                int s1, s2;

                if (e0.getText().toString().length() == 0)
                    e0.setError("Name is required!");
                if (e1.getText().toString().length() == 0)
                    e1.setError("DOB is required!");
                if (e12.getText().toString().length() == 0)
                    e12.setError("Phone No. is required!");
                if (e13.getText().toString().length() == 0)
                    e13.setError("Transaction ID is required!");
                if (e14.getText().toString().length() == 0)
                    e14.setError("Bank Details is required!");

                String x="";
                String x1="";

                int selectedId = r1.getCheckedRadioButtonId();

                if( selectedId == -1)
                {
                    RadioButton rdb = (RadioButton) findViewById(R.id.radioButton2);

                    rdb.setError("Please Select one ");

                }
                else {

                    RadioButton radioButton = (RadioButton) findViewById(selectedId);


                    x = radioButton.getText().toString();
                }

                int selectedId2 = r2.getCheckedRadioButtonId();

                if( selectedId2 == -1)
                {
                    RadioButton rdb = (RadioButton) findViewById(R.id.radioButton2);

                    rdb.setError("Please Select one ");

                }
                else {


                    RadioButton radioButton = (RadioButton) findViewById(selectedId2);

                    x1 = radioButton.getText().toString();
                }
                //System.out.println(x);
//String test="INSERT INTO individual VALUES('"+ e1.getText()+"','"+ e2.getText()+"','"+ e3.getText()+"','"+ e4.getText()+"','"+ e5.getText()+"','"+ e6.getText()+"','"+ e7.getText()+"','"+ e8.getText()+"','"+ e9.getText()+"','"+ e10.getText()+"','"+ e11.getText()+"','"+ e12.getText()+"','"+ e13.getText()+"','"+ e14.getText()+"')";
                //System.out.println(test);



                /*
                String test = c.getString(0);
                System.out.println(test);
                c = db.rawQuery(SELECT_SQL, null);
                c.moveToFirst();
                */



                if (e0.getText().toString().length() != 0 && e1.getText().toString().length() != 0 && e12.getText().toString().length() != 0 && e13.getText().toString().length() != 0 && e14.getText().toString().length() != 0) {
                    Cursor c;

                    SQLiteDatabase db = openOrCreateDatabase("REG", Context.MODE_PRIVATE, null);
                    db.execSQL("CREATE TABLE IF NOT EXISTS teacher(  Name VARCHAR, dob VARCHAR, address VARCHAR,city VARCHAR, phone VARCHAR,email VARCHAR,desgnation VARCHAR,nameadd VARCHAR,tsubject VARCHAR,csubject VARCHAR,orgname VARCHAR,orgcontact VARCHAR,yearsxp VARCHAR,information VARCHAR,coordinator VARCHAR,transcation VARCHAR,bname VARCHAR );");
                    db.execSQL("INSERT INTO teacher VALUES('" + e0.getText() + "','" + e1.getText() + "','" + e2.getText() + "','" + e4.getText() + "','" + e12.getText() + "','" + e5.getText() + "','" + e6.getText() + "','" + e8.getText() + "','" + e7.getText() + "','" + x + "','" + e9.getText() + "','" + e10.getText() + "','" + e11.getText() + "','" + x1 + "','" + e3.getText() + "','" + e13.getText() + "','" + e14.getText() + "');");
                    c = db.rawQuery("SELECT * FROM teacher ", null);

                    c.moveToLast();

                    Intent myIntent = new Intent(Techreg.this,
                            Techconf.class);
                    startActivity(myIntent);

                    finish();
                }
            }
        });
    }
}
