package ganesh.com.burrimage;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import ganesh.com.burrimagelib.Blurry;

public class MainActivity extends AppCompatActivity {

    boolean alreadyExecuted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!alreadyExecuted)
        {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    //Do something after 4 seconds
                    Blurry.with(MainActivity.this)
                            .radius(25)
                            .sampling(1)
                            .color(Color.argb(66, 0, 245, 245))
                            .async()
                            .capture(findViewById(R.id.right_top))
                            .into((ImageView) findViewById(R.id.right_top));


                    alreadyExecuted = true;
                }
            }, 10);
        }

    }
}
