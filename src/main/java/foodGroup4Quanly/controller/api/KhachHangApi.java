package foodGroup4Quanly.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import foodGroup4Quanly.entity.Khachhang;
import foodGroup4Quanly.service.KhachHangService;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangApi {

	@Autowired
	private KhachHangService khachHangService;
	
	@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getKhachHang(@RequestParam String sdt){
		Khachhang kh = khachHangService.get(sdt);
		if(kh != null)
			return new ResponseEntity(kh, HttpStatus.OK);
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
}
