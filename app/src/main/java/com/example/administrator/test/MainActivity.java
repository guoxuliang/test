package com.example.administrator.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import de.greenrobot.event.EventBus;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv;
    EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        btn = (Button) findViewById(R.id.btn_try);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                startActivity(intent);
            }
        });
    }
    /**
     * onEventMainThread:如果使用onEventMainThread作为订阅函数，那么不论事件是在哪个线程中发布出来的，
     * onEventMainThread都会在UI线程中执行，接收事件就会在UI线程中运行，这个在Android中是非常有用的，
     * 因为在android中只能在UI线程中跟新UI，所以在onEvnetMainThread方法中是不能执行耗时操作的。
     *  //SecondEvent接收函数一
     */
    public void onEventMainThread(SecondEvent event) {

        Log.d("harvic", "onEventMainThread收到了消息：" + event.getMsg());
        Toast.makeText(this,"==onEventMainThread收到了消息："+event.getMsg(),Toast.LENGTH_SHORT).show();
    }

    /**
     * onEventBackground:如果使用onEventBackgrond作为订阅函数，那么如果事件是在UI线程中发布出来的，
     * 那么onEventBackground就会在子线程中运行，如果事件本来就是子线程中发布出来的，
     * 那么onEventBackground函数直接在该子线程中执行。
     *  //SecondEvent接收函数二
     */

    public void onEventBackgroundThread(SecondEvent event){
        Log.d("harvic", "onEventBackground收到了消息：" + event.getMsg());
        Toast.makeText(this,"==onEventBackground收到了消息："+event.getMsg(),Toast.LENGTH_SHORT).show();
    }

    /**
     * onEventAsync：使用这个函数作为订阅函数，那么无论事件在哪个线程发布，都会创建新的子线程在执行onEventAsync.
     */
    //SecondEvent接收函数三
    public void onEventAsync(SecondEvent event){
        Log.d("harvic", "onEventAsync收到了消息：" + event.getMsg());
        Toast.makeText(this,"==onEventAsync收到了消息："+event.getMsg(),Toast.LENGTH_SHORT).show();
    }

    /**
     * onEvent:如果使用onEvent作为订阅函数，那么该事件在哪个线程发布出来的，onEvent就会在这个线程中运行，也就是说发布事件和接收事件线程在同一个线程。
     * 使用这个方法时，在onEvent方法中不能执行耗时操作，如果执行耗时操作容易导致事件分发延迟。
     */
    public void onEvent(ThirdEvent event) {
        Log.d("harvic", "OnEvent收到了消息：" + event.getMsg());
        Toast.makeText(this,"==OnEvent收到了消息："+event.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}