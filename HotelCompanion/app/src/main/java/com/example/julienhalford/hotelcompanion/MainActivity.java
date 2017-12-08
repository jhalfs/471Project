package com.example.julienhalford.hotelcompanion;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class MainActivity extends AppCompatActivity {

    static Connection conn;
    String un;
    String pass;
    static String db;
    String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ip = "sql7003.site4now.net";
        db = "DB_A2EB9D_471Hotels";
        un = "DB_A2EB9D_471Hotels_admin";
        pass = "hotelsdb1";
    }

    public void onButtonClickConnect(View v){
        conn = connectionclass(un, pass, db, ip);
        Intent reg = new Intent(MainActivity.this, Register.class);
        startActivity(reg);
    }

    public void onButtonClick2(View v){
        Intent signIn = new Intent(MainActivity.this, HomePage.class);
        startActivity(signIn);
    }

    @SuppressLint("NewApi")
        public Connection connectionclass (String user, String pass, String db, String server){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Connection connection = null;
            String connectionURL = null;

            try{
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                connectionURL = "jdbc:jtds:sqlserver://" + server + ";" + "databseName=" + db + ";user=" + user + ";password=" + pass + ";";
                connection = DriverManager.getConnection(connectionURL);

            }catch(Exception e){
                Log.e("Error: ", e.getMessage());
            }

            return connection;
        }
}