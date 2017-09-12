package atsea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import atsea.model.AppInfo;
import atsea.service.AppInfoService;

@Controller
public class HealthController {

	
	@Autowired
	AppInfoService appInfoService;
	
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity<String> getHealth() {
    	
    	AppInfo dbInfo = appInfoService.getLabel("DB");
    	if (dbInfo != null) {
    		return new ResponseEntity<String>("OK", HttpStatus.OK);
    	} else {
    		return new ResponseEntity<String>("Timeout", HttpStatus.REQUEST_TIMEOUT);
    		
    	}
    	
    }

}