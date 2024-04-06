import java.util.ArrayList;
import java.util.List;

class Player {
    private Room currentRoom;
    private List<String> inventory;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("Non puoi andare in quella direzione.");
            return false;
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getDescription());
            return true;
        }
    }

    public void pickItem(String item) {
        if (currentRoom.removeItem(item)) {
            inventory.add(item);
            System.out.println("Hai raccolto: " + item);
        } else {
            System.out.println("L'oggetto non è presente in questa stanza.");
        }
    }

    public void dropItem(String item) {
        if (inventory.remove(item)) {
            currentRoom.addItem(item);
            System.out.println("Hai depositato: " + item);
        } else {
            System.out.println("Non possiedi questo oggetto.");
        }
    }

    public void displayInventory() {
        System.out.println("Inventario: " + inventory);
    }
}
