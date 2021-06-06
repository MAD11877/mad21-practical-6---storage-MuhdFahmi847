package sg.edu.np.practical2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG = "List Activity";
    private ListAdapter.RecyclerViewClickListener listener;

    ArrayList<User> usersList = new ArrayList<>();
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        /*ImageView imageView = findViewById(R.id.imageView2);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ClickPic();
                }
            });*/

        usersList = dbHandler.getUsers();
        /*for (int i = 0; i < 20; i++) {
            if (i % 2 == 0){
                User userObj = new User(R.drawable.androidicon, "Name" + String.valueOf(genRanInt()), "Description" + String.valueOf(genRanInt()), false);
                usersList.add(userObj);
            }
            else{
                User userObj = new User(R.drawable.androidicon, "Name" + String.valueOf(genRanInt()), "Description" + String.valueOf(genRanInt()), true);
                usersList.add(userObj);
            }
        }*/
        setOnClickListener();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        ListAdapter mAdapter = new ListAdapter(usersList, listener);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);




    }

    private void setOnClickListener() {
        listener = new ListAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                ClickPic(position);
                /*Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("username", usersList.get(position).getMyText1());
                startActivity(intent);*/
            }
        };
    }

    protected void onStart() {
        super.onStart();
        Log.v(TAG, "On Start!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "On Resume!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "On Pause!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "On Stop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "On Destroy!");
    }

    private int genRanInt(){
        Random ran = new Random();
        int value = ran.nextInt(1000000000);
        return value;
    }

    private void ClickPic(int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage(usersList.get(position).getName()).setCancelable(false);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /*Intent passNum = new Intent(ListActivity.this, MainActivity.class);
                passNum.putExtra("number", genRanInt());
                startActivity(passNum);*/
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("username", usersList.get(position).getName());
                intent.putExtra("desc", usersList.get(position).getDescription());
                startActivity(intent);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}