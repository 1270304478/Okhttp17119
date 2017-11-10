package okhttp.bwie.com.okhttp17119;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import okhttp.bwie.com.okhttp17119.bean.MyBean;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/11/9 21:57
 */
public class MyAdapter extends BaseAdapter {
    List<MyBean.DataBean.DefaultGoodsListBean> list;
    Context context;

    public MyAdapter(List<MyBean.DataBean.DefaultGoodsListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;


        if (view == null) {
            view = View.inflate(context, R.layout.activity_item, null);
            holder = new ViewHolder();
            holder.tv1 = view.findViewById(R.id.tv1);
            holder.tv2 = view.findViewById(R.id.tv2);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv1.setText(list.get(i).getId() + "");

        System.out.println("ttt" + list.get(i).getId() + "");
        holder.tv2.setText(list.get(i).getGoods_name());

        return view;
    }
    static  class ViewHolder{
        TextView tv1;
        TextView tv2;
    }
}
