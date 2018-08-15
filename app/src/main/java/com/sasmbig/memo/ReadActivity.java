package com.sasmbig.memo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class ReadActivity extends AppCompatActivity {
    String title,contents;
    TextView titleTv,contentsTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        titleTv = findViewById(R.id.readTitle);
        contentsTv = findViewById(R.id.readContents);

        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        contents = intent.getStringExtra("contents");

        titleTv.setText(title);
        contentsTv.setText(contents);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
