CREATE DATABASE AubergeInn;

CREATE TABLE Client(
    IdClient int PRIMARY KEY,
    Nom varchar(50),
    Prenom varchar(50),
    Age Integer
);
    
CREATE TABLE Chambre(
    IdChambre int PRIMARY KEY,
    NomDeLaChambre Varchar(50),
    PrixDeBase FLoat,
    TypeDeLit Varchar(50)
);

CREATE TABLE Reservation(
    ReservationId SERIAL PRIMARY KEY,
    IdClient int,
    IdChambre int,
    DateDebut timestamp,
    DateFin timestamp,
    CONSTRAINT fk_ReservationClient
        FOREIGN KEY(IdClient)
        REFERENCES Client(IdClient),
    CONSTRAINT fk_ReservationChambre
        FOREIGN KEY (IdChambre)
        REFERENCES Chambre(IdChambre)
);
    

CREATE TABLE Commodite(
    IdCommodite int PRIMARY KEY,
    Surplus_prix float,
    Description Varchar(200)
);
    

CREATE TABLE CommoditeChambre(
    IdCommiditeChambre SERIAL PRIMARY KEY,
    IdChambre int,
    IdCommodite int,
    CONSTRAINT fk_Chambre
        FOREIGN KEY (IdChambre)
        REFERENCES Chambre(IdChambre),
    CONSTRAINT fk_Commodite
        FOREIGN KEY (IdCommodite)
        REFERENCES Commodite(IdCommodite)
);