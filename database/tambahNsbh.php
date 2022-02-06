<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$nama = $_POST['nama'];
		$alamat = $_POST['alamat'];
		$no_rekening = $_POST['no_rekening'];
		$no_telephone = $_POST['no_telephone'];
		$pekerjaan = $_POST['pekerjaan'];
		$saldo = $_POST['saldo'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_nasabah (nama, alamat, no_rekening, no_telephone, pekerjaan, saldo) VALUES ('$nama','$alamat','$no_rekening','$no_telephone','$pekerjaan','$saldo')";
		
		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Pegawai';
		}else{
			echo 'Gagal Menambahkan Pegawai';
		}
		
		mysqli_close($con);
	}
?>