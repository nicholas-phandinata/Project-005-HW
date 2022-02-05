package id.nicholasp.project005;

public class Konfigurasi {
    //url dimana web API berada
    public static final String URL_GET_ALL = "http://192.168.1.8/nasabah/tampilSemuaNsbh.php";
    public static final String URL_GET_DETAIL = "http://192.168.1.8/nasabah/tampilNsbh.php?id=";
    public static final String URL_ADD = "http://192.168.1.8/nasabah/tambahNsbh_.php";
    public static final String URL_UPDATE = "http://192.168.1.8/nasabah/updateNsbh.php";
    public static final String URL_DELETE = "http://192.168.1.8/nasabah/hapusNsbh.php";

    //key and value JSON yang muncul di browser
    public static final String KEY_NSBH_ID = "id";
    public static final String KEY_NSBH_NAMA = "nama";
    public static final String KEY_NSBH_ALAMAT = "alamat";
    public static final String KEY_NSBH_NO_REKENING = "no_rekening";
    public static final String KEY_NSBH_NO_TELEPHONE = "no_telephone";
    public static final String KEY_NSBH_PEKERJAAN = "pekerjaan";
    public static final String KEY_NSBH_SALDO = "saldo";

    // flag JSON
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_JSON_ID = "id";
    public static final String TAG_JSON_NAMA = "nama";
    public static final String TAG_JSON_ALAMAT = "alamat";
    public static final String TAG_JSON_NO_REKENING = "no_rekening";
    public static final String TAG_JSON_NO_TELEPHONE = "no_telephone";
    public static final String TAG_JSON_PEKERJAAN = "pekerjaan";
    public static final String TAG_JSON_SALDO = "saldo";

    //variable ID nasabah
    public static final String NSBH_ID = "nas_id";

}
