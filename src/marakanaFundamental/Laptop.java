package marakanaFundamental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Laptop {

	private final String model;
	private final int size;
	private final List<Storage> storage;
	private final Set<String> applications=new HashSet<String>();
	boolean on;

	public Laptop(String model, int size, List<Storage> storage) {
		super();
		this.model = model;
		this.size = size;
		// a new storage reference so that it is different from the one we have
		// called from main defensive copy 
		this.storage = new ArrayList<Storage>(storage);
		
		//OR
		
		//this.applications=new HashSet<String>();
	}

	public Set<String> getApplications() {
		//so that no one can go this getApplication().clear() in the main
		////unmodifiable list
		return Collections.unmodifiableSet(applications);
	}
	public void installApplication(String application){
		this.applications.add(application);
	}
	
	public void uninstallApplication(String application){
		this.applications.remove(application);
	}
	

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public String getModel() {
		return model;
	}

	public int getSize() {
		return size;
	}

	public List<Storage> getStorage() {
		//unmodifiable list
		return Collections.unmodifiableList(storage);
	}

	public int totalStorage() {
		int totalSize = 0;
		for (Storage store : storage)
			totalSize += store.getSize();

		return totalSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((applications == null) ? 0 : applications.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + size;
		result = prime * result + ((storage == null) ? 0 : storage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		if (applications == null) {
			if (other.applications != null)
				return false;
		} else if (!applications.equals(other.applications))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (size != other.size)
			return false;
		if (storage == null) {
			if (other.storage != null)
				return false;
		} else if (!storage.equals(other.storage))
			return false;
		return true;
	}
	

}
