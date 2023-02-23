package com.dam.dam22_23_hibernatecamposderivados;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    			//SessionFactory
    			StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
    			SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
    			
    			//Session
    	        Session sesion = sf.openSession();
    	        
    	        //Creamos los usuarios
    	        Usuario usuario1 = new Usuario("pepito", "1234");
    	        Usuario usuario2 = new Usuario("fulanito", "5432");
    	        
    	        //Creación de la transacción
    	        sesion.getTransaction().begin();
    	       
    	        sesion.persist(usuario1);
    	        sesion.persist(usuario2);
    	       
    	        
    	        sesion.getTransaction().commit();
    	        
    	        //Cerramos objetos
    	        sesion.close();
    	        sf.close();
    }
}
