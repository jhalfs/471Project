package com.example.julienhalford.hotelcompanion;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchRooms extends AppCompatActivity {
    String Search, Browse, Space, Cap, Rat, searchQuery, ip, db, un, pass, Pr;
    static Connection conn;
    int j, searchedBefore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_rooms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ip = "sql7003.site4now.net";
        db = "DB_A2EB9D_471Hotels";
        un = "DB_A2EB9D_471Hotels_admin";
        pass = "hotelsdb1";
        conn = connectionclass(un, pass, db, ip);
        searchedBefore = 0;
    }

    public void onButtonClickSearchRating(View v){
        final EditText ratEdit = (EditText) findViewById(R.id.editText8);
        String ratingString = ratEdit.getText().toString();
        Search = "Book Room";
        Space = "  ";
        Cap = "Capacity: ";
        Rat = "Rating: ";
        Pr = "| Price: ";
        searchQuery = "SELECT * FROM DB_A2EB9D_471Hotels.dbo.Rooms WHERE Rating = '"+ratingString+"';";
        final LinearLayout lm = (LinearLayout) findViewById(R.id.scrollRooms);
        if(searchedBefore == 1) {
            lm.removeAllViews();
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                600, ViewGroup.LayoutParams.WRAP_CONTENT);

        try {
            Statement stmt = conn.createStatement();
            ResultSet reset = stmt.executeQuery(searchQuery);
            searchedBefore = 1;
            while(reset.next())
            {
                String H_Name = reset.getString(5);
                String Capacity = reset.getString(2);
                String Rating = reset.getString(1);
                String Price = reset.getString(3);
                // Create LinearLayout
                LinearLayout ll = new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);

                // Create TextView
                TextView name = new TextView(this);
                name.setText(H_Name);
                name.setTextAppearance(this, android.R.style.TextAppearance_Medium);
                ll.addView(name);

                TextView blank = new TextView(this);
                blank.setText(Space);
                ll.addView(blank);

                TextView blank1 = new TextView(this);
                blank1.setText(Space);

                TextView price = new TextView(this);
                price.setTextAppearance(this, android.R.style.TextAppearance_Medium);
                price.setText(Pr);
                ll.addView(price);

                TextView priceValue = new TextView(this);
                priceValue.setText(Price);
                ll.addView(priceValue);

                TextView blank2 = new TextView(this);
                blank2.setText(Space);
                ll.addView(blank2);

                TextView cap = new TextView(this);
                cap.setTextAppearance(this, android.R.style.TextAppearance_Medium);
                cap.setText(Cap);
                ll.addView(cap);

                // Create TextView
                TextView capacity = new TextView(this);
                capacity.setText(Capacity);
                ll.addView(capacity);
                ll.addView(blank1);

                TextView rat = new TextView(this);
                rat.setTextAppearance(this, android.R.style.TextAppearance_Medium);
                rat.setText(Rat);
                ll.addView(rat);

                TextView rating = new TextView(this);
                rating.setText(Rating);
                ll.addView(rating);

                LinearLayout llm = new LinearLayout(this);
                llm.setOrientation(LinearLayout.HORIZONTAL);

                // Create Button
                final Button btn = new Button(this);
                // Give button an ID
                btn.setId(j+1);
                btn.setText(Search);
                // set the layoutParams on the button
                btn.setLayoutParams(params);


                final int index = j;
                // Set click listener for button
               /* btn.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        Intent searchRooms = new Intent(BrowseRooms.this, SearchRooms.class);
                        startActivity(searchRooms);
                    }
                });

                btn1.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        Intent browseRooms = new Intent(BrowseRooms.this, BrowseRooms.class);
                        startActivity(browseRooms);
                    }
                });*/

                //Add button to LinearLayout
                llm.addView(btn);
                //Add button to LinearLayout defined in XML
                lm.addView(ll);
                lm.addView(llm);
                j++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void onButtonClickSearchPrice(View v){
        final EditText priceEdit = (EditText) findViewById(R.id.editText11);
        String priceString = priceEdit.getText().toString();
        Search = "Book Room";
        Space = "  ";
        Cap = "Capacity: ";
        Rat = "Rating: ";
        Pr = "| Price: ";
        searchQuery = "SELECT * FROM DB_A2EB9D_471Hotels.dbo.Rooms WHERE Price = '"+priceString+"';";
        final LinearLayout lm = (LinearLayout) findViewById(R.id.scrollRooms);
        if(searchedBefore == 1) {
            lm.removeAllViews();
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                600, ViewGroup.LayoutParams.WRAP_CONTENT);

        try {
            Statement stmt = conn.createStatement();
            ResultSet reset = stmt.executeQuery(searchQuery);
            searchedBefore = 1;
            while(reset.next())
            {
                String H_Name = reset.getString(5);
                String Capacity = reset.getString(2);
                String Rating = reset.getString(1);
                String Price = reset.getString(3);
                // Create LinearLayout
                LinearLayout ll = new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);

                // Create TextView
                TextView name = new TextView(this);
                name.setText(H_Name);
                name.setTextAppearance(this, android.R.style.TextAppearance_Medium);
                ll.addView(name);

                TextView blank = new TextView(this);
                blank.setText(Space);
                ll.addView(blank);

                TextView blank1 = new TextView(this);
                blank1.setText(Space);

                TextView price = new TextView(this);
                price.setTextAppearance(this, android.R.style.TextAppearance_Medium);
                price.setText(Pr);
                ll.addView(price);

                TextView priceValue = new TextView(this);
                priceValue.setText(Price);
                ll.addView(priceValue);

                TextView blank2 = new TextView(this);
                blank2.setText(Space);
                ll.addView(blank2);

                TextView cap = new TextView(this);
                cap.setTextAppearance(this, android.R.style.TextAppearance_Medium);
                cap.setText(Cap);
                ll.addView(cap);

                // Create TextView
                TextView capacity = new TextView(this);
                capacity.setText(Capacity);
                ll.addView(capacity);
                ll.addView(blank1);

                TextView rat = new TextView(this);
                rat.setTextAppearance(this, android.R.style.TextAppearance_Medium);
                rat.setText(Rat);
                ll.addView(rat);

                TextView rating = new TextView(this);
                rating.setText(Rating);
                ll.addView(rating);

                LinearLayout llm = new LinearLayout(this);
                llm.setOrientation(LinearLayout.HORIZONTAL);

                // Create Button
                final Button btn = new Button(this);
                // Give button an ID
                btn.setId(j+1);
                btn.setText(Search);
                // set the layoutParams on the button
                btn.setLayoutParams(params);


                final int index = j;
                // Set click listener for button
               /* btn.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        Intent searchRooms = new Intent(BrowseRooms.this, SearchRooms.class);
                        startActivity(searchRooms);
                    }
                });

                btn1.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        Intent browseRooms = new Intent(BrowseRooms.this, BrowseRooms.class);
                        startActivity(browseRooms);
                    }
                });*/

                //Add button to LinearLayout
                llm.addView(btn);
                //Add button to LinearLayout defined in XML
                lm.addView(ll);
                lm.addView(llm);
                j++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
