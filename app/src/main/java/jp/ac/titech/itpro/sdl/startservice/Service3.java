package jp.ac.titech.itpro.sdl.startservice;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Service3 extends IntentService {
    private final static String TAG = Service3.class.getSimpleName();
    public final static String ACTION_ANSWER = "ACTION_ANS";
    public final static String EXTRA_ANSWER = "EXTRA_ANS";
    public final static String EXTRA_MYARG = "MYARG";

    public Service3() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(ACTION_ANSWER);
        broadcastIntent.putExtra(EXTRA_ANSWER, "Answer Service3");
        sendBroadcast(broadcastIntent);
        try {
            Thread.sleep(5000); // 5 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }
}