import br.com.benezinhobank.model.Agencia;
import br.com.benezinhobank.model.Banco;
import br.com.benezinhobank.model.ContaCorrente;
import br.com.benezinhobank.model.ContaPoupanca;
import br.com.benezinhobank.pessoa.model.PessoaFisica;
import br.com.benezinhobank.pessoa.model.PessoaJuridica;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Banco benezinho = new Banco("Benezinho Bank");

        Agencia osasco = new Agencia();
        osasco.setBanco(benezinho);
        osasco.setNome("Osasco");
        osasco.setNumero("1-9");

        PessoaFisica mae = new PessoaFisica();
        mae.setNome("Lucineide Matos");
        mae.setNascimento(LocalDate.of(1962,5,11));
        mae.setCPF("2525254152632541");

        PessoaFisica angel = new PessoaFisica();
        angel.setCPF("12345678912351");
        angel.setNascimento(LocalDate.of(1993,3,14));
        angel.setNome("Angelica Melo");
        angel.setMae(mae);

        ContaCorrente cc = new ContaCorrente();
        cc.setAgencia(osasco);
        cc.setTitular(angel);
        cc.setSaldo(1_000_000.99);
        cc.setLimite(5_000_000);
        cc.setNumero("1-9");

        ContaPoupanca cp = new ContaPoupanca();
        cp.setNumero("2-8");
        cp.setAniversario(4);
        cp.setAgencia(osasco);
        cp.setSaldo(500_000);
        cp.setTitular(mae);

        PessoaJuridica holding = new PessoaJuridica();
        holding.setCNPJ("1231312/0001-09");
        holding.setNascimento(LocalDate.of(1988, 10, 5));
        holding.setNome("Angel Holding");
        holding.setRazaoSocial("Angel Holding SA");

        ContaCorrente ccH = new ContaCorrente();
        ccH.setNumero("3-7");
        ccH.setLimite(800_000_000);
        ccH.setSaldo(1_000_000_000);
        ccH.setTitular(holding);
        ccH.setAgencia(osasco);

        System.out.println(ccH);


    }
}