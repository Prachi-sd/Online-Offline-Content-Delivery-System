package app.skylabs.cst.iexplorer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by HP on 9/9/2017.
 */

public class Result extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Bundle bundle = getIntent().getExtras();
        String marks = bundle.getString("marks");

        TextView txtView = (TextView) findViewById(R.id.textView92);
        txtView.setText(marks);

        System.out.println(marks);


    }
}
