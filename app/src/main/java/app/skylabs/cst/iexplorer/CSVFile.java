package app.skylabs.cst.iexplorer;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {
    InputStream inputStream;


    public SQLiteDatabase db;


    public CSVFile(InputStream inputStream){

        this.inputStream = inputStream;


    }


    public List read(){

      db.execSQL("CREATE TABLE IF NOT EXISTS test(rid integer,qcode integer,question VARCHAR, A VARCHAR, B VARCHAR,  C VARCHAR, D VARCHAR, Correct VARCHAR, diff VARCHAR );");

        List resultList = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {





            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
                System.out.println("hello  :  "+row[1]);


                db.execSQL("INSERT INTO info VALUES('" +row[1] + "','" + row[2] + "','" +row[3] + "','" +row[4] + "','" +row[5] + "','" +row[6] + "','" +row[7] +"','" +row[8] + "','" +row[9] + "');");


                resultList.add(row);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return resultList;
    }
}