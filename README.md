# DTEK0066 exercise 4 template

## Tehtävänanto

#### Tämä harjoituspohja liittyy Villen viikkoon 5.

Tehtävät löytyvät Villestä. Kaikkiin viikon 5 tehtäviin vastaaan suoraan Ville. 

Tehtävänpohja sisältää tällä kerralla ohjelman, pelin, jota analysoidaan. Forkkaa kuiten itsellesi tämä projekti pohjaksi, 
jotta voit halutessasi tallettaa tekemäsi kokeilut myös omaan Gitlabbiisi. Gitlab-osoitetta ei kuitenkaan tällä kerralla 
kysytä.

Main.java luokka sisältää ohjelman käynnistävän main-rutiinin. 

Pelissä käyttäjä valitsee haluamansa vaihtoehdon esitetyistä kysymyksistä ja peli vastaa jotain
satunnaista. Idea on siis sama kuin Cards agains humanity -pelissä.

Ohjelman käynnistyessä valitaan ensin, mistä kysymykset ladataan. Jotta tietokanta vaihtoehto toimii oikein,
on peli käynnistettävä Mavenin avulla (joko komentorivillä mvn exec:java tai IDEssa Maven-tyyppinen ajokonfiguraatio). 
CSV-vaihtoehdon pitäisi toimia aina.


## Tehtäviin vastaaminen

- Tehtävä 6: Tutustu tästä harjoituspohjasta löytyvää peliin. Vastaa Villestä löytyviin esseekysymyksiin.





## Työnkulku

1. [Forkkaa tämä projekti](https://tech.utugit.fi/soft/tools/lectures/dtek2074/2023-fi/git/gitlab/#gitlab-projektin-forkkaus)
2. [Kloonaa oma kopiosi projektista](https://tech.utugit.fi/soft/tools/lectures/dtek2074/2023-fi/git/gitlab/#gitlab-projektin-haku-paikalliseksi)
3. Tee tehtäviä
4. [Tallenna muutokset gitiin](https://tech.utugit.fi/soft/tools/lectures/dtek2074/2023-fi/git/usage/#ty%C3%B6kopion-ja-indeksin-k%C3%A4sittely)
5. [Lähetä muutokset takaisin GitLabiin](https://tech.utugit.fi/soft/tools/lectures/dtek2074/2023-fi/git/gitlab/#paikallisen-muutoksen-l%C3%A4hett%C3%A4minen-gitlabiin)

Tarvittaessa toista vaiheet 3 -- 5.

## Mavenin käskyjä

Jos käytät jotain integroitua kehitysympäristöä (IntelliJ Idea, Eclipse, VS Code), et todennäköisesti tarvitse alla olevia komentoja. 

[Lue tarvittaessa ohjeet](https://tech.utugit.fi/soft/tools/lectures/dtek2074/2023-fi/build/basic/).

```bash
$ mvn clean
$ mvn compile
$ mvn test
$ mvn exec:java
```
