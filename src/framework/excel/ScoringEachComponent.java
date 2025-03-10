package framework.excel;

public class ScoringEachComponent {
    @ExcelProperties(name = "Diem thanh phan")
    private String typeOfScore;
    @ExcelProperties(name = "Diem")
    private double value;

    public ScoringEachComponent(String typeOfScore, double value) {
        this.typeOfScore = typeOfScore;
        this.value = value;
    }

    public String getTypeOfScore() {
        return typeOfScore;
    }

    public void setTypeOfScore(String typeOfScore) {
        this.typeOfScore = typeOfScore;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
