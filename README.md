# DentistApp

Ülesanne võttis aega ca 10 päeva, millest esimesed 5 päeva polnud sugugi produktiivsed, kuna tutvun Spring Bootiga alles nüüd tänu sellele ülesandele. Seejärel jõudsin päris heade õppevideote ning muude õppematerjalide juurde, mis aitasid mul pisut aru saada, millistes Java klassides üldse toimetama pean ning millise workflow'ga Spring Boot on. Etteantud faile ma väga palju ei muutnud, kuna Spring Bootiga rohkem tutvudes mõistsin, et etteantud programm on väga abistavalt koostatud. Etteantud failidele lisaks lõin juurde DentistVisitRepository interface'i, ning kolm vaadet results, search, update. Teste ma ei loonud. 

Lisasin klassidesse kommentaare nendes olevate meetodite ja muutujate kohta. HTML-faile ei kommenteerinud. Õppisin lisaks natuke Bootstrap'i, et HTML-i ilustada. Programmi käivitamiseks võib oma IDE-s jooksutada klassi DentistAppApplication. Registreerimiseks saab nelja hambaarsti vahel valida, seejärel avada kalender ning valida kuupäev ja kellaaeg. Otsingu jaoks saab registreeringute vaates klõpsata otsinguribale, sisestada sinna hambaarsti nimi ning seejärel otsingu nupu peale vajutada. Visiidi uuendamise ja kustutamise jaoks on nupud koos iga registreeringuga.

Olen teadlik paarist veast ning ebatäiuslikkusest oma programmi juures, kuid seadsin endale ajapiirangu selle töö valmis saamiseks 10 päeva peale. Mainin need vead/ebatäiuslikkused siin ära, kuna testides ning kontrollides te tõenäoliselt puutute nendega nagunii kokku:
- Registreerumisvormis errori esinemisel nihkuvad ülejäänud väljad vasakule poole, et ruumi teha paremale tekkivale errori sõnumile.
- Registreeringute nimekirjas on kuupäevad kehvas formatis.
- Registreeringu muutmisel kuupäeva välja tühjaks jättes ei tule paremale poole errori sõnum, vaid ta viib error lehele.
- Juba võetud aega broneerides viib programm samuti error lehele, kus on küll spetsiifiline sõnum, kuid ideaalis võiks ta töötada samamoodi nagu registreeringu vormi errorisõnumid.

Mõned materjalid mida kasutasin: 
- https://stackoverflow.com/questions/39397147/difference-between-entity-and-dto
- https://www.baeldung.com/spring-boot-crud-thymeleaf?fbclid=IwAR0-ketkOnWv9t6K4T551C_SjqUD-a160_gATTn1-93ngfT1LaPSedH3Ad4
- https://www.baeldung.com/rest-api-search-language-spring-data-specifications
- https://stackoverflow.com/questions/11881479/how-do-i-update-an-entity-using-spring-data-jpa
- https://getbootstrap.com/docs/4.1/content/tables/
- ja veel väga palju muid.
