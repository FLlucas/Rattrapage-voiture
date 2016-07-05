package contract;

/**
 * L'nterface IAI
 */
public interface IAI extends IEntity {
    AIType getAiType();
    /**
     * Setter pour l'AI
     * @param aiType
     * Assigner un type d'AI
     */
    void setAiType(AIType aiType);
}
