<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Mendapatkan Nilai Dari Variable 
		$id = $_POST['id'];
		$nama = $_POST['nama'];
		$alamat = $_POST['alamat'];
		$no_rekening = $_POST['no_rekening'];
		$no_telephone = $_POST['no_telephone'];
		$pekerjaan = $_POST['pekerjaan'];
		$saldo = $_POST['saldo'];
		
		//import file koneksi database 
		require_once('koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE tb_nasabah SET nama = '$nama', alamat = '$alamat', no_rekening = '$no_rekening', no_telephone = '$no_telephone', pekerjaan = '$pekerjaan', saldo = '$saldo' WHERE id = $id;";
		
		//Meng-update Database 
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Pegawai';
		}else{
			echo 'Gagal Update Data Pegawai';
		}
		
		mysqli_close($con);
	}
?>