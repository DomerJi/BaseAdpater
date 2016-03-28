package familiard.xmpp.main.testapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by jishuaipeng on 2016/3/27.
 */
public class MyAdapter extends BaseAdapter {
    private List<Item> list;
    private Context context;
    public MyAdapter(List<Item> list,Context context){
        this.list = list;
        this.context = context;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null) {
            postView = new PostView(context);
        }
        postView.setPost(list.get(position));
        return postView.view;
    }
    PostView postView;
    public static class PostView extends LinearLayout implements View.OnClickListener{

        private TextView text1;
        protected View view;

        public PostView(Context context) {
            this(context,null);
        }

        public PostView(Context context, AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public PostView(Context context, AttributeSet attrs, int defStyleAttr) {
            this(context, attrs, defStyleAttr, 0);
        }

        public PostView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
            view = inflate(context, R.layout.post_view, null);
            text1 = (TextView) view.findViewById(R.id.mytext);
            text1.setOnClickListener(this);
        }

        @Override
        protected void onFinishInflate() {
            super.onFinishInflate();

        }

        public void setPost(Item item){
            if(item instanceof User){
                User user = (User) item;
                text1.setText(user.getName()+" - "+user.getAge());
            }

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(),"go",Toast.LENGTH_LONG).show();
        }
    }
}
