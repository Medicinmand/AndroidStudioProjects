package mwkn.ucn.dk.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import java.util.List;
import java.util.Random;
import android.app.ListActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    private ToDoDataSource datasource;
    private ListView listView;
    private EditText editText;
    private ArrayAdapter arrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);
        Button btn_todo = (Button) findViewById(R.id.toDo);

        datasource = new ToDoDataSource(this);
        datasource.open();

        //build arraylist from database.
        List<ToDoTask> values = datasource.getAllToDoTasks();

        // Use the ArrayAdapter to show the elements in a ListView
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
        listView.setAdapter(arrayAdapter);

        btn_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter.add(datasource.createToDoTask(getEditText()));
                arrayAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        datasource.open();
    }

    @Override
    protected void onStop() {
        super.onStop();
        datasource.close();
    }

    private String getEditText(){
        return editText.getText().toString();
    }
}
