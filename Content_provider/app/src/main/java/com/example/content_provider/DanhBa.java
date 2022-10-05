package com.example.content_provider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.content_provider.Model.Contact;

import java.util.ArrayList;

public class DanhBa extends AppCompatActivity {

    private static final int REQUEST_CODE_ASK_PERMISSIONS = 1001;
    ListView lvDanhBa;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhBa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);
        addControls();
        showAllContactFromDevice();
    }

   private void showAllContactFromDevice(){
    //
        //thong qua Contacscontract de lay contact trong dth
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        //tra ve 1 cursor, quan ly DL contact trong dth
        Cursor cursor = getContentResolver().query(uri, null, null,null, null);
       dsDanhBa.clear();

           while(cursor.moveToNext()){
                //lay thong tin ten trong danh ba
               String contactName = ContactsContract.Contacts.DISPLAY_NAME;
                //Lay SDT trong danh ba
                String contactPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
                //lay vi tri cot trong DL
                 int vitricotName = cursor.getColumnIndex(contactName);
                int vitricotPhone = cursor.getColumnIndex(contactPhone);
                //lay DL trong cac cot
               String name = cursor.getString(vitricotName);
                 String phone = cursor.getString(vitricotPhone);
                //dua vao mang
            Contact contact = new Contact(name, phone);
            dsDanhBa.add(contact);
                adapterDanhBa.notifyDataSetChanged();
          }
       }

   // }
    private void addControls(){
        lvDanhBa = (ListView) findViewById(R.id.listViewDanhBa);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<>(DanhBa.this, android.R.layout.simple_list_item_1,dsDanhBa);
        lvDanhBa.setAdapter(adapterDanhBa);
    }
}