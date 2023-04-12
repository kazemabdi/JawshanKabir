package ir.kazix.jawshankabir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyCustomAdapter myCustomAdapter;

    FloatingActionButton floatingActionButton;

    LayoutInflater inflater;
    Button buttonGoToSentence;
    EditText editTextSentenceNumber;
    Integer sentencePosition;
    AlertDialog.Builder builder;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySentence.setMySentenceArrayList();
        myCustomAdapter = new MyCustomAdapter(MySentence.getMySentenceArrayList());

        recyclerView = findViewById(R.id.activity_main_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myCustomAdapter);

        inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.my_dialog, null);
        builder = new AlertDialog.Builder(this);
        builder.setView(view);
        dialog = builder.create();

        floatingActionButton = findViewById(R.id.activity_main_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        }); // end floatingActionButton.setOnClickListener

        editTextSentenceNumber = view.findViewById(R.id.my_dialog_et);

        buttonGoToSentence = view.findViewById(R.id.my_dialog_btn);
        buttonGoToSentence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!editTextSentenceNumber.getText().toString().equals("")) {

                    sentencePosition = Integer.parseInt(editTextSentenceNumber.getText().toString());
                    if (sentencePosition >= 0 && sentencePosition <= 100) {

                        recyclerView.scrollToPosition(sentencePosition);
                        editTextSentenceNumber.setText("");
                        dialog.dismiss();
                    } else {

                        Toast.makeText(MainActivity.this, "خارج از محدوده", Toast.LENGTH_SHORT).show();
                    }
                }
            } // end onClick
        }); // end buttonGoToSentence.setOnClickListener
    } // end onCreate

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MySentence.getMySentenceArrayList().clear();
    }
}