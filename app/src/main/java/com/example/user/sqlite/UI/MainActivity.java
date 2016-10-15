package com.example.user.sqlite.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.sqlite.DB.Db;
import com.example.user.sqlite.Model.Person;
import com.example.user.sqlite.R;
import com.example.user.sqlite.UI.Adapter.AdapterRecyclerView;

public class MainActivity extends AppCompatActivity implements  OnClickListener {
    EditText edittextId;
    EditText edittextName;
    EditText edittextSurname;
    EditText edittextAge;
    Button btnSelectAll;
    Button btnSelectOne;
    Button btnPut;
    Button btnDeleteAll;
    Button btnDeleteOne;
    Button btnUpddate;
    Db db;

    RecyclerView rv;
    AdapterRecyclerView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new Db(this);

        edittextId=(EditText)findViewById(R.id.textId);
        edittextName=(EditText)findViewById(R.id.textName);
        edittextSurname=(EditText)findViewById(R.id.textSurName);
        edittextAge=(EditText)findViewById(R.id.textAge);

        rv=(RecyclerView)findViewById(R.id.recyclertview);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        btnSelectAll=(Button)findViewById(R.id.buttonSelectAll);
        btnSelectAll.setOnClickListener(this);

        btnSelectOne=(Button)findViewById(R.id.buttonSelectOne);
        btnSelectOne.setOnClickListener(this);

        btnPut=(Button)findViewById(R.id.buttonPut);
        btnPut.setOnClickListener(this);

        btnDeleteAll=(Button)findViewById(R.id.buttonDeleteAll);
        btnDeleteAll.setOnClickListener(this);

        btnDeleteOne=(Button)findViewById(R.id.buttonDeleteOne);
        btnDeleteOne.setOnClickListener(this);

        btnUpddate=(Button)findViewById(R.id.buttonUpdate);
        btnUpddate.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        int id=Integer.parseInt( edittextId.getText().toString());
        String name =  edittextName.getText().toString();
        String surname =  edittextSurname.getText().toString();
        int age = Integer.parseInt( edittextAge.getText().toString());

        switch (v.getId())
        {
            case R.id.buttonSelectAll:
                adapter=new AdapterRecyclerView(db.getAllPersons(), this);
                rv.setAdapter(adapter);
                break;

            case R.id.buttonSelectOne:
                adapter=new AdapterRecyclerView(db.getPerson(id), this);
                rv.setAdapter(adapter);
                break;

            case R.id.buttonPut:
                db.addPerson(new Person(id,name,surname,age));
                break;

            case R.id.buttonDeleteAll:
                db.deleteAllPerson();
                break;

            case R.id.buttonDeleteOne:
                db.deletePerson(id);
                break;

            case R.id.buttonUpdate:
                db.updatePerson(id,name,surname,age);
                break;
        }
    }
}
