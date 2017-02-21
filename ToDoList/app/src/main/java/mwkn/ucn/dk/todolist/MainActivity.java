package mwkn.ucn.dk.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String arrayList_State_KEY = "arrayList_State_KEY";
    private ArrayList<String> todoList = new ArrayList<>();
    ListView listView;
    EditText txt;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState !=null && savedInstanceState.containsKey(arrayList_State_KEY))
            todoList = savedInstanceState.getStringArrayList(arrayList_State_KEY);
        txt = (EditText) findViewById(R.id.editText);
        Button btn_todo = (Button) findViewById(R.id.toDo);
        listView = (ListView) findViewById(R.id.listView);

        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, todoList);
        listView.setAdapter(aa);

        btn_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = txt.getText().toString();
                todoList.add(input);
                aa.notifyDataSetChanged();
                txt.setText("");
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState){
        saveInstanceState.putStringArrayList(arrayList_State_KEY,todoList);
        super.onSaveInstanceState(saveInstanceState);
    }
}
