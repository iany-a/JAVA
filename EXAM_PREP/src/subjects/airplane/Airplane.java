package subjects.airplane;

import java.io.Serializable;

public class Airplane implements Serializable {
    private ExpenseManager expenseManager;

    private String id;
    private AirplaneType type;

    public Airplane(ExpenseManager expenseManager, String id, AirplaneType type) {
        this.expenseManager = expenseManager;
        this.id = id;
        this.type = type;
    }


    public ExpenseManager getExpenseManager() {
        return expenseManager;
    }

    public void setExpenseManager(ExpenseManager expenseManager) {
        this.expenseManager = expenseManager;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AirplaneType getType() {
        return type;
    }

    public void setType(AirplaneType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "expenseManager=" + expenseManager +
                ", id='" + id + '\'' +
                ", type=" + type +
                '}';
    }
}
