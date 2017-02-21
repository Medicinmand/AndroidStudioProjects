package mwkn.ucn.dk.autocompletewithdropdown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.colorsRes));
        //reference the autoCompleteTextView
        AutoCompleteTextView text = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        text.setAdapter(adapter);
    }
}
