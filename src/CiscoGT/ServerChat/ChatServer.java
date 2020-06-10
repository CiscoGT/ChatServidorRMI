/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CiscoGT.ServerChat;

import CiscoGT.Chat.ChatImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.Security;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.*;
import java.security.AccessControlContext;


/**
 *
 * @author Carlos Bautista
 * @CanalOficcial Cisco GT
 * @Carrera Ingenieria en Sistemas y TICs
 *
 */

public class ChatServer 
{
    public static void main(String[] args) 
    {
       
          // -Djava.security.policy=/Security/policy.all 
        try 
        {
          
     
            System.out.println("Iniciando Servidor");
            Registry registry = LocateRegistry.createRegistry(9013);
            //System.setProperty("java.rmi.server.hostname","192.168.1.50");
            
            registry.rebind("stormbreaker", new ChatImpl()); // crea el objeto remoto y lo registra
            System.out.println("Servidor Iniciado");
            
        } 
        
        catch (RemoteException ex) 
        {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
