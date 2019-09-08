/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.calculator;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Zeeshan Khan
 */
@Stateful
public class ComparePropertySessionBean implements ComparePropertySessionBeanRemote {
    
    List<Integer> propertyIds;
    
    @PersistenceContext(unitName = "W6ExeStudent-ejbPU")
    private EntityManager entityManager;
    
    public ComparePropertySessionBean() {
        propertyIds = new ArrayList<>();
    }

    @Override
    public void addProperty(int propertyId) {
        if (propertyId <= 0) return;
        
        // Only add id if not already in the list.
        int index = this.propertyIds.indexOf(propertyId);
        if (index == -1) {
            this.propertyIds.add(propertyId);
        }
    }

    @Override
    public void removeProperty(int propertyId) {
        if (propertyId <= 0) return;
        
        // Find the index of the property to remove.
        int index = this.propertyIds.indexOf(propertyId);
        if (index != -1) {
            // Remove the property id once it have been found.
            this.propertyIds.remove(index);
        }
    }

    @Override
    public int bestPerRoom() {
        if (this.propertyIds.isEmpty()) return -1;
        
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;
        
        for (int i = 0; i < this.propertyIds.size(); i++) {
            int propertyId = this.propertyIds.get(i);
            Property property = this.entityManager.find(Property.class, propertyId);
            int value = (int) Math.floor(property.getPrice() / property.getNumberOfBedrooms());
            
            if (value < minValue) {
                minIndex = i;
                minValue = value;
            }
        }
        
        return this.propertyIds.get(minIndex);
    }
}
