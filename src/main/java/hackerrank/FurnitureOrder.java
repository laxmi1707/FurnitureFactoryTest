package hackerrank;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
    }
    
    HashMap<Furniture, Integer> furnitureMap = new HashMap<Furniture, Integer>();

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
    	HashMap<Furniture, Integer> furniMap = this.getOrderedFurniture();
    	if(furniMap.containsKey(type)){
    		Integer count = furniMap.get(type);
    		
    		furniMap.put(type, count+furnitureCount)	;
    	}else{
    		furniMap.put(type, furnitureCount)	;
    	}
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
       
    	return this.furnitureMap;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
       Collection<Integer> unitsList = this.furnitureMap.values();
       Set<Entry<Furniture,Integer>> keyValueList = this.furnitureMap.entrySet();
       Float totalCost = (float) 0.0;
       for(Entry eachUnit: keyValueList){
    	   Furniture f = (Furniture)eachUnit.getKey();
    	   Integer count = (Integer)eachUnit.getValue();
    	   Float cost = f.cost() * count ;
    	   totalCost =totalCost + cost;
       }
       return totalCost;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
    	if(furnitureMap.isEmpty())
    		return 0;
    	else
    		return (int)furnitureMap.get(type);
        
    }

    public float getTypeCost(Furniture type) {
    	Integer quant = furnitureMap.get(type);
    	if(quant!= null)
    		return quant*type.cost();
    	else
    		return 0.0f;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
    	int count =0;
    	if (this.getOrderedFurniture().isEmpty()){
    		return 0;
    	}
    	Collection<Integer> all =  this.getOrderedFurniture().values();
//    	Integer[] all =  (Integer[]) this.getOrderedFurniture().values().toArray();
        for(Integer a: all){
        	count = count + a;
        }
        return count;
    }
}