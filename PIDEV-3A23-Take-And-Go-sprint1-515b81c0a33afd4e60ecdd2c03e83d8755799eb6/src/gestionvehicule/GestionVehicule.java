/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionvehicule;

import Entities.Categories;
import Entities.Modeles;
import Entities.Vehicules;
import Services.ServiceCategories;
import Services.ServiceModeles;
import Services.ServiceVehicules;

/**
 *
 * @author Wahch
 */
public class GestionVehicule {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Categories c = new Categories("bmw" , "a" , "a") ; 
        Categories c2 = new Categories("fiat" , "bbbb" , "bbbbbb") ; 
        Categories c1 = new Categories(37,"archive" , "arachi" , "aabbbaaaaa") ; 
         Categories c12 = new Categories(216, "belle vue", "belle vue", "belle vue") ; 
        
        Modeles m = new Modeles(15,1,"aB","Ba",11000f) ; 
        Modeles m1 = new Modeles(4,2,2,"a","a",11000f) ; 
         Vehicules v = new Vehicules(9,1,"a","a") ; 
         Vehicules v1 = new Vehicules(9,7,1,"bmx","ab") ;
          Vehicules v6 = new Vehicules(20,26,26,"bmmx","ab") ;
         ServiceCategories sc = new ServiceCategories();
         
         sc.modifier(c12);
        Modeles m5 = new Modeles(16, 9, "serie 6 ", "bmw", 110000f) ; 
        Modeles m6 = new Modeles(16, 9, "serie 5 ", "bmw", 100000f) ; 
        Modeles m7 = new Modeles(26,37, 8, "TEST ", "TEST", 1f) ;
        ServiceModeles sm = new ServiceModeles();
//     sm.add(m7);
  //        sc.add(c1)
//sm.supprimer(m7, true) ;
 
//        sm.add(m5);
//        sm.add(m6);
//        sm.add(m7);
//         sc.add(c) ;
//sm.chercher("mercedes");
//          sc.add(c1) ;
//           sc.add(c2) ;
//sc.chercher("fiat") ; 
         
          ServiceVehicules sv = new ServiceVehicules();
          //       sv.add(v6) ;
          Vehicules v22 = new Vehicules(226, 211, "a", "violet") ; 
          sv.modifier(v22) ;
          //   sv.supprimer(v6, true) ;
          //sm.add(m);
 //sc.supprimer(c1);
 // sv.add(v);
//     System.out.println(sc.afficher());
//     System.out.println(sm.afficher());
//      System.out.println(sv.afficher());
    }
    
}
