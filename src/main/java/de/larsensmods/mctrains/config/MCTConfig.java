package de.larsensmods.mctrains.config;

public record MCTConfig(
        boolean enableCartChaining
) {
    public MCTConfig() {
        this(true);
    }
}