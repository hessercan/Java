/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usebook;

/**
 *
 * @author mark
 */
public class NonFiction extends Book
{
    public NonFiction(String t)
    {
        super(t);   
    }
    @Override
        void setPrice()
        {
            super.Price = 37.99;
        } 
}
