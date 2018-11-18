#SoundBox

## Membres du projet
  * COURIEUX Alexi
  * HAAS Romain
  * FOURNIER Nathan
  
## Auteurs du README
  * MEYER Nicolas
  * VENEZIA Matthieu 
  * VARGA Mihaly
  
 ## Résumé du projet
 SoundBox est une application Android pour jouer diverses catégories de sons.
 
 ## Les fragments
 
 ### Fragment : Home
 Cet écran est l'accueil de l'application, il présente divers boutons qui permettent de palier au menu latéral.
 
 ![HomeFragment Image](https://raw.githubusercontent.com/AlexiGhost/LPDAM_Android_SoundBox/master/screenshots/Screenshot_20181118-212815.jpg)
 
 ### Fragment : Category(Animal/Ambiance/Jingle)
 Ces écrans sont chacun composé d'une GridView qui va chercher les sons selon leur catégorie respective.
 Lorsque l'on clique sur un des boutons un son est joué.
 
 ![AnimalFragment Image](https://raw.githubusercontent.com/AlexiGhost/LPDAM_Android_SoundBox/master/screenshots/Screenshot_20181118-212806.jpg)
 ![AmbianceFragment Image](https://raw.githubusercontent.com/AlexiGhost/LPDAM_Android_SoundBox/master/screenshots/Screenshot_20181118-212817.jpg)
 ![JingleFragment Image](https://raw.githubusercontent.com/AlexiGhost/LPDAM_Android_SoundBox/master/screenshots/Screenshot_20181118-212820.jpg)
 
 ### Fragment : CreatedBy
 Cet écran affiche simplement les auteurs du logiciel, un canvas à été place en arrière plan afin de créer un cercle.
 
 ![CreatedBy Image](https://raw.githubusercontent.com/AlexiGhost/LPDAM_Android_SoundBox/master/screenshots/Screenshot_20181118-212802.jpg)
 
 ### Fragment : NumberPicker
 Cet écran permet de constater comment utiliser le NumberPicker d'Android.
 
 ![NumberPicker Image](https://raw.githubusercontent.com/AlexiGhost/LPDAM_Android_SoundBox/master/screenshots/Screenshot_20181118-220110.jpg)
 
 ## Le menu
 Le menu est un NavigationDrawer qui permet de naviguer aisément entre tout les fragments de l'application.
 
 ![Menu Image](https://raw.githubusercontent.com/AlexiGhost/LPDAM_Android_SoundBox/master/screenshots/Screenshot_20181118-212758.jpg)
 
 ## Remarque sur le code
 Le code est clair et organisé, de plus quelques commentaires expliquent l'utilité des fonctions implémentés
 (bien que plus ne serait pas un luxe).
 
 ## Idée d'évolution
 Il pourrait être intéressant d'avoir la possibilité d'arrêter les sons que nous sommes en train de jouer, en effet certains sons durent plus d'une minute.
