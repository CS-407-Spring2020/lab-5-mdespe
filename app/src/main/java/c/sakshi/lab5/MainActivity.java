package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    static String usernameKey = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        if (!sharedPreferences.getString(usernameKey, "").equals("")) {
            String username = sharedPreferences.getString(usernameKey, "");
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("username", username);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void onLoginButtonClick(View view) {
        EditText uname = findViewById(R.id.nameEditText);
        String username = uname.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", username).apply();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }


}
