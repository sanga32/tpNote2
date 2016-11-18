package codeProf;


public class exemple {


	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	} 


}


/*
 * class VirtualProxyListPersonne implements List<Personne> {
 *       List<Personne> vraieListe = null;
 *       int id_personne;
 *       
 *       VirtualProxyListPersonne(int id_personne) {
 *         this.id_personne = id_personne;
 *       }
 *       
 *      
 *        
 *       Iterator<Personne> iterator() {
 *         if (vraieListe == null) {
 *            vraieListe = PM.getFilsById(id_personne);
 *         }
 *         return vraieListe.iterator();
 *       
 *       }
 *       
 *       int getSize() {
 *         if (vraieListe == null) {
 *            vraieListe = PM.getFilsById(id_personne);
 *         }
 *         return vraieListe.getSize();       
 *       
 *       }
 *       
 *       bool isEmpty() {
 *         if (vraieListe == null) {
 *            vraieListe = PM.getFilsById(id_personne);
 *         }
 *         return vraieListe.isEmpty();        
 *       }
 *      


         
         void invoke(Method m, Object[] args) {
 *         if (vraieListe == null) {
 *            vraieListe = PM.getFilsById(id_personne);
 *         }
 *         return vraieListe.invoke(m, args);          
         }
 *       
 *       
 *       
 * }
 * 
 * 
 */
/*
 * List<Personne> getFilsId(int id_personne) {
 *   // renvoie tout les fils de la personne)
 *   pour tout les fils dans la base {
 *     Personne fils = findById(fils_id);
 *     
 *   }
 * }
 * Personne findById(int id_personne) {
 *   Personne p = new Personnne();
 *   p.setNom/Prenom/... 
 *   p.fils = new VirtualProxyListPersonne(id_personne);
 *   
 * }
 */




/*
 * Personne {
 * 	String nom,prenom;
 *   List<Personne> fils;
 * }
 * 
 */






/*
 * (mieux) 
 *  Personne p = PM.find(id);
 *  
 *  for (Personne f : p.getFils() {
 *   for (Personne pf : f.getFils()) {
 *    //..
 *   }
 *  }
 */




