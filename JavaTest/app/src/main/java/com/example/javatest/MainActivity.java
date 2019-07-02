package com.example.javatest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //buttonにリスナーを設置
        Button btClick = findViewById(R.id.button);
        TheListener listener = new TheListener();
        btClick.setOnClickListener(listener);

        //toListButtonにリスナーを設置
        Button toListBtClick = findViewById(R.id.toListButton);
        ToListListener toListListener = new ToListListener();
        toListBtClick.setOnClickListener(toListListener);

    }

    private class ToListListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //RecyclerViewActivityに遷移
            Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
            startActivity(intent);
        }
    }

    private class TheListener implements View.OnClickListener {
        TextView output = findViewById(R.id.textView);
        EditText input = findViewById(R.id.editText);

        @Override
        public void onClick(View view) {

            String inputStr = input.getText().toString();
//            output.setText(inputStr);

            FirebaseFirestore db = FirebaseFirestore.getInstance();
            Log.d("firebase", "インスタンス化");

//            Map<String, String> prefs = new HashMap<String, String>();
//            prefs.put("あ", inputStr);
//            db.collection("users").document().set(prefs);
//            Log.d("firebase", "書き込み");


            //CloudFirestoreから一つだけデータを得て表示させる
            DocumentReference circleName = db.collection("users").document("サークル名");
            circleName.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            Log.d("result", document.getData().toString());
                            output.setText(document.getData().toString());
                        }
                    }
                }
            });


        }

    }
}
