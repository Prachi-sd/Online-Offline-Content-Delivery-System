package app.skylabs.cst.iexplorer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by HP on 9/8/2017.
 */

public class Test extends AppCompatActivity {

    int count=1,mks=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        final TextView t1,t2,t3,t4,t5;
        Button b1, b2;
        final RadioGroup r1;
        final RadioButton rb1,rb2,rb3,rb4;
        t1 = (TextView) findViewById(R.id.textView70);
        //t2 = (TextView) findViewById(R.id.textView66);

        rb1= (RadioButton)findViewById(R.id.radioButton19);
        rb2= (RadioButton)findViewById(R.id.radioButton20);
        rb3= (RadioButton)findViewById(R.id.radioButton21);
        rb4= (RadioButton)findViewById(R.id.radioButton22);
        r1 = (RadioGroup) findViewById(R.id.rg1);
        b1 = (Button) findViewById(R.id.button16);
        b2 = (Button) findViewById(R.id.button17);

        SQLiteDatabase db = openOrCreateDatabase("REG", Context.MODE_PRIVATE, null);
        final Cursor c;
        //String query = "SELECT * FROM `test1` WHERE 1 order by rand() limit 10";
        c=db.rawQuery("SELECT * FROM test1 ORDER BY RANDOM() LIMIT 10;",null);


        c.moveToFirst();
        String st = c.getString(c.getColumnIndex("question"));
        t1.setText(st);

        String ans1 = c.getString(c.getColumnIndex("A"));
        rb1.setText(ans1);

        String ans2 = c.getString(c.getColumnIndex("B"));
        // System.out.println(ans2);
        rb2.setText(ans2);

        String ans3 = c.getString(c.getColumnIndex("C"));
        //System.out.println(ans3);
        rb3.setText(ans3);

        String ans4 = c.getString(c.getColumnIndex("D"));
        rb4.setText(ans4);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {



                String x="";
                String x1="";

                int selectedId = r1.getCheckedRadioButtonId();

                RadioButton radioButton = (RadioButton) findViewById(selectedId);


                x = radioButton.getText().toString();
                System.out.println(count+"radio selected"+x);
                String result = c.getString(c.getColumnIndex("Correct"));
                System.out.println(count+"correct option"+result);
                x1=c.getString(c.getColumnIndex(result));
                System.out.println(count+"answer in database"+x1);
                if(x.equals(x1))
                {
                    mks++;
                }
                System.out.println(mks);





                if(count==10)
                {

                    String marks = new Integer(mks).toString();

                    Intent myIntent = new Intent(Test.this,
                            Result.class);
                    myIntent.putExtra("marks", marks);
                    startActivity(myIntent);

                    finish();
                }
                else {

                    c.moveToNext();
                    String st = c.getString(c.getColumnIndex("question"));
                    t1.setText(st);

                    String ans1 = c.getString(c.getColumnIndex("A"));
                    rb1.setText(ans1);

                    String ans2 = c.getString(c.getColumnIndex("B"));
                    //System.out.println(ans2);
                    rb2.setText(ans2);

                    String ans3 = c.getString(c.getColumnIndex("C"));
                    //System.out.println(ans3);
                    rb3.setText(ans3);

                    String ans4 = c.getString(c.getColumnIndex("D"));
                    rb4.setText(ans4);


                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);

                    count++;
                }
            }
        });




        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String marks = new Integer(mks).toString();
                Intent myIntent = new Intent(Test.this,
                        Result.class);
                myIntent.putExtra("marks", marks);
                startActivity(myIntent);

                finish();

            }
        });



        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {




                String x = "";
                String x1 = "";

                int selectedId = r1.getCheckedRadioButtonId();


                RadioButton radioButton = (RadioButton) findViewById(selectedId);

                if (radioButton != null)

                {
                    x = radioButton.getText().toString();
                    System.out.println(count + "radio selected" + x);
                    String result = c.getString(c.getColumnIndex("Correct"));
                    System.out.println(count + "correct option" + result);
                    x1 = c.getString(c.getColumnIndex(result));
                    System.out.println(count + "answer in database" + x1);
                    if (x.equals(x1)) {
                        mks++;
                    }
                    System.out.println(mks);


                    if (count == 10) {

                        String marks = new Integer(mks).toString();

                        Intent myIntent = new Intent(Test.this,
                                Result.class);
                        myIntent.putExtra("marks", marks);
                        startActivity(myIntent);

                        finish();
                    } else {

                        c.moveToNext();
                        String st = c.getString(c.getColumnIndex("question"));
                        t1.setText(st);

                        String ans1 = c.getString(c.getColumnIndex("A"));
                        rb1.setText(ans1);

                        String ans2 = c.getString(c.getColumnIndex("B"));
                        //System.out.println(ans2);
                        rb2.setText(ans2);

                        String ans3 = c.getString(c.getColumnIndex("C"));
                        //System.out.println(ans3);
                        rb3.setText(ans3);

                        String ans4 = c.getString(c.getColumnIndex("D"));
                        rb4.setText(ans4);


                        rb1.setChecked(false);
                        rb2.setChecked(false);
                        rb3.setChecked(false);
                        rb4.setChecked(false);

                        count++;
                    }
                }
            }
        },30000);


        /*new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {

                t2.setText("Time remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                t2.setText("done!");
            }
        }.start();*/







    }
}
