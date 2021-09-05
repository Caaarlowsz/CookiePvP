package me.cangasso.rdmautomatica;

public enum Estado
{
    INICIANDO("INICIANDO", 0), 
    ANDAMENTO("ANDAMENTO", 1), 
    FECHADO("FECHADO", 2);
    
    private Estado(final String s, final int n) {
    }
}
