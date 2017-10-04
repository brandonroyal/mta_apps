package atsea.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import atsea.util.CustomErrorType;

import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;


@RestController
@RequestMapping("/utility/")
public class UtilityController {
	
	public static final Logger logger = LoggerFactory.getLogger(UtilityController.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// -----------------------Container Id -------------------------------------
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/containerid/", method = RequestMethod.GET)
	public ResponseEntity<?> containerId() {
		final InetAddress localHost;
		JSONObject containerId = new JSONObject();
		
		try {
			localHost = InetAddress.getLocalHost();
			containerId.put("host",localHost.getHostName());
			containerId.put("ip", localHost.getHostAddress());
		} catch (UnknownHostException e) {
			logger.warn("An exception occurred while trying to determine the host and IP address: {}", e);
			return new ResponseEntity<Object>(new CustomErrorType("Container Id not found."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<JSONObject>(containerId, HttpStatus.OK);
		
	}
	

}