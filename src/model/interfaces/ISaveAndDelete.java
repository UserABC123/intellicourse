/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.interfaces;

/**
 *
 * @author Raphael
 */
public interface ISaveAndDelete
{
    /**
     * Saves the object to DB
     * 
     * @return true if saving to DB was successful
     */
    public boolean saveToDB();
    
    /**
     * Deletes the object from DB
     */
    public void deleteFromDB();
}
