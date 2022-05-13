A program egy olyan onkológia osztály adatnyilvántartó rendszerét modellezi, amely kemoterápiára specializálódott.
A osztályok struktúrája a kurzuson tanultak alapján történt.
A Beteg osztály tartalmazza a szükséges változókat, privát formában, ezért szükség van konstruktorra, getter,
illetve setter függvényekre, hogy a többi osztály elérhesse őket.
A beteg adataival kapcsolatos műveletek(Listázás, új beteg adatainak felvétele, beteg törlése az "adatbázisból",
beteg adatainak műdosítása)XML formátumban történik.
Az XmlReader osztály az xml fájlban tárolt adatok kiolvasásához szükséges, amely DocumentBuilderFactory és Node-ok 
segítségével történik.
Az XmlWriterben egy konzolos menüpontot hívunk, itt 4 opció érhető el, kiválasztásukkal, az opciókhoz tartozó metódus 
kerül meghívásra.
A felvetel metódusban a beteg adatait írhatjuk be, itt is további metódusok kerülnek meghívásra, a begépelt információ
pontosítása érdekében.
A modositas metódusban a módosítani kívánt beteg adatait cserélhetjük le, a beteg azonosítása a tajszáma alapján történik,
ezután gyakorlatilag a felvetel metódus ismétlődik az adott tajszámhoz rendelten.
A listazas metódus a betegek tajszámát és nevét írja ki a konzolra.
A torles metódus szintén a tajszám alapján eltávolítja az XML fájlban tárolt beteg adatait.
Majd a konzolban, ha a kilépés opciót választjuk a saveBetegekToXml elmenti a végrehajtott műveleteket a
DocumentBuilderFactoryval, child- és parentelementekkel.
A jelenlegiCiklusokSzáma meghaladhatja az eloirtCiklusokSzámánát, mert a kezelés közben a kezelés eredményességétől függően
eltérhet az előre meghatározott kemoterápiás ciklusok számától.
