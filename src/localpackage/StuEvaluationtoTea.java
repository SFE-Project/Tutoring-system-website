package localpackage;

public class StuEvaluationtoTea {
   private int EvaluatorID;
   private int EvaluatedID;
   private int Star;
   private String EvaluateContent;

    public int getStar() {
        return Star;
    }

    public void setStar(int star) {
        Star = star;
    }

    public String getEvaluateContent() {
        return EvaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        EvaluateContent = evaluateContent;
    }

    public int getEvaluatedID() {
        return EvaluatedID;
    }

    public void setEvaluatedID(int evaluatedID) {
        EvaluatedID = evaluatedID;
    }

    public int getEvaluatorID() {
        return EvaluatorID;
    }

    public void setEvaluatorID(int evaluatorID) {
        EvaluatorID = evaluatorID;
    }
}
