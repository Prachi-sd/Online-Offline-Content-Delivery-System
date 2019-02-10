package app.skylabs.cst.iexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by HP on 7/25/2017.
 */

public class entry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);

        Button b1,b2;

        b1 = (Button) findViewById(R.id.button4);
        b2 = (Button) findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(entry.this,
                        Indsel.class);
                startActivity(myIntent);

                finish();

            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(entry.this,
                        Schsel.class);
                startActivity(myIntent);

                finish();
            }

        });
    }
}