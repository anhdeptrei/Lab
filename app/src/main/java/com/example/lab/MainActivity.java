package com.example.lab;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    protected Button btnAdd;
    protected EditText txtName;
    protected EditText txtPhoneNumber;
    protected ListView lstPerson;
    protected ArrayAdapter adapter;
    protected ArrayList listPerson;
    protected ArrayList listQue;
    protected RadioButton nam;
    protected RadioButton nu;

    protected Spinner que;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName=findViewById(R.id.editText);
        txtPhoneNumber=findViewById(R.id.editText2);
        btnAdd = findViewById(R.id.button);
        lstPerson = findViewById(R.id.listView);
        nam= findViewById(R.id.nam);
        nu = findViewById(R.id.nu);
        que = findViewById(R.id.spinner);

        listQue = new ArrayList();
        listQue.add("Ha Noi");
        listQue.add("Nam Dinh");
        listQue.add("Ha Nam");
        adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,listQue);
        que.setAdapter(adapter);

        listPerson = new ArrayList();
        listPerson.add("Nguyễn Văn An-Nam-0963113494-Hà Nội");
        listPerson.add("Trần Thị Bích-Nữ-0963113494-Nam Định");
        listPerson.add("Mai Văn Chiến-Nam-0963113494-Hà Nam");

        adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,listPerson);

        lstPerson.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nam.isChecked()){
                    listPerson.add(txtName.getText().toString()+" nam "+txtPhoneNumber.getText().toString()+" "+que.getSelectedItem().toString());
                    adapter.notifyDataSetChanged();
                }
                else if(nu.isChecked()){
                    listPerson.add(txtName.getText().toString()+" nu "+txtPhoneNumber.getText().toString()+" "+que.getSelectedItem().toString());
                    adapter.notifyDataSetChanged();
                }
            }
        });
        txtPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if(input.length()!=10 ||!TextUtils.isDigitsOnly(input)){
                    txtPhoneNumber.setError("chi duoc nhap 10 chu so lien nhau");
                }else{
                    txtPhoneNumber.setError(null);
                }
            }
        });


    }
}