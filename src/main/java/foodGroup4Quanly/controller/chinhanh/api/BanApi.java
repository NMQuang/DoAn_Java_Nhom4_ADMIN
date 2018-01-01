package foodGroup4Quanly.controller.chinhanh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import foodGroup4Quanly.entity.Ban;
import foodGroup4Quanly.service.BanService;

//@RestController
//@RequestMapping("/chinhanh/api/ban")
public class BanApi {

	@Autowired
	private BanService banService;
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ban> getBan(@PathVariable int id){
		Ban b = banService.getInfoBan(id);
		if(b == null)
			return new ResponseEntity<Ban>( HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Ban>(b , HttpStatus.OK);
	}
}
