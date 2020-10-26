package org.techtown.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;

import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    private List<String> friends = Arrays.asList("박현진", "남승경", "황지원");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button friend1 = findViewById(R.id.friend1);
        Button friend2 = findViewById(R.id.friend2);
        Button friend3 = findViewById(R.id.friend3);
        friend1.setText(friends.get(0));
        friend2.setText(friends.get(1));
        friend3.setText(friends.get(2));
        friend1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent friend_info =new Intent(MainActivity.this,friend_info.class);
                startActivity(friend_info);
            }
        });

        Button my_info = findViewById(R.id.my_info);
        my_info.setText("김민령");
        my_info.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mine=new Intent(MainActivity.this,mine.class);
                startActivity(mine);
            }
        });

        SearchView search_friend = findViewById(R.id.search_friend);

        search_friend.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                // 디비에 친구 이름이 있으면 친구를 밑에 화면에 return
                // 없으면 원하는 친구가 없다고 return
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return true;
            }
        });
    }
}