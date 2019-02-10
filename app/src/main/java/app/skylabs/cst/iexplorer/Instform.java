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
 * Created by HP on 7/11/2017.
 */

public class Instform extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.inst_form);

        TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17;
        //final EditText e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12;
        final EditText e16, e17, e18, e20, e21, e22, e23, e24, e25, e26, e28, e29;
        final RadioGroup r1, r2, r3;
        CheckBox c1;
        Button b1;
        e16 = (EditText) findViewById(R.id.editText16);
        e17= (EditText) findViewById(R.id.editText17);
        e18 = (EditText) findViewById(R.id.editText18);
        e20 = (EditText) findViewById(R.id.editText20);
        e21 = (EditText) findViewById(R.id.editText21);
        e22 = (EditText) findViewById(R.id.editText22);
        e23 = (EditText) findViewById(R.id.editText23);
        e24 = (EditText) findViewById(R.id.editText24);
        e25 = (EditText) findViewById(R.id.editText25);
        e26 = (EditText) findViewById(R.id.editText26);
        e28 = (EditText) findViewById(R.id.editText28);
        e29 = (EditText) findViewById(R.id.editText29);


        r1 = (RadioGroup) findViewById(R.id.rg1);
        r2 = (RadioGroup) findViewById(R.id.rg2);
        r3 = (RadioGroup) findViewById(R.id.rg3);

        b1 = (Button) findViewById(R.id.button2);
        //b2 = (Button) findViewById(R.id.button2);
        c1 = (CheckBox) findViewById(R.id.checkBox);


        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                int s1, s2,s3;
                if( e16.getText().toString().length() == 0 )
                    e16.setError( "Name is required!" );
                if (e20.getText().toString().length() == 0)
                    e20.setError("Phone No. is required!");
                String x="";
                String x1="";
                String x2="";

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

                int selectedId3 = r3.getCheckedRadioButtonId();

                if( selectedId3 == -1)
                {
                    RadioButton rdb = (RadioButton) findViewById(R.id.radioButton2);

                    rdb.setError("Please Select one ");

                }
                else {


                    RadioButton radioButton = (RadioButton) findViewById(selectedId3);

                    x2 = radioButton.getText().toString();
                }



                if (e16.getText().toString().length() != 0 && e20.getText().toString().length() != 0 ) {




                    SQLiteDatabase db = openOrCreateDatabase("REG", Context.MODE_PRIVATE, null);
                    db.execSQL("CREATE TABLE IF NOT EXISTS school1(  Sname VARCHAR,  Saddress VARCHAR,Scity VARCHAR, Sphone VARCHAR,contname VARCHAR,contdesig VARCHAR,contemail VARCHAR,princiname VARCHAR,princimob VARCHAR,princimail VARCHAR,schtype VARCHAR,grpcriteria VARCHAR,studcount VARCHAR,infosrc VARCHAR,coordname VARCHAR);");
                    db.execSQL("INSERT INTO school1 VALUES('" + e16.getText() + "','" + e17.getText() + "','" + e18.getText() + "','" + e20.getText() + "','" + e21.getText() + "','" + e22.getText() + "','" + e23.getText() + "','" + e24.getText() + "','" + e25.getText() + "','" + e26.getText() + "','" + x + "','" + x1 + "','" + e28.getText() + "','" + x2 + "','" + e29.getText() + "');");




                    Intent myIntent = new Intent(Instform.this,
                            Instconf.class);
                    startActivity(myIntent);
                    finish();

                }
            }
        });
    }
}





























