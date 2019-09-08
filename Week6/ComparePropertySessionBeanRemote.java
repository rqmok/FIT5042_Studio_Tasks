/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.calculator;

import javax.ejb.Remote;

/**
 *
 * @author Zeeshan Khan
 */
@Remote
public interface ComparePropertySessionBeanRemote {
    /**
     * Add a property that needs to be compared.
     * 
     * @param propertyId The ID of the property to compare.
     */
    void addProperty(int propertyId);
    
    /**
     * Remove a property that does not need to be compared.
     * 
     * @param propertyId The ID of the property to remove.
     */
    void removeProperty(int propertyId);
    
    /**
     * 
     * @return 
     */
    int bestPerRoom();
}
