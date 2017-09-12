package atsea.service;

import java.util.List;

import atsea.model.AppInfo;

public interface AppInfoService {
	List<AppInfo> getAllAppInfoLabels();
	
	AppInfo getLabel(String label);
}
