
Les tests : 
  
   1. Test de fonctionnement de Tomcat : 
        Apres avoir ajoute le projet au Tomcat et demarrer le serveur, 
        aller sur 
           http://localhost:8080/PracticalExamples 
        pour tester (voir HOLA = c bon).
   2. Test de la librairie JSTL 
        Les dependencies du projet sont gerees par Maven.
        La librairie jstl (des balises jsp if, choose, out....) a ete importe par Maven dans le projet.
        Pour tester le bon fonctionnement, aller sur 
            http://localhost:8080/PracticalExamples/testJSTL.jsp
            
   3. Exemple du servlet
        Le servlet LoginServlet est mappe au chemin /login
        Rencontre sur
           http://localhost:8080/PracticalExamples/login
        -> doGet() appele, on devrait voir "/login GET REQUEST" dans le console
        Cliquer sur Valider 
        -> doPost() appele, on devrait voir "/login POST REQUEST" dans le console