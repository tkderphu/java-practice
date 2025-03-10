package code_ptit.ban_hang;

public class Item {
    private String id;
    private String name;
    private String unit;
    private int buy;
    private int sell;

    public Item(int id, String name, String unit, int buy, int sell) {
        this.id = String.format("MH%03d", id);
        this.name = name;
        this.unit = unit;
        this.buy = buy;
        this.sell = sell;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getBuy() {
        return buy;
    }

    public String getId() {
        return id;
    }

    public int getSell() {
        return sell;
    }
}
