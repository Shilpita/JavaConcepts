package GenericsDemo1;

import java.util.ArrayList;
import java.util.List;

/* Bounded type parameter */

public class ItemOrderB<T extends OfficeItem>{
	private T item;
	public void setItem( T item ) { this.item = item; }
	public T getItem() { return item; }	
	public void show() { System.out.println(item);}		
}
