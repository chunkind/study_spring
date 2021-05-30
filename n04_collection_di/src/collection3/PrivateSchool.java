package collection3;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrivateSchool {
	private ArrayList<String> stuNames;
	private ArrayList<Bus> busList;
	private Map<String, Bus> busMap;
	//추가...
	private Log log = LogFactory.getLog(getClass());
	
	
	public ArrayList<String> getStuNames() {
		//System.out.println("학생이름 받아옴....");
		log.info("학생 이름 받아옴....");
		return stuNames;
	}
	public void setStuNames(ArrayList<String> stuNames) {
		this.stuNames = stuNames;
	}
	public ArrayList<Bus> getBusList() {
		//System.out.println("BUs List 받아옴....");
		log.info("Bus List 받아옴....");
		return busList;
	}
	public void setBusList(ArrayList<Bus> busList) {
		this.busList = busList;
	}
	public Map<String, Bus> getBusMap() {
		//System.out.println("BusMap 받아옴....");
		log.info("BusMap 받아옴....");
		return busMap;
	}
	public void setBusMap(Map<String, Bus> busMap) {
		this.busMap = busMap;
	}		
}
