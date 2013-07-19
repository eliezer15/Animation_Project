package collection;
import java.util.ArrayList;

public class TableClass implements Table{

	ArrayList<Object> keys;
	public ArrayList<Object> values;
	
	public TableClass(){
		keys = new ArrayList<Object>();
	    values = new ArrayList<Object>();
		
	}	
	public void put (Object key, Object val) {
		
		if (key == null || val == null){
			return;
		}
		
		if (keys.contains(key)){
			values.remove(keys.indexOf(key));
			values.add(keys.indexOf(key), val);
			
		} 
		
		else {	
			keys.add(key);
			values.add(val);
		}	
	}	
	public Object get (Object key){
		
		if (keys.contains(key)){		
			return values.get(keys.indexOf(key));
		}
		
		else {
			return null;
		}
	}
	
}
