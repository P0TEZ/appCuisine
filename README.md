# App Cuisine

Application console pour la **gestion globale d'un restaurant**.
Comprend la gestion de **personnels, stocks, factures, commandes** etc..
Codé en `java`.

## Fichiers entrée/sortie 
- #### Factures clients : ```AppCuisine/src/app/_Factures```
![Fichier CSV de sortie ouvert sous excel](https://cdn.discordapp.com/attachments/656111343937781760/971483629387649064/unknown.png)
>**Note** : Exemple de facture client (fichier CSV ouvert sous excel)
- ####  Données stock et employés : `AppCuisine/src/app/_data`
![Fichier d'entrée employé](https://media.discordapp.net/attachments/656111343937781760/971484076290744450/unknown.png)
>**Note** : Fichier de données employés `serveurList.txt` ( {id}\_{nom}\_{prenom}\_{salaire}\_{nbJourdeTravaildeSuite} )

![Fichier d'entré stock](https://media.discordapp.net/attachments/656111343937781760/971484739640901702/unknown.png)
>**Note** : Fichier de données stocks `stock.txt` ( {nomIngredient}\_{quantité} )

- #### Liste de courses en fonctions des commandes de la journée : `AppCuisine/src/app/_courses.txt`
![enter image description here](https://media.discordapp.net/attachments/656111343937781760/971500263783428156/unknown.png)
>**Note** : Fichier liste de courses `_courses.txt` ( {nomIngredient}\_{quantitéAAcheter} )

## Fonctionnalités

### Serveur :

*   Prise de commande (nourriture, boissons et réduction)
*   Envoi des commandes de boissons et de nourritures en cuisine et au bar
*   Affichage du statut de la préparation des commandes
*   Génération de la facture et fermeture de la table

### Barman et Cuisinier :

*   Affichage de toutes les commandes de boissons/plats à préparer
*   Choix d'une commande en vue de sa préparation
*   Validation de la préparation d'une commande

### Manager :

#### Gestion du stock (tapez le nom du produit pour accéder à son menu) :

*   Affichage du stock d'ingrédients
*   Ajout/Retrait de quantité d'un ingrédient
*   Affichage de toutes les commandes en cours dans le restaurant et du total de plats et boissons à préparer

#### Gestion du personnel (tapez l'id de l'employé pour accéder à son menu) :

*   Affichage de tous les employés (ID Nom Prénom Salaire EnService(oui/non))
*   Ajout/Suppression d'un employé
*   Modification du salaire d'un employé
*   Ajouter/Retirer du planning de la journée
*   Ouvrir le restaurant _( possible uniquement si au moins : 2 serveurs, 4 Cuisiniers et 1 barman sont en service )_
*   Fermer le restaurant _( sauvegarde toutes les informations de la journée dans des fichiers (stock, liste d'employés )_ )

## Utilisation

### Pour lancer l'application console :

```bash
  cd AppCuisine
  java -classpath src src/app/AppCuisine.java
```

Le menu principal de l'application permet au personnel de choisir son poste dans le restaurant.

### En tant que serveur, lorsque des clients arrivent :

1.  **Se connecter** à l'écran serveur avec son identifiant unique (4 lettres)
2.  Appuyer sur `0` puis `Entrée` pour **ouvrir une nouvelle table**.
3.  **Entrer le numéro de la table** choisie _(cette table et la future commande sera associé au serveur)_
4.  Appuyer sur `1` puis `Entrée` pour **prendre la commande** : vous avez alors accès à la carte du restaurant
5.  Taper en toutes lettres le **nom du plat ou de la boisson à ajouter à la commande** dans les sous section `Nourritures` et `Boissons` ou sélectionner une **promotion** (exemple : "100 ans" 100 € pour 7 plats et 7 boissons)
6.  **Valider** la commande en entrant dans le menu `3` de la table pour **envoyer les plats et boissons** en cuisine et au bar
7.  **Attendre** la préparation de la commande par la cuisine et le bar
8.  **Valider** le service de la commande en entrant dans le menu `3` de la table
9.  Lorsque les clients souhaitent l'addition, le menu `3` de la table permet maintenant de **clôturer** cette dernière et de **générer la facture**.

### En tant que cuisinier ou barman, quand une commande apparait sur l'écran :

1.  Après s'être **connecté** avec son identifiant unique, le barman/cuisinier voit chaque commande sous la forme :

```plaintext
X - Table n°X
	Y plat(s) à préparer
...
```

2.  **Entrer** le numéro de la table pour accéder aux détails de la commande qui s'affichent alors sous la forme :

```plaintext
Table n°X
	eau x3
	lemonade x2
	
Valider la commande : (v/-1)
```
3. **Appuyer** sur la touche `v` puis `Entrée` pour **valider** la préparation de la commande lorsque celle-ci est prête à être servie
4. **Attendre** l'arrivée d'autres commandes


### En tant que manager : 

#### Ouvrir le restaurant : 
1. Après s'être **connecté** avec son identifiant unique, pour ouvrir le restaurant, le manager doit **ajouter** au moins *quatre cuisiniers, deux serveurs et un barman*.
2. Pour cela : **naviguer** jusqu'au menu `4 : Gérer le personnel`
3. **Taper en toutes lettres** l'identifiant du personnel à ajouter au planning puis une fois dans son menu, appuyer sur `1`.  *(`2` pour le retirer du planning)*
4. Une fois l'équipe minimum ajoutée, **entrer dans le menu** `5 : Ouvrir le restaurant`

#### Gérer le stock : 
1. **Naviguer** jusqu'au menu `1 : Gérer les stock`
2. Les stocks d'ingrédients y sont **affichés** sous la forme : 
```plaintext
pain x20
steack x15
tomate x5
...
```
3. **Sélectionner** l'ingrédient à modifier en tapant son nom en toutes lettres
4. **Entrer** dans la section `1` (ajouter), `2` (retirer) ou `3` (supprimer) pour **modifier manuellement** le stock de l'ingrédient sélectionné à l'étape précédente

#### Gérer le personnel : 
1. **Naviguer** jusqu'au menu `4 : Gérer le personnel`
2. **Taper en toutes lettres** l'identifiant du personnel pour accéder à son menu
3. D'ici vous pouvez **modifier son salaire** et l'**ajouter/retirer** du planning de la journée.

#### Ajouter un employé : 
1. **Naviguer** jusqu'au menu `4 : Gérer le personnel`
2. **Taper en toutes lettres** `ajout`
3. Le menu de création s'affiche et vous **demande** un nom, prénom, salaire et un poste (cuisinier, barman, serveur).




## Auteurs

CIR 3 :

*   [@jairaume](https://github.com/jairaume)
*   [@P0TEZ](https://github.com/P0TEZ)
