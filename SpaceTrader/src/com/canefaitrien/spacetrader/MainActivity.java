package com.canefaitrien.spacetrader;

import com.canefaitrien.spacetrader.utils.AbstractActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AbstractActivity {

	Button button;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void addListenerOnButton() {
    	final Context context = this;
    	
    	button = (Button) findViewById(R.id.newGame);
    	
    	button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(context, ConfigurationActivity.class);
    			startActivity(intent);
				
			}
		});
    }
}
