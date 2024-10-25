package fi.utu.tech.ooj.exercise4;

import fi.utu.tech.ooj.exercise4.gameLogic.Game;
import fi.utu.tech.ooj.exercise4.storage.DataSource;
import fi.utu.tech.ooj.exercise4.storage.DataSourceFactory;
import fi.utu.tech.ooj.exercise4.storage.DataSourceTypes;
import fi.utu.tech.ooj.exercise4.ui.SelectionException;
import fi.utu.tech.ooj.exercise4.ui.UITypes;
import fi.utu.tech.ooj.exercise4.ui.UiInterface;

public class Main {

    public Main(String guiTypeArgument) {
        UiInterface ui = initializeUI(guiTypeArgument);
        DataSource dataSource = initializeDataSource(ui);
        Game game = new Game(ui, dataSource);
        game.initialize();
        game.startGame(5);
    }

    private UiInterface initializeUI(String guiTypeArgument) {
        UiInterface ui = UiInterface.getUIInstance(UITypes.TERMINAL);

        switch (guiTypeArgument){
            case "gui":
                ui = UiInterface.getUIInstance(UITypes.GUI);
                break;
            case "terminal":
                ui = UiInterface.getUIInstance(UITypes.TERMINAL);
                break;
            default:
                ui = UiInterface.getUIInstance(UITypes.TERMINAL);
                break;
        }
        return ui;
    }

    private DataSource initializeDataSource(UiInterface ui) {
        String[] dataOptions = {"CSV-file", "SQLite database"};
        ui.printText("First, select the data source from which the questions and answers will be read");
        int selected = 0;
        try {
            selected = ui.selectQuestion(dataOptions);
        } catch (SelectionException e) {
            ui.printText("Selection of data source type failed");
            throw new RuntimeException(e);
        }
        switch (selected) {
            case 1:
                return DataSourceFactory.getDataSource(DataSourceTypes.CSV);
            case 2:
                return DataSourceFactory.getDataSource(DataSourceTypes.SQLITE);
            default:
        }       return DataSourceFactory.getDataSource(DataSourceTypes.CSV);
    }


    public static void main(String[] args) {
        System.out.println("DTEK0066 2024 syksy, Tehtäväkerta 4 ");

        /*
            Tällä kierroksella tähän tehtäväpohjaan ei tehdä muutoksia.
            Tehtäväpohjaan on tehty peli, jota analysoidaan. Vastaukset kirjoitetaan Villeen.

            Pelissä käyttäjä valitsee haluamansa vaihtoehdon esitetyistä kysymyksistä ja peli vastaa jotain
            satunnaista. Idea on siis sama kuin Cards agains humanity -pelissä.

            Ohjelman käynnistyessä valitaan ensin, mistä kysymykset ladataan. Jotta tietokanta vaihtoehto toimii oikein,
            on peli käynnistettävä Mavenin avulla. CSV-vaihtoehdon pitäisi toimia aina.

         */

        System.out.println("Tehtäväpohja käynnistyy");

        String guiTypeArgument = "terminal";
        if (args.length >0) {
            guiTypeArgument = args[0].toLowerCase();
        }
        new Main(guiTypeArgument);

        System.out.println("Tehtävien suoritus on päättynyt");

    }
}
