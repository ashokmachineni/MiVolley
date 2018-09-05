package com.example.ashokmachineni.mivolley;

import android.app.Application;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import java.util.HashMap;
import java.util.Map;

public class App extends Application {
    public void onCreate(){
        super.onCreate();
        final FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Map<String,Object> deaultValue = new HashMap<>();
        deaultValue.put(UpdateHelper.KEY_UPDATE_ENABLE,false);
        deaultValue.put(UpdateHelper.KEY_UPDATE_VERSION,1.0);
        deaultValue.put(UpdateHelper.KEY_UPDATE_URL,"youtube.com");
        firebaseRemoteConfig.setDefaults(deaultValue);
        firebaseRemoteConfig.fetch(5)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            firebaseRemoteConfig.activateFetched();

                        }
                    }
                });
    }
}
