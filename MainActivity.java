package okhttp.bwie.com.okhttp17119;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp.bwie.com.okhttp17119.bean.MyBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class MainActivity extends AppCompatActivity {

    private ListView listView;
   Handler handler=new Handler();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
  private GoogleApiClient client2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).build();
        Request request = new Request.Builder().url("http://m.yunifang.com/yunifang/mobile/home").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String s = response.body().string();

                    MyBean bean = new Gson().fromJson(s, MyBean.class);
                    final List<MyBean.DataBean.DefaultGoodsListBean> category = bean.getData().getDefaultGoodsList();

                    /*runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });*/
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                        listView.setAdapter(new MyAdapter(category, MainActivity.this));
                        }
                  });

                }
            }
        });


    }




}
