package strings;

import heranca.mais.polimorfismo.exercicio1.Filme.Tipo;

public class FormatadorNumeroTelefone {

    public enum TipoTelefone {
        FIXO(8, "Telefone: "),
        CELULAR(9, "Celular: ");

        private int digitosSemDDD;

        private String label;

        TipoTelefone(int digitosSemDDD, String label) {
            this.digitosSemDDD = digitosSemDDD;
            this.label = label;
        }

        public int getDigitosSemDDD() {
            return this.digitosSemDDD;
        }

        public String formatar(String numero) {
            return this.label + (numero.length() > getDigitosSemDDD() ? "(" + numero.substring(numero.length()-getDigitosSemDDD()-2,numero.length()-getDigitosSemDDD()) + ") ": "" )
                + numero.substring(numero.length()-getDigitosSemDDD(),numero.length()-4) 
                + "-" + numero.substring(numero.length()-4, numero.length());
        }
    }

    public TipoTelefone getTipo(String numero) throws Exception {
        int digitos = numero.length();
        if (digitos == TipoTelefone.FIXO.getDigitosSemDDD() || digitos == TipoTelefone.FIXO.getDigitosSemDDD()+2) return TipoTelefone.FIXO;
        else if (digitos == TipoTelefone.CELULAR.getDigitosSemDDD() || digitos == TipoTelefone.CELULAR.getDigitosSemDDD()+2) return TipoTelefone.CELULAR;
        else throw new Exception("Número inválido!");
    }

    public String formatar(String numero) throws Exception {
        numero = numero.trim().replaceAll("[^0-9]", "");
        return getTipo(numero).formatar(numero);
    }

}
