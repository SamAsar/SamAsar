package dev.labsDotinc10gmailDotcom;

import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText firstname, lastname, contact, dob;

    Button btnInsert, btnUpdate, btnDelete, btnView;

    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname =(EditText) findViewById(R.id.firstname);
        lastname =(EditText) findViewById(R.id.lastname);
        contact=(EditText) findViewById(R.id.contact);
        dob = (EditText) findViewById(R.id.dob);

        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnUpdate =(Button) findViewById(R.id.btnUpdate);
        btnDelete =(Button) findViewById(R.id.btnDelete);

        btnView =(Button) findViewById(R.id.btnView);

        DB = new DBHelper(this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String first = firstname.getText().toString();
                String last = lastname.getText().toString();
                String contactNumber = contact.getText().toString();
                String dateofbirth = dob.getText().toString();

                Boolean checkInsertedData = DB.insertData(first,last,contactNumber,dateofbirth);
                if (checkInsertedData==true)
                Toast.makeText(MainActivity.this, "new entry successfully added", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(MainActivity.this, "new entry failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String first = firstname.getText().toString();
                String last = lastname.getText().toString();
                String contactNumber = contact.getText().toString();
                String dateofbirth = dob.getText().toString();

                Boolean checkUpdatedData = DB.updateData(first,last,contactNumber,dateofbirth);
                if (checkUpdatedData==true)
                Toast.makeText(MainActivity.this, "entry successfully added", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String first = firstname.getText().toString();

                Boolean checkUpdatedData = DB.deleteData(first);
                if (checkUpdatedData==true)
                    Toast.makeText(MainActivity.this, "entry successfully deleted", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(MainActivity.this, "entry not deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}