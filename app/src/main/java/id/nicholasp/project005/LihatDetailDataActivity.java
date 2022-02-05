package id.nicholasp.project005;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class LihatDetailDataActivity extends AppCompatActivity {
    EditText edit_id, edit_nama, edit_alamat, edit_no_rekening, edit_no_telephone, edit_pekerjaan, edit_saldo;
    String id;
    Button button_update;
    Button button_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_detail_data);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Data Nasabah");

        edit_id = findViewById(R.id.edit_id);
        edit_nama = findViewById(R.id.edit_nama);
        edit_alamat = findViewById(R.id.edit_alamat);
        edit_no_rekening = findViewById(R.id.edit_no_rekening);
        edit_no_telephone = findViewById(R.id.edit_no_telephone);
        edit_pekerjaan = findViewById(R.id.edit_pekerjaan);
        edit_saldo = findViewById(R.id.edit_saldo);

        //menerima intent dari class
        Intent receiveIntent = getIntent();
        id = receiveIntent.getStringExtra(Konfigurasi.NSBH_ID);
        edit_id.setText(id);

        //button
        button_update = findViewById(R.id.btn_update);
        button_delete = findViewById(R.id.btn_delete);

        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNasabah();
            }
        });
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LihatDetailDataActivity.this);
                alertDialogBuilder.setMessage("Yakin Delete?");

                alertDialogBuilder.setPositiveButton("Ya",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deleteNasabah();
                            }
                        });

                alertDialogBuilder.setNegativeButton("Tidak",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        //mengambil data JSON
        getJSON();
    }

    private void deleteNasabah() {
        class DeleteNasabah extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatDetailDataActivity.this,
                        "Deleting Data...", "Harap menunggu...",
                        false, false);
            }

            @Override
            protected String doInBackground(Void... params) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponseParam(Konfigurasi.URL_DELETE, id);
                return result;
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
                displayDetailData(message);
            }
        }
        DeleteNasabah de = new DeleteNasabah();
        de.execute();
        startActivity(new Intent(LihatDetailDataActivity.this, LihatDataActivity.class));
    }

    private void updateNasabah() {
        final String nama = edit_nama.getText().toString().trim();
        final String alamat = edit_alamat.getText().toString().trim();
        final String no_rekening = edit_no_rekening.getText().toString().trim();
        final String no_telephone = edit_no_telephone.getText().toString().trim();
        final String pekerjaan = edit_pekerjaan.getText().toString().trim();
        final String saldo = edit_saldo.getText().toString().trim();

        class UpdateNasabah extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatDetailDataActivity.this,
                        "Updating Data...", "Harap menunggu...",
                        false, false);
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(Konfigurasi.KEY_NSBH_ID, id);
                hashMap.put(Konfigurasi.KEY_NSBH_NAMA, nama);
                hashMap.put(Konfigurasi.KEY_NSBH_ALAMAT, alamat);
                hashMap.put(Konfigurasi.KEY_NSBH_NO_REKENING, no_rekening);
                hashMap.put(Konfigurasi.KEY_NSBH_NO_TELEPHONE, no_telephone);
                hashMap.put(Konfigurasi.KEY_NSBH_PEKERJAAN, pekerjaan);
                hashMap.put(Konfigurasi.KEY_NSBH_SALDO, saldo);

                HttpHandler handler = new HttpHandler();
                String result = handler.sendPostRequest(Konfigurasi.URL_UPDATE, hashMap);
                return result;
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
                displayDetailData(message);
            }
        }

        UpdateNasabah ue = new UpdateNasabah();
        ue.execute();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LihatDetailDataActivity.this);
        alertDialogBuilder.setMessage("Update lagi?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(LihatDetailDataActivity.this, LihatDataActivity.class));
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> { //inner class
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatDetailDataActivity.this,
                        "Mengambil Data", "Harap menunggu...",
                        false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponseParam(Konfigurasi.URL_GET_DETAIL, id);
                return result;
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
                displayDetailData(message);
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void displayDetailData(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
            JSONObject object = result.getJSONObject(0);

            String nama = object.getString(Konfigurasi.TAG_JSON_NAMA);
            String alamat = object.getString(Konfigurasi.TAG_JSON_ALAMAT);
            String no_rekening = object.getString(Konfigurasi.TAG_JSON_NO_REKENING);
            String no_telephone = object.getString(Konfigurasi.TAG_JSON_NO_TELEPHONE);
            String pekerjaan = object.getString(Konfigurasi.TAG_JSON_PEKERJAAN);
            String saldo = object.getString(Konfigurasi.TAG_JSON_SALDO);

            edit_nama.setText(nama);
            edit_alamat.setText(alamat);
            edit_no_rekening.setText(no_rekening);
            edit_no_telephone.setText(no_telephone);
            edit_pekerjaan.setText(pekerjaan);
            edit_saldo.setText(saldo);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}