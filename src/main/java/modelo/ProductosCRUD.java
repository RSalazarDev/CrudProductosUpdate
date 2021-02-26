/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author salaz
 */
public class ProductosCRUD {

    public static List<Productos> getProductos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prod");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM productos";
        Query q = manager.createNativeQuery(sql, Productos.class);
        List<Productos> productosBD = q.getResultList();

        return productosBD;
    }

    public static int actualizarProductoTest() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prod");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.categoria =  'zumos' WHRE p.id=13";
        Query q = manager.createQuery(sql, Productos.class);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        return filasAfectadas;
    }

    
    
    
     public static int actualizaProducto() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prod");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.nombre = :nombre, p.imagen = :imagen, p.categoria = :categoria, p.precio = :precio WHERE p.id = 13";
        Query q = manager.createQuery(sql,Productos.class);
        q.setParameter("categoria", "Digestivos");
        q.setParameter("nombre", "Pacharán");
        q.setParameter("imagen", "pacharan.jpg");
        q.setParameter("precio", 4.0);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;      
    }
     
     public static int actualizarProductoObjeto(Productos miProducto) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prod");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.nombre = :nombre, p.imagen = :imagen, p.categoria = :categoria, p.precio = :precio WHERE p.id = 13";
        Query q = manager.createQuery(sql, Productos.class);
        q.setParameter("categoria", miProducto.getCategoria());
        q.setParameter("nombre", miProducto.getNombre());
        q.setParameter("imagen", miProducto.getImagen());
        q.setParameter("precio", miProducto.getPrecio());
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;
    }

     
        public static void insertaProducto(Productos producto) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prod");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(producto);
        manager.getTransaction().commit();
        }


}
