package memo.com.androidmemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    ListAdapter adapter;
    ListView listview;
    ArrayList<Data> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.mainFab);
        listview = findViewById(R.id.mainList);
        loadData();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivityForResult(intent,100);
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ReadActivity.class);
                intent.putExtra("title",items.get(i).getTitle());
                intent.putExtra("contents",items.get(i).getContents());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == 100){
                String title = data.getStringExtra("title");
                String contents = data.getStringExtra("contents");

                items.add(new Data(title,contents));
                adapter = new ListAdapter(items,this);
                listview.setAdapter(adapter);
                saveData();
            }
        }
    }

    void loadData() {
        Gson gson = new Gson();
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        String json = pref.getString("save", "");
        ArrayList<Data> shareditems;
        shareditems = gson.fromJson(json, new TypeToken<ArrayList<Data>>(){}.getType());
        if(shareditems != null)items.addAll(shareditems);
    }


    void saveData() { //items 안의 내용이 저장됨
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        String json = new Gson().toJson(items);
        editor.putString("save", json);
        Log.d("asdf",json);
        editor.commit();
    }

}
