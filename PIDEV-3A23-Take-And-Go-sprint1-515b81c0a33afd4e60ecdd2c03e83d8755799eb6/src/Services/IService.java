/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

/**
 *
 * @author Wahch
 */
public interface IService<T> {
    public void add(T t );
    public List<T> afficher();
    public Boolean modifier(T t  );
    public Boolean supprimer(T t ,  boolean  archivee);
     public void chercher(String name) ;
}
