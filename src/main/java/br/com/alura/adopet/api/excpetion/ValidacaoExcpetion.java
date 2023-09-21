package br.com.alura.adopet.api.excpetion;

public class ValidacaoExcpetion extends RuntimeException {
    public ValidacaoExcpetion(String message) {
        super(message);
    }
}
