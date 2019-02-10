package app.skylabs.cst.iexplorer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by HP on 9/21/2017.
 */

public class Astro  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.astro);
        TextView t1, t2, t3, t4;
        Button b1, b2;
        t2 = (TextView) findViewById(R.id.textView95);
        t1 = (TextView) findViewById(R.id.textView97);

        b1 = (Button) findViewById(R.id.button15);
        b2 = (Button) findViewById(R.id.button18);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Astro.this,
                        Test.class);
                startActivity(myIntent);

                finish();

            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Astro.this,
                        Test.class);
                startActivity(myIntent);

                finish();

            }

        });



        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://aseemitsec.com/syllabus/disteng.pdf"));
                startActivity(browserIntent);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://aseemitsec.com/syllabus/distmar.pdf"));
                startActivity(browserIntent);
            }
        });




    }

}
