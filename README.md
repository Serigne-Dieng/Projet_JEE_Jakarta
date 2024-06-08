##Contexte
Cett application a ete realiser pour le cours de java EE ,
##Information
l'application est simple , est une application web ,elle permet la gestion des utilisateurs ,
affiche les informations tel que leur id , nom , prenom et information de connexion (peut etre ameliorer pour hasher les password)

##Prerequis
une base minimale en java , un serveur MySQL (ou tout autre serveur de base d edonnée mais cela necessitera de changer le driver JDBC utilisé )
`DriverManager.registerDriver(new com.mysql.jdbc.Driver());	`
une base de donnée `jee` qui contient table `users` , la structure d'utilisateur est decrite dans le bean user
