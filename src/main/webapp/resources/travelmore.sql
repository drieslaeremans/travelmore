create table if not exists Land (
	id int not null auto_increment,
    naam varchar(30) not null,
    primary key (Id)
);

create table if not exists Locatie (
	id int not null auto_increment,
    stadnaam varchar(30) not null,
    landId int not null,
    primary key (id),
    foreign key (landId) references Land(id)
);

create table if not exists Reis (
	id int not null auto_increment,
    naam varchar(100) not null,
    startDatum date not null,
    eindDatum date not null,
    prijsPerPersoon float not null,
    vertrekLocatieId int not null,
    aankomstLocatieId int not null,
    aantalPlaatsen int not null,
    REISTYPE varchar(31) not null,
    aantalKilometer int,
    vertrekAdres varchar(50),
    aankomstAdres varchar(50),
    vertrekLuchthaven varchar(100),
    aankomstLuchthaven varchar(100),
    primary key (id),
    foreign key (vertrekLocatieId) references Locatie(id),
    foreign key (aankomstLocatieId) references Locatie(id)
);

create table if not exists Gebruiker (
	id int not null auto_increment,
    naam varchar(30) not null,
    email varchar(30) not null,
    wachtwoord varchar(30) not null,
    GEBRUIKERTYPE varchar(31) not null,
    geboortedatum date,
    primary key (id)
);

create table if not exists Boeking (
	id int not null auto_increment,
    klantId int not null,
    reisId int not null,
    aantalPersonen int not null,
    betaald boolean default false,
    primary key (id),
    foreign key (klantId) references Gebruiker(id),
    foreign key (reisId) references Reis(id)
);


insert into Land (naam) values ("België");
insert into Land (naam) values ("Duitsland");
insert into Land (naam) values ("Frankrijk");
insert into Land (naam) values ("Spanje");
insert into Land (naam) values ("Nederland");
insert into Land (naam) values ("Oostenrijk");
insert into Land (naam) values ("Zwitserland");
insert into Land (naam) values ("Italië");
insert into Land (naam) values ("Portugal");
insert into Land (naam) values ("Polen");
insert into Land (naam) values ("Verenigde Staten");
insert into Land (naam) values ("Engeland");
insert into Land (naam) values ("Schotland");

insert into Locatie (stadnaam, landId) values ("Brussel", 1);
insert into Locatie (stadnaam, landId) values ("Antwerpen", 1);
insert into Locatie (stadnaam, landId) values ("Brugge", 1);
insert into Locatie (stadnaam, landId) values ("Amsterdam", 5);
insert into Locatie (stadnaam, landId) values ("Rotterdam", 5);
insert into Locatie (stadnaam, landId) values ("Parijs", 3);
insert into Locatie (stadnaam, landId) values ("Nice", 3);
insert into Locatie (stadnaam, landId) values ("Bordeaux", 3);
insert into Locatie (stadnaam, landId) values ("Toulouse", 3);
insert into Locatie (stadnaam, landId) values ("Trier", 2);
insert into Locatie (stadnaam, landId) values ("Berlijn", 2);
insert into Locatie (stadnaam, landId) values ("München", 2);
insert into Locatie (stadnaam, landId) values ("Madrid", 4);
insert into Locatie (stadnaam, landId) values ("Sevilla", 4);
insert into Locatie (stadnaam, landId) values ("Barcelona", 4);
insert into Locatie (stadnaam, landId) values ("Wenen", 6);
/*insert into Locatie (stadnaam, landId) values ("Geneve", 7);*/
insert into Locatie (stadnaam, landId) values ("Bern", 7);
insert into Locatie (stadnaam, landId) values ("Milaan", 8);
insert into Locatie (stadnaam, landId) values ("Rome", 8);
insert into Locatie (stadnaam, landId) values ("Napels", 8);
insert into Locatie (stadnaam, landId) values ("Turijn", 8);
insert into Locatie (stadnaam, landId) values ("Braga", 9);
insert into Locatie (stadnaam, landId) values ("Lissabon", 9);
insert into Locatie (stadnaam, landId) values ("Porto", 9);
insert into Locatie (stadnaam, landId) values ("Warschau", 10);
insert into Locatie (stadnaam, landId) values ("New York", 11);
insert into Locatie (stadnaam, landId) values ("Miami", 11);
insert into Locatie (stadnaam, landId) values ("Washington DC", 11);
insert into Locatie (stadnaam, landId) values ("Los Angelos", 11);
insert into Locatie (stadnaam, landId) values ("Newcastle", 12);
insert into Locatie (stadnaam, landId) values ("Manchester", 12);
insert into Locatie (stadnaam, landId) values ("Liverpool", 12);
insert into Locatie (stadnaam, landId) values ("Londen", 12);
insert into Locatie (stadnaam, landId) values ("Aberdeen", 13);
insert into Locatie (stadnaam, landId) values ("Glasgow", 13);

/*id: 1*/insert into Gebruiker (naam, email, wachtwoord, GEBRUIKERTYPE, geboortedatum) values ("Dries Laeremans", "r0672721@student.thomasmore.be", "wachtwoord", "Administrator", null);
/*id: 2*/insert into Gebruiker (naam, email, wachtwoord, GEBRUIKERTYPE, geboortedatum) values ("Stef Schoeters", "r0655338@student.thomasmore.be", "wachtwoord", "Administrator", null);
/*id: 3*/insert into Gebruiker (naam, email, wachtwoord, GEBRUIKERTYPE, geboortedatum) values ("Lise Van Eyck", "r0661824@student.thomasmore.be", "wachtwoord", "Klant", '1998-01-01');
/*id: 4*/insert into Gebruiker (naam, email, wachtwoord, GEBRUIKERTYPE, geboortedatum) values ("Dave Saenen", "r0636345@student.thomasmore.be", "wachtwoord", "Klant", '1998-01-01');

/*nieuwe busreis
insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("", '', '', 0, 1,2, 80, "Bus", "200", "Startstraat 1 Startstad", "Eindstraat 1 Eindstad", null, null); */

/*nieuwe vliegreis
insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("", '', '', 89.95, 1,2, 80, "Vlieg", null, null, null, "Vlieghaven", "Vlieghaven"); */

/*nieuwe busreizen*/
insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("Citytrip naar Rotterdam", '2019-5-24', '2019-5-26', 350, 2 ,5, 50, "Bus", 98, "Grote Markt 2000 Antwerpen", "Hartmansstraat 35", null, null);

insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("Een echte kerstreis naar Berlijn", '2018-12-20', '2018-12-27', 315, 2 ,11, 56, "Bus", 733, "Grote Markt 2000 Antwerpen", "Freienwalder Str. 15, 13055 Berlin, Duitsland", null, null);

insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("Met de bus naar Londen!", '2019-6-18', '2019-6-25', 295, 1 ,34, 52, "Bus", 372, "Willebroekkaai 22, 1000 Brussel", "4SX, Outer Cir, London, Verenigd Koninkrijk", null, null);

insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("10 dagen Barcelona", '2019-3-1', '2019-6-12', 399, 1 ,15, 48, "Bus", 1346, "Pachecolaan 34, 1000 Brussel", "Carrer de l'Ictíneo, 08003 Barcelona, Spanje", null, null);

insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("Culturele zomerreis naar Genève", '2019-7-5', '2019-7-13', 465, 1 ,17, 50, "Bus", 926, "Pachecolaan 34, 1000 Brussel", "Via Daniele Manin, 6, 20121 Milano MI, Italië", null, null);



/*nieuwe vliegreizen*/
insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("Een goedkope citytrip naar Parijs", '2019-4-07', '2019-4-14', 625, 1,6, 140, "Vlieg", null,null,null, "Brussel Airport", "Luchthaven Parijs-Charles de Gaulle");

insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("Luxueze citytrip naar Amsterdam", '2019-6-03', '2019-6-10', 485, 1,4, 220, "Vlieg", null, null, null, "Brussel Airport", "Schiphol (AMS) Nederland");

insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("Op skireis naar Wenen", '2019-3-31', '2019-4-6', 683, 2,16, 440, "Vlieg", null, null, null, "luchthaven Antwerpen", "Wien-Flughafen, Schwechat");

insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("Een culturele reis in Trier", '2019-7-9', '2019-7-16', 342, 2,10, 122, "Vlieg", null, null, null, "luchthaven Antwerpen", "Trier-Föhren Airport");

insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("Een kasteel-wijnreis naar Bordeaux", '2019-7-25', '2019-8-4', 398 , 2,8, 215, "Vlieg", null, null, null, "luchthaven Antwerpen", "Aéroport de Bordeaux-Mérignac");

insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("Weekend naar München", '2019-2-1', '2019-2-3', 259 , 2,20, 520, "Vlieg", null, null, null, "luchthaven Antwerpen", "Aeroporto di Roma Ciampino (CIA), Via Appia Nuova, Rome, Italië");

insert into Reis(naam, startDatum, eindDatum, prijsPerPersoon, vertrekLocatieId, aankomstLocatieId, aantalPlaatsen, REISTYPE, aantalKilometer, vertrekAdres, aankomstAdres, vertrekLuchthaven, aankomstLuchthaven)
values ("Citytrip New York", '2018-12-20', '2019-12-27', 2150 , 2,27, 150, "Vlieg", null, null, null, "luchthaven Antwerpen", "John F. Kennedy International Airport");



insert into Boeking(klantId, reisId, aantalPersonen, betaald) values (3, 4, 5, false);
insert into Boeking(klantId, reisId, aantalPersonen, betaald) values (4, 6, 2, false);
