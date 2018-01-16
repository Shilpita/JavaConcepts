package MVCDemo.SwingApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import MVCDemo.SwingApp.ItemController.UIView;

//This is the model class that holds the name and price of an item
//Extends the Observable class; allows addition (and deletion) of observers
//and notifies them when the price changes

class ItemModel extends Observable {
	
	private String itemName;
	private double price;
	
	public ItemModel (String name, double price){
		this.itemName = name; 
		this.price = price;
	}
	public void setPrice(double price){
		// stores the old price before changing the price to the new value
		double oldPrice = this.price;
		this.price = price;
		setChanged();
		// Passes the old price (before change)
		notifyObservers(new Double(oldPrice));
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getItemName(){
		return itemName;
	}
	
	public void increasePrice(double inc){
		setPrice(getPrice()+inc);
	}
	
	public void decreasePrice(double p){
		setPrice(getPrice()-p);
	}
}
