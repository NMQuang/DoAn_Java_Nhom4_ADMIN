package foodGroup4Quanly.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import foodGroup4Quanly.entity.Chinhanhmon;
import foodGroup4Quanly.service.ChiNhanhMonService;

@RestController
@RequestMapping("/api/chinhanhmon")
public class ChiNhanhMonApi {

	@Autowired
	private ChiNhanhMonService chiNhanhMonService;
	
	@RequestMapping(value="/{idBranch}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity get(@PathVariable int idBranch){
		List<Chinhanhmon> cnmList = chiNhanhMonService.getListChiNhanhMonByChiNhanh(idBranch);
		return new ResponseEntity(cnmList, HttpStatus.OK );
	}
}
