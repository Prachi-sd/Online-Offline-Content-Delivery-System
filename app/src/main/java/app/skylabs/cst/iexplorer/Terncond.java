package app.skylabs.cst.iexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by HP on 7/26/2017.
 */

public class Terncond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terncond);

        Button b1;
        b1 = (Button) findViewById(R.id.button8);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Terncond.this,
                        Regform.class);
                startActivity(myIntent);
            }

        });

    }
}
