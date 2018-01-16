package CollectionDemo;

/**
An item with a description and a part number.
*/
public class Item implements Comparable<Item>  ////IMPORTANT TO MAKE IT COMPARABLE IN ARRAY
{ 
/**
   Constructs an item.
   @param aDescription the item's description
   @param aPartNumber the item's part number
*/
public Item(String aDescription, int aPartNumber)
{  
   description = aDescription;
   partNumber = aPartNumber;
}

/**
   Gets the description of this item.
   @return the description
*/
public String getDescription()
{  
   return description;
}

public String toString()
{  
   return "[descripion=" + description
      + ", partNumber=" + partNumber + "]";
}

public boolean equals(Object otherObject) ////OverRiding equals
{  
   if (this == otherObject) return true;
   if (otherObject == null) return false;
   if (getClass() != otherObject.getClass()) return false;
   Item other = (Item) otherObject;
   return description.equals(other.description)
      && partNumber == other.partNumber;
}


public int hashCode()
{  
   return 13 * description.hashCode() + 17 * partNumber;
}

public int compareTo(Item other)
{  
   return partNumber - other.partNumber;
}

private String description;
private int partNumber;
}

/*
*Sort by part number[[descripion=Toaster, partNumber=1234], [descripion=Widget, p
artNumber=4562], [descripion=Modem, partNumber=9912]]
=================================
Sort by Description[[descripion=Modem, partNumber=9912], [descripion=Toaster, pa
rtNumber=1234], [descripion=Widget, partNumber=4562]]
=================================
*/