# Guide de contribution

Bonjour, bienvenu sur notre guide de contribution qui vous aidera à contribuer au projet de la meilleure des façons.

# Things you will need || Ce dont vous aurez besoin

* Linux, Mac OS X, or Windows

* Git (utilisez pour le versionning).

* JDK 8 installé sur votre OS

* Maven installé sur votre OS

* Un IDE, nous vous recommandons *IntelliJ* ou *VsCode*
    - **Pour les utilisateurs de VsCode se munir de ces plugins**
        + [*Java Extension Pack*](https://marketplace.visualstudio.com/items?itemName=redhat.java)
        + [*Spring Boot Tools*](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-spring-boot)


# Directive de soumission

Avant de soumettre un problème(Issue), cherchez dans les archives, peut-être que votre problème (Issue) a déjà reçu une réponse.

Si votre problème semble être un bogue et n'a pas été signalé, ouvrez un nouveau problème(Issue). Aidez-nous à maximiser l'effort que nous pouvons consacrer aux différents problèmes (Issue), en ne signalant pas les problèmes (Issue) en double.

##  Vous avez trouvé un bug (Issue) ?

Si vous trouvez un bug dans le code source ou une erreur dans la documentation, vous pouvez nous aider en soumettant un problème à notre dépôt GitHub. Mieux encore, vous pouvez soumettre une **Pull Request** avec un correctif.

##  Vous voulez une fonctionnalité (Feature) ?

Vous pouvez demander une nouvelle fonctionnalité en le soumettant à notre dépôt GitHub.

Si vous souhaitez mettre en œuvre une nouvelle fonctionnalité, veuillez d'abord soumettre la fonctionnalité, pour être sûr que nous allons la prendre en compte.


# Pull Request Guidelines || Lignes directrices pour un Pull Request

La **branche master** n'est fondamentalement qu'un snapshot de la dernière version stable. Tout le développement devrait se faire dans des branches spécialisées. Ne soumettez pas de **Pull Request (PR)** à l'encontre de la **branche master**.

Effectuer un *Checkout* de la branche concernée, par exemple *develop*, effectué un merge par la suite avec cette branche (*develop*)


Avant de soumettre votre **Pull Request** (PR), tenez compte des lignes directrices suivantes :

**Si vous ajoutez une nouvelle fonctionnalité :**

* Assurez-vous que vous utilisez nos conventions de codes qui ont été définis
* Ajouter le scénario de test qui l'accompagne (dans le cas du possible).
* Donnez une raison convaincante d'ajouter cette fonction. Idéalement, vous devriez d'abord ouvrir une question de suggestion et la faire approuver avant d'y travailler.

**Si vous corrigez un bug :**

* Assurez-vous que vous utilisez nos conventions de codes qui ont été définis
* Fournir une description détaillée du bogue dans le PR.
* Si vous résolvez un problème spécial, ajoutez (correctif #xxxxxx[,#xxx]) (#xxxxxx est l'id du problème) dans le titre de votre PR, par exemple, mettre à jour la logique d'envois en masse d'email (correctif #1993).



# Development Setup || Configuration pour le développement

Vous aurez besoin du JDK 8 et de la JRE (Java Runtime Environment) et enfin de git.

Pour la persistance des données vous aurez besoin d'avoir un SGBDR installé sur votre OS, soit le SGBDR H2 ou Postgresql, mais il vous sera possible d'utiliser le SGBDR embarquées h2.

Pour ceux qui utiliseront le SGBDR Postrgreslq, veuillez suivre les instructions ci-dessous :
* Créer un utilisateur sur Postrgreslq avec **username : dembesi** et **mot de passe : dembesi**
* Créer une base de données et nommé la **dembesi**
* Attribuer tous les droits possibles sur la base de données **dembesi** à **l'utilisateur dembesi**

Après avoir cloné le repo, exécutez les commande ci-dessous :

`mvn clean package -DskipTests` :  Pour vérifier s'il y a aucun souci sur le projet.

`mvn spring-boot:run` : Pour exécuter le projet.

# Project Structure

TODO

# Git Commit Message Convention

TODO