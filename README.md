# Simple Spring Boot REST API with AOP

Ez egy REST API, melyet böngészőjében a ```http://localhost:8080``` URL alatt tud megtekinteni.
Amennyiben a szoftver egy igazi szerveren fut, akkor a localhost-ot ki kell cserélni az IP címre, a portot pedig a megadottra.

### A szoftver rendeltetése
Alapvetően multifunkcionális szoftverről van szó. Mely arra szolgál, hogy mindenfélre fájlformátumú fájlokat (application.properties-ben talál információkat a fájlok méretkorlátaira vonatkozóan) tároljunk és kezeljünk egy adatbázisban. Két funkcióhoz létezik frontend, a többihez még sajnos csak backend.

### A szoftver az alábbi követelményeknek felel meg:
Tartalmaz GET, POST, DELETE végpontokat.

Tud JDBC adatbázisból fájlokat (bármilyen kiterjesztésű is legyen az) letölteni, kitörölni, valamint újat hozzáadni.
A fájl ID-jét, kiterjesztését és nevét a böngészőjében is meg tudja nézni.

Tartalmaz Interface-t. 

Rétegszemléletre épül: Model-View-Controller szemlélet, Service és Aspect rétegekkel kiegészítve.

Az aspektusorientált programozás paradigmáját használva minden HTML és JSON oldal megtekintését konzolon logolja a szoftver. Viszont ezt csak akkor teszi meg, ha ráfrissít az adott oldalra. Magyarán a böngészőből való első megtekintéseket logolja, függetlenül attól, hogy melyik aloldalra érkezett a megtekintés.

### Az alábbi elérési utak segítéségével a Postman alkalmazásban tesztelni is tudja a kódot:

Grafikus megjelenéssel (HTML) bíró aloldalak:
```
http://localhost:8080                 ( GET )     -> A főoldal, melyen találhat rövid tutorialt az alkalmazáshoz.
http://localhost:8080/upload          ( GET )     -> Fájlokat tud feltölteni az adatbázisba.
```
Nyers megjelenésű (JSON) aloldalak:
```
http://localhost:8080/storages        ( GET )     -> Lekérdezi az adatbázisban található összes adatot.
http://localhost:8080/storages/{id}   ( GET )     -> Lekérdezi az adatbázisban található adott ID-hez rendelt adatot.
http://localhost:8080/delete/{id}     ( DELETE )  -> Törli a megadott ID-hez rendelt adatot az adatbázisból.
http://localhost:8080/donwload/{id}   ( POST )    -> Letölti a számítógépére a megadott ID-hez rendelt adatokat.
```
