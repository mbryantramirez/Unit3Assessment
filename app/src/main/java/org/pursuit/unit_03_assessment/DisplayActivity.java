package org.pursuit.unit_03_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit_03_assessment.R;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String name = getIntent().getStringExtra(getString(R.string.name_key));
        int number = getIntent().getIntExtra(getString(R.string.number_key), 0);
        String image = getIntent().getStringExtra(getString(R.string.image_key));

        TextView nameView = findViewById(R.id.name);
        TextView numberView = findViewById(R.id.number);
        ImageView imageView = findViewById(R.id.image);

        nameView.setText(name);
        numberView.setText(String.valueOf(number));
        Picasso.get()
                .load(image)
                .into(imageView);


        /*
        * TODO: Add logic that will:
        * TODO 1. Receive values from sending intent
        * TODO 2. Create a TextView instance for the Planet Name
        * TODO 3. Create a TextView instance for the Planet Number count
        * TODO 4. Create an ImageView for the image url
        * TODO 5. Display each value in views - Strings for TextViews, and Picasso for the ImageView
        */
    }
}
