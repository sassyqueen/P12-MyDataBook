package democooldrawer.android.myapplicationdev.com.p12_mydatabook;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AboutUsActivity extends AppCompatActivity {

    ActionBar ab;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        iv = (ImageView)findViewById(R.id.imageView);
        String imageUrl = "http://68.media.tumblr.com/6961bf4827c1626518e156cd8df6fe62/tumblr_otq1x9z3EK1roqv59o1_500.png";
        Picasso.with(AboutUsActivity.this).load(imageUrl).into(iv);



    }
}
