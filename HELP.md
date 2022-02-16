# Film jegyzék SPRING DATA JPA backend alkalmazás

Url: http://localhost:8080/api

az alkalmazás mozifilm címeket képes eltárolni és listázni. Ezt a Movie entitiásban tárolja.
Egy film adatai minimálisan felvihető az adatbázisba ha legalább egy címet megadunk.
3 fajta cím van:
* magyar
* angol
* eredeti

Megjegyzés, miért van ez így: egy filmnek nem feltétlenül van magyar címe, mert lehet sosem jutott el hivatalosan magyar TV-kbe vagy mozikba.
Ha film nem amerikai, akkor lehetséges hogy sem magyar sem pedig angol címe nincs, ezért van egy olyan lehetőség hogy eredeti cím.
Pl régebbi olasz/francia/német/spanyol filmek (ezeknek általában van magyar címük), vagy ázsiai filmek, anime-k, amelyek se angol se magyar címük nincs (annak is örülni lehet, ha van hozzá magyar felirat)

A végpontokat működés közben a http://localhost:8080/swagger-ui.html címen meg lehet megnézni és kipróbálni - van egy kevés alapadat feltöltve már (ha a hibernate-et update módban índítjuk el, nem create-drop-al - lás application.properties -ben a 'spring.jpa.hibernate.ddl-auto=update' sort.)
Egy filmnek kapcsolódó táblái is vannak. 
* rendező (Director)
* típus (Genre)
* videó codec formátuma (CodecFormat)
* tároló típusa (StorageType)

A fentikekre vannak beállított minta adatok az adatbázisban.

A film adatait vagy egyben lehet módosítani (egy komplett Movie objektum beküldésével), vagy a Settingsben az egyes adatokat lehet külön-külön állítgatni.

Listaszerűen tárolt további aatok a filmhez:
* szinkronhangok (audios)
* feliratok (subtitles)

A filmnek meg lehet adni milyen szinkronhangjai vannak és feliratai. Listát vár mindkét esetben, de csak az egymástól különbözőek tárolódnak el.

Törölni egyelőre csak címet, megadva, hogy hungarian, english vagy original címet akarjuk eltávolítani, de ekkor is minimum egy címnek maradnia kell.

Más adatot nem lehet még törölni, továbbá a kapcsolódó táblák adatai egyformák is lehetnek k(pl 3x is felvehetjük ugyanazt a rendezőt, vagy audiot, stb)
Ez később megvalósítható a settings controller bővítésével.

-----s
Amit továbbá még nem tud, de meg kell valósítani: egy poszterkép eltárolása az adott filmhez.
