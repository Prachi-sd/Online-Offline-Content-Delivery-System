package app.skylabs.cst.iexplorer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by HP on 9/7/2017.
 */

public class Next extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);
        TextView t1, t2,t3,t4;
Button b1,b2;
        t2 = (TextView) findViewById(R.id.textView86);
        t1 = (TextView) findViewById(R.id.textView88);

        t3 = (TextView) findViewById(R.id.textView78);
        t4 = (TextView) findViewById(R.id.textView79);
        b1 = (Button) findViewById(R.id.button21);
        b2 = (Button) findViewById(R.id.button22);
        TabHost host = (TabHost)findViewById(R.id.tab);
        host.setup();

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Next.this,
                        Test.class);
                startActivity(myIntent);

                finish();

            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Next.this,
                        Test.class);
                startActivity(myIntent);

                finish();

            }

        });

        TabHost.TabSpec spec = host.newTabSpec("BioDiversity");
        spec.setContent(R.id.BioDiversity);
        spec.setIndicator("BioDiversity");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Astronomy");
        spec.setContent(R.id.Astronomy);
        spec.setIndicator("Astronomy");
        host.addTab(spec);


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://aseemitsec.com/syllabus/bio.pdf"));
                startActivity(browserIntent);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://aseemitsec.com/syllabus/bio.pdf"));
                startActivity(browserIntent);
            }
        });


        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://aseemitsec.com/syllabus/disteng.pdf"));
                startActivity(browserIntent);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://aseemitsec.com/syllabus/distmar.pdf"));
                startActivity(browserIntent);
            }
        });

    }
}