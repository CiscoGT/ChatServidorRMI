/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CiscoGT.Chat;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Carlos Bautista
 * @CanalOficcial Cisco GT
 * @Carrera Ingenieria en Sistemas y TICs
 *
 */

public class ChatImpl extends UnicastRemoteObject implements ChatInterfaz, Serializable
{
    List<String> users = new ArrayList<>();
    List<Mensaje> messages = new ArrayList<>();

    public ChatImpl() throws RemoteException 
    {
        super();    // Esto activa el código en UnicastRemoteObject que
                    // realiza la vinculación RMI y la inicialización remota de objetos              
    }
    

    public boolean login(String username) throws RemoteException 
    {
        boolean bandera = false;
        for (String user : users) 
        {
            if (username.equals(user)) 
            {
                bandera = true;
                break;
            } 
            else 
            {
                bandera = false;
            }
        }
        
        if (bandera == false) 
        {
            users.add(username);
            Mensaje message = new Mensaje();
            message.setUsuario(username);
            message.setMsg(" se unió a la conversación ");
            message.setTipo("Unirse");
            message.setDatos(new Date());
            messages.add(message);
            
            return true;
        }
        else
        {
            return false;
        } 
        // también puede usar el método .contains en una Lista sin usar una bandera
    }
    

    public void logout(String username) throws RemoteException 
    {
        users.remove(username);
        Mensaje message = new Mensaje();
        message.setUsuario(username);
        message.setMsg(" abandonado la conversación ");
        message.setTipo("Salir");
        message.setDatos(new Date());
        messages.add(message);
    }

    public void sendMessage(Mensaje message) throws RemoteException 
    {
        messages.add(message);
    }

    public List<Mensaje> getAllMessages() throws RemoteException 
    {
        for(Mensaje m : messages)
        {
            System.out.println(m.getUsuario() + " " + m.getMsg());
        }
        return messages;
    }
    
    public List<String> getAllUsers() throws RemoteException
    {
        for(String u : users)
        {
            System.out.println(u);
        }
        
        return users;
    }
}
