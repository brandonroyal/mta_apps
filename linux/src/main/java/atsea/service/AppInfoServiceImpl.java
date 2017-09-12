package atsea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atsea.model.AppInfo;
import atsea.repositories.AppInfoRepository;

@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService {
	
	@Autowired
	private AppInfoRepository appInfoRepository;

	@Override
	public List<AppInfo> getAllAppInfoLabels() {
		return appInfoRepository.findAll();
	}

	@Override
	public AppInfo getLabel(String label) {
		return appInfoRepository.findOne(label);
	}

}
