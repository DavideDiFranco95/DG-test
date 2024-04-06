public class TextAdventureGame {
    public static void main(String[] args) {
        // Crea stanze
        Room marketSquare = new Room("Market Square", "Sei nella piazza del mercato.");
        Room townHall = new Room("Town Hall", "Sei nell'atrio del municipio.");
        Room tavern = new Room("Tavern", "Sei nella taverna, c'è un'atmosfera vivace.");

        // Collega delle stanze
        marketSquare.setExit("N", townHall);
        marketSquare.setExit("E", tavern);
        townHall.setExit("S", marketSquare);
        tavern.setExit("W", marketSquare);

        // Aggiunta degli oggetti nelle stanze
        marketSquare.addItem("Spada");
        marketSquare.addItem("Pozione");
        tavern.addItem("Boccale");

        // Creazione del giocatore
        Player player = new Player(marketSquare);

        // Inizio del gioco
        System.out.println(player.getCurrentRoom().getDescription());

        // Simulazione di interazioni
        player.move("N"); // Va a Town Hall
        player.pickItem("Pozione"); // Raccoglie la pozione
        player.move("S"); // Torna a Market Square
        player.move("E"); // Va alla Taverna
        player.pickItem("Boccale"); // Raccoglie il boccale
        player.move("W"); // Torna a Market Square

        // Visualizza l'inventario
        player.displayInventory();
    }
}
