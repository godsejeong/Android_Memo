package memo.com.androidmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {
    TextView title,contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        title = findViewById(R.id.addTitle);
        contents = findViewById(R.id.addContents);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menuSend:
                Intent intent = new Intent();
                Log.e("title",title.getText().toString());
                Log.e("contents",contents.getText().toString());
                intent.putExtra("title",title.getText().toString());
                intent.putExtra("contents",contents.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
