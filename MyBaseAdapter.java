package familiard.xmpp.main.testapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import familiard.xmpp.main.testapplication.util.BaseListAdapter;

/**
 * Created by jishuaipeng on 2016/3/28.
 */
public class MyBaseAdapter extends BaseListAdapter<Item> {
    public MyBaseAdapter(Context context, List<Item> values,ListView lv) {
        super(context, values);
        mListView = lv;
    }

    @Override
    protected View getItemView(View convertView, int position) {
        ViewHolder viewHolder = null;
        if(convertView==null){
            viewHolder = new ViewHolder(getContext());
            convertView = viewHolder.view;
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.setPost(getItem(position));
        return convertView;
    }

    public void updateView(int itemIndex) {
        //得到第一个可显示控件的位置，
        int visiblePosition = mListView.getFirstVisiblePosition();
        //只有当要更新的view在可见的位置时才更新，不可见时，跳过不更新
        if (itemIndex - visiblePosition >= 0) {
            //得到要更新的item的view
            View view = mListView.getChildAt(itemIndex - visiblePosition);
            //从view中取得holder
            ViewHolder  viewHolder = (ViewHolder) view.getTag();
            viewHolder.setPost(getItem(itemIndex));
            Toast.makeText(getContext(),"ooo",Toast.LENGTH_SHORT).show();
        }
    }

    public static class ViewHolder extends LinearLayout implements View.OnClickListener{

        private TextView text1;
        protected View view;

        public ViewHolder(Context context) {
            this(context,null);
        }

        public ViewHolder(Context context, AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public ViewHolder(Context context, AttributeSet attrs, int defStyleAttr) {
            this(context, attrs, defStyleAttr, 0);
        }

        public ViewHolder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
            view = inflate(context, R.layout.post_view, null);
            text1 = (TextView) view.findViewById(R.id.mytext);
//            text1.setOnClickListener(this);
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

            Toast.makeText(getContext(),"go",Toast.LENGTH_SHORT).show();
        }
    }
}
