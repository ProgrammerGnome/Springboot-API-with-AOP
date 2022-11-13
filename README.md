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

Az aspektusorientált programozás paradigmáját használva a Controller és View nevű rétegekben történő függvényhívásokat konzolon logolja a szoftver. A View rétegekben két "fakeController" nevű osztály található, mely az AOP szempontjából ugyan controller feladatokat lát el, de a grafikus megjelenítést szolgálja teljes mértében, így került a View rétegbe.

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
### A főoldal, azaz a http://localhost:8080:

![kép](https://user-images.githubusercontent.com/69594158/201531476-75dbd277-9d29-4215-9376-0bd1c1e8f417.png)
