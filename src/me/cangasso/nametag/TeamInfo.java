package me.cangasso.nametag;

public class TeamInfo
{
    private String name;
    private String prefix;
    private String suffix;
    
    TeamInfo(final String name) {
        this.name = name;
    }
    
    void SetarPrefix(final String prefix) {
        this.prefix = prefix;
    }
    
    void SetarSuffix(final String suffix) {
        this.suffix = suffix;
    }
    
    String PegarPrefix() {
        return this.prefix;
    }
    
    String PegarSuffix() {
        return this.suffix;
    }
    
    String PegarNome() {
        return this.name;
    }
}
