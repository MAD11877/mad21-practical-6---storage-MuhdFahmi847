package sg.edu.np.practical2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";
    /*private Integer myNum;*/

    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Intent receiveNum = getIntent();
        myNum = receiveNum.getIntExtra("number", 1);
        TextView textView = findViewById(R.id.textView);
        textView.setText("MAD " + myNum);*/

        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        String username = "Username not set";
        String desc = "Desc not set";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            username = extras.getString("username");
            desc = extras.getString("desc");
        }
        textView.setText(username);
        textView2.setText(desc);

        Button button = findViewById(R.id.button);

        User user1 = new User();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user1.isFollowed() == false) {
                    button.setText("Unfollow");
                    Log.v(TAG, "Followed");
                    user1.setFollowed(true);
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                    dbHandler.updateUser(user1);
                }
                else if (user1.isFollowed() == true) {
                    button.setText("Follow");
                    Log.v(TAG, "Unfollowed");
                    user1.setFollowed(false);
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                    dbHandler.updateUser(user1);
                }
            }
        });


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
}