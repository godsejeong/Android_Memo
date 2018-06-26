package memo.com.androidmemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    ArrayList<Data> items;
    LayoutInflater inflater;
    public ListAdapter(ArrayList<Data> items,Context context){
        this.items = items;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = inflater.inflate(R.layout.list_item,viewGroup,false);
        }

        Data listItem = items.get(i);

        TextView title =  view.findViewById(R.id.itemTitle);
        title.setText(listItem.getTitle());

        TextView contents = view.findViewById(R.id.itemContents);
        contents.setText(listItem.getContents());

        return view;
    }
}
