package framework.excel;

import java.util.List;

import static framework.excel.PropertiesType.*;

public class Score {
//    @ExcelProperties(name = "score", type = PropertiesType.LIST, isDefined = ScoringEachComponent.class)
//    private List<ScoringEachComponent> scoringEachComponents;

    @ExcelProperties(name = "subject", isDefined = Subject.class)
    private Subject subject;

    private List<ScoringEachComponent> scoringEachComponents;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<ScoringEachComponent> getScoringEachComponents() {
        return scoringEachComponents;
    }

    public void setScoringEachComponents(List<ScoringEachComponent> scoringEachComponents) {
        this.scoringEachComponents = scoringEachComponents;
    }

}
