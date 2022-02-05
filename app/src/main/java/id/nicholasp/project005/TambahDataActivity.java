package id.nicholasp.project005;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class TambahDataActivity extends AppCompatActivity {
    EditText edit_nama, edit_alamat, edit_no_rekening, edit_no_telephone, edit_pekerjaan, edit_saldo;
    Button button_tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tambah Data Nasabah");

        edit_nama = findViewById(R.id.edit_nama);
        edit_alamat = findViewById(R.id.edit_alamat);
        edit_no_rekening = findViewById(R.id.edit_no_rekening);
        edit_no_telephone = findViewById(R.id.edit_no_telephone);
        edit_pekerjaan = findViewById(R.id.edit_pekerjaan);
        edit_saldo = findViewById(R.id.edit_saldo);

        button_tambah = findViewById(R.id.btn_tambah);

        button_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambah_nasabah();
            }
        });
    }

    private void tambah_nasabah() {
        final String nama = edit_nama.getText().toString().trim();
        final String alamat = edit_alamat.getText().toString().trim();
        final String no_rekening = edit_no_rekening.getText().toString().trim();
        final String no_telephone = edit_no_telephone.getText().toString().trim();
        final String pekerjaan = edit_pekerjaan.getText().toString().trim();
        final String saldo = edit_saldo.getText().toString().trim();

        class TambahNasabah extends AsyncTask<Void, Void, String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TambahDataActivity.this,
                        "Menambah Data...", "Harap menunggu...",
                        false, false);
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(Konfigurasi.KEY_NSBH_NAMA, nama);
                hashMap.put(Konfigurasi.KEY_NSBH_ALAMAT, alamat);
                hashMap.put(Konfigurasi.KEY_NSBH_NO_REKENING, no_rekening);
                hashMap.put(Konfigurasi.KEY_NSBH_NO_TELEPHONE, no_telephone);
                hashMap.put(Konfigurasi.KEY_NSBH_PEKERJAAN, pekerjaan);
                hashMap.put(Konfigurasi.KEY_NSBH_SALDO, saldo);

                HttpHandler handler = new HttpHandler();
                String result = handler.sendPostRequest(Konfigurasi.URL_ADD, hashMap);
                return result;
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
            }
        }
        TambahNasabah tn = new TambahNasabah();
        tn.execute();
        startActivity(new Intent(TambahDataActivity.this, LihatDataActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}