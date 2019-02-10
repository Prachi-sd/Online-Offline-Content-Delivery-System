package app.skylabs.cst.iexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by HP on 8/14/2017.
 */

public class Terncond2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terncond2);

        Button b1;
        b1 = (Button) findViewById(R.id.button12);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Terncond2.this,
                        Instform.class);
                startActivity(myIntent);
            }

        });

    }
}

