package app.skylabs.cst.iexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by HP on 7/25/2017.
 */

public class Schsel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schsel);
        Button b1,b2,b3;

        b1 = (Button) findViewById(R.id.button7);
        b2 = (Button) findViewById(R.id.button6);
        b3 = (Button) findViewById(R.id.button5);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Schsel.this,
                        Terncond2.class);
                startActivity(myIntent);

                finish();

            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Schsel.this,
                        Terncond2.class);
                startActivity(myIntent);

                finish();

            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Schsel.this,
                        Terncond2.class);
                startActivity(myIntent);

                finish();
            }

        });

    }
}
