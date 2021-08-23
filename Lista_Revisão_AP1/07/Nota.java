import java.text.SimpleDateFormat;
import java.util.Date;

public class Nota {
        Date date = new Date(); // Contém a data e hora atuais
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        public String datahora;
        public String descricao;

        public Nota(String descricao) {
                this.descricao = descricao;
                this.datahora = formatter.format(date);
        }

        public void descricaoDetalhada() {
                System.out.println(this.datahora);
                System.out.println(this.descricao);
        }
}