# Descripton du diagramme de classes

###### Ceci est la description de la partie model de notre diagramme de classes, que vous pourrez trouver dans le fichier DiagrammeClasses.png


## Model
Le modèle de notre projet est composé de plusieurs sous-packages, décrits ci-dessous.
Bous avons les packages suivants: manager, observateurs, boucleur, player, fish, persistance, déplaceurs.


### Player
le package player est un des plus simples puisqu'il ne contient qu'une seule classe : Pecheur. Un pêcheur possède un pseudo (qui sera le pseudo rentré par le joueur), ainsi qu'un score courant.

### Fish
fish contient plusieurs classes ainsi que de l'héritage : les classes PoissonClassique, PoissonDore, PoissonBombe héritent toutes de la classe abstraite Poisson. Un poisson possède une valeur, et quand le Pêcheur attrape un poisson son score est augmenté de la valeur de ce poisson. Un poisson possède aussi des coordonnées en X et Y, ainsi qu'un booleen isCatched qui indique si ce poisson est attrapé ou non.
VaguePoisson représente une liste de poissons.

### Boucleurs
Nous avons implémenté dans ce projet un patron de conception "Observateur" : des boucleurs, ici représentés par BoucleurRapide, BoucleurLent, et BoucleurPersonnalisable héritant tous de BoucleurAbstrait, notifient à des intervalles de temps variables une liste d'observateurs remplissant des fonctions différentes.

### Observateurs
Ces observateurs, attachés à des boucleurs, sont placés dans un package différent. Chacun a une utilité différente, mais ils implémentent tous la même interface Observateur possédant une unique méthode abstraite : update().
C'est cette méthode qui sera appelée quand le boucleur notifie l'observateur.
Chaque type d'observateur a une fonction différente : AnimVaguePoisson s'occupe du déplacement de nos poissons, ObservateurCréationPoisson crée de nouveaux poissons toutes les 7 secondes (modifiable) et Timer gère le temps de jeu restant.

### Déplaceurs
Nous avons 2 types de déplaceurs différent : DeplaceurRapide et DeplaceurLent. Chaque poisson possède aléatoirement 1 de ces 2 déplaceurs, histoire de varier la difficulté pour le joueur (certains poissons sont plus rapides que d'autres). Les coordonnées en X et Y de ce poisson seront plus ou moins modifiées en fonction de son type de déplaceur.

### Persistance
persistance contient plusieurs classes, avec pour but principal de gérer les Highscores existants mais aussi de sauvegarder de nouveaux scores après la fin d'une partie.

### Manager
le GameManager est une de nos classes les plus importantes. C'est lui qui gère le lancement du jeu (et donc la création de Threads, Boucleurs etc ...) mais aussi l'arrêt de ces threads, en cas de pause ou de destruction de l'activité de jeu.
C'est lui qui possède la map contenant les scores, le Pêcheur, ainsi que la liste des poissons en jeu. 