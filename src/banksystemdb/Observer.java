package banksystemdb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ToniGeorge
 */
public interface Observer {
    public void update(double account, String event);
}