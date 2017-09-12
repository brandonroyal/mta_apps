package atsea.repositories;
//
//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import atsea.model.AppInfo;

@Repository
public interface AppInfoRepository extends JpaRepository<AppInfo, String>{
	
//	AppInfo findOne(String label);
//	public List<AppInfo> findAll();
}
