package commandDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	List<Extractor> extractorList = new ArrayList<Extractor>();
	
	public void addOption(Extractor ext) {
		extractorList.add(ext);
	}
	
	public void executeFlow() {
		for(Extractor extractor : extractorList) {
			extractor.begin();
			extractor.execute();
			extractor.end();
		}
		extractorList.clear();
	}

}
