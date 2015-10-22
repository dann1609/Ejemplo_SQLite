package com.ingdanielpadilla.ejemplo_sqlite;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SubmitActivity extends AppCompatActivity {

    EditText mInputId,mInputName,mImputLastName;
    StudentDAO mStudentDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        mInputId = (EditText) findViewById(R.id.sId);
        mInputName=(EditText) findViewById(R.id.sName);
        mImputLastName=(EditText) findViewById(R.id.sLastname);
        mStudentDAO=new StudentDAO(getApplicationContext());
        Log.d("sql",UniversityDBHelper.SQL_CREATE_ENTIRES);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_submit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void submit(View view) {
        String id="er";
        boolean isId = mInputId.getText().toString().isEmpty();
        boolean isName= mInputName.getText().toString().isEmpty();
        boolean isLastName= mImputLastName.getText().toString().isEmpty();
        if (isId||isName||isLastName){
            Snackbar.make(view,"Uno o mas campos estan vacios",Snackbar.LENGTH_SHORT)
                    .show();
        }else{
            mStudentDAO.addEntry(mInputId.getText().toString(),mInputName.getText().toString(),mImputLastName.getText().toString());
        }

    }
}
