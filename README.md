#### Diagramme de classe
<img src="./images/diagramme.png" alt="Diagramme de classe"/>

#### Categorie
<img src="./images/categ.png" alt="Categorie"/>

#### Article
<img src="./images/article.png" alt="Article"/>

#### Client
<img src="./images/client.png" alt="Client"/>

#### Commande
<img src="./images/commande.png" alt="Commande"/>

#### Ligne de commande
<img src="./images/ligneCommande.png" alt="ligne Commande"/>

#### Liste des clients
<img src="./images/template-client.png" alt="Liste des clients"/>


#### Commande d'un client avec pagination quand on clique sur le bouton au niveau de la page client
<img src="./images/unCommande.png" alt="Commande d'un client"/>

Quelque avantage d'utiliser dto : 
- balancer a la view que les données dont il a besoin et non l'entité directement
- Question de securité t'as capté : quand on balance l'entité et qu'il ya des relations etc , on pourra acceder au differents entité qui sont en relation or avec dto , on limite cela

```java
//Builder pour generer des méthodes de création d'instances de manière fluide et concis
//Rendre dynamique le bouton etat commande
/*quand une commande est encours btn devient => Payer
quand une commande est   Facturer    => Payer
                         Facturer    => Terminer
                         Payer    => Payer
 */



    public static CommandeShowEntityResponseDto toDto(Commande commande){
            //rendre etat suivant dynamique dans la view
            EtatCommande EtatSuivant = EtatCommande.Payer;
            if(commande.getEtat() != EtatCommande.Payer){
                long indexEnumEtat = commande.getEtat().getIndexEnumEtat()+1;
                EtatSuivant = EtatCommande.values()[Long.valueOf(indexEnumEtat).intValue()];
    
            }
            return CommandeShowEntityResponseDto
                    .builder()
                    .id(commande.getId())
                    .dateCommand(commande.getDateCommand())
                    .montant(commande.getMontant())
                    .etat(commande.getEtat())
                    .etatSuivant(EtatSuivant)
                    .adresse(commande.getAdresse())
                    .build();
        }
```

#### Formulaire d'ajout de client
<img src="./images/form.png" alt="formulaire d'ajout d'un client"/>

<br/>
<img src="./images/formAdd.png" alt="formulaire d'ajout d'un client"/>


#### Ajouter une nouvelle commande
<img src="./images/nouvelle.png" alt="nouvelle commande"/>

#### Formulaire ajout d'une nouvelle commande + affichage des infos du client dans le formulaire
<img src="./images/nouvelle1.png" alt="nouvelle commande"/>