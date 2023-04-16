package model;

public class Relogio {
    private int tempoMaximo;
    private int tempoRestante;
    private boolean emAndamento;
    private boolean pausado;

    public Relogio(int tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
        this.tempoRestante = tempoMaximo;
        this.emAndamento = false;
        this.pausado = false;
    }

    public void iniciar() {
        if (!this.emAndamento || this.pausado || this.tempoRestante == tempoMaximo) {
            this.emAndamento = true;
            this.pausado = false;
            Thread thread = new Thread(() -> {
                while (this.tempoRestante > 0 && this.emAndamento) {
                    if (!this.pausado) {
                        try {
                            Thread.sleep(1000);
                            this.tempoRestante--;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
        }
    }

    public void pausar() {
        this.pausado = true;
    }

    public void reiniciar() {
        this.tempoRestante = tempoMaximo;
        this.pausado = false;
    }

    public int getTempoMaximo() {
        return tempoMaximo;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public boolean isEmAndamento() {
        return emAndamento;
    }

    public boolean isPausado() {
        return pausado;
    }
}

