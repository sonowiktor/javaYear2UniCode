package model;


import java.util.Iterator;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Register implements Iterable<Name> {

	//Fields
	private ObservableList<Name> list;
	private ListProperty<Name> lp;

	//constructors
	public Register() {
		this.list = FXCollections.observableArrayList();
		lp = new SimpleListProperty<>(list);
	}

	//Methods
	
	//binding this with another observable list in the view
	public void bindContentBidirectional(ObservableList<Name> otherList) {
		lp.bindContentBidirectional(otherList);
	}

	public void add(Name e) {
		list.add(e);
	}

	public void remove(int i) {
		list.remove(i);
	}

	public boolean remove(Name e) {
		return list.remove(e);
	}

	public Name get(int index) {
		return list.get(index);
	}

	public int size() {
		return list.size();
	}

	public boolean isRegisterEmpty() {
		return list.isEmpty();
	}
	
	public void clearRegister() {
		list.clear();
	}

	public boolean contains(Name n) {
		return list.contains(n);
	}

	@Override
	public String toString() {
		return "Register:[list=" + list + "]";
	}

	@Override
	public Iterator<Name> iterator() {
		return list.iterator();
	}
}
