package familiard.xmpp.main.testapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NDK extends Activity {
    static {
//        System.loadLibrary("MyJni");
        //导入生成的链接库文件
        }

    public native String getStringFromNative();//本地方法

    public native String getString_From_c();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        System.out.println(getStringFromNative());

        AsyncTask a = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                return null;
            }
        };
        a.cancel(true);
    }

    public void onClick(View view) {
        System.out.println(getString_From_c());
        Toast.makeText(this, getStringFromNative(),
                Toast.LENGTH_LONG).show();
    }
}
