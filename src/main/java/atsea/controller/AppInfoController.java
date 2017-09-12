package atsea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import atsea.model.AppInfo;
import atsea.service.AppInfoService;

@RestController
@RequestMapping("/appInfo")
public class AppInfoController {
	
	@Autowired
	AppInfoService appInfoService;
	
	@RequestMapping(value = "/labels/", method = RequestMethod.GET)
	public ResponseEntity<List<AppInfo>> listAllLabels() {
		List<AppInfo> labels = appInfoService.getAllAppInfoLabels();
		if (labels.isEmpty()) {
			return new ResponseEntity<List<AppInfo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AppInfo>>(labels, HttpStatus.OK);
	}
}
