package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import de.congrace.exp4j.Calculable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{ //para conseguir usar onclick
    private Button numeroZero,numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,numeroSete,numeroOito,numeroNove,subtracao,soma,multiplicacao,divisao,blank,reset,delete,porcentagem,igual,virgula;
    private TextView txtExpressao,txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IniciarComponentes();
        getSupportActionBar().hide();

        //recuperar numero
        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        virgula.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        reset.setOnClickListener(new View.OnClickListener() { // para limpar tudo
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.textViewUltimaExpressaoID);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){
                    byte var0 = 0;// para n crachar ele começa no 0
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double) longResult) {
                        txtResultado.setText(String.valueOf(longResult));
                    } else {
                        txtResultado.setText(String.valueOf(resultado));
                    }
                    txtExpressao.setText(txtResultado.getText()); // Define o resultado como a nova expressão inicial
                } catch (Exception e) {
                    txtResultado.setText("Erro");
                    txtExpressao.setText("");
                    //txtResultado.setText("");
                }
            }
        });

    }

    private void IniciarComponentes(){
        //recurar todos os ID
        numeroZero = findViewById(R.id.buttonZeroID);
        numeroUm = findViewById(R.id.buttonUmID);
        numeroDois = findViewById(R.id.buttonDoisID);
        numeroTres = findViewById(R.id.buttonTresID);
        numeroQuatro = findViewById(R.id.buttonQuatroID);
        numeroCinco = findViewById(R.id.buttonCincoID);
        numeroSeis = findViewById(R.id.buttonSeisID);
        numeroSete = findViewById(R.id.buttonSeteID);
        numeroOito = findViewById(R.id.buttonOitoID);
        numeroNove = findViewById(R.id.buttonNoveID);
        subtracao = findViewById(R.id.buttonSubtracaoID);
        soma = findViewById(R.id.buttonSomaID);
        multiplicacao = findViewById(R.id.buttonMultiplicacaoID);
        divisao = findViewById(R.id.buttonDivisaoID);
        blank = findViewById(R.id.buttonBlanckID);
        reset = findViewById(R.id.buttonResetID);
        delete = findViewById(R.id.buttonDeleteID);
        porcentagem = findViewById(R.id.buttonPorcentoID);
        igual = findViewById(R.id.buttonIgualID);
        virgula = findViewById(R.id.buttonVirgulaID);
        txtExpressao = findViewById(R.id.textViewUltimaExpressaoID);
        txtResultado = findViewById(R.id.textViewResultadoID);
    }
    public void AcrescentarUmaExpressao(String string, boolean limpar_dados) {
        String textoAtual = txtExpressao.getText().toString();

        if (!limpar_dados && !textoAtual.isEmpty()) {
            char ultimoCaractere = textoAtual.charAt(textoAtual.length() - 1);

            // Verifica se o último caractere e o novo são operadores
            if (isOperator(ultimoCaractere) && isOperator(string.charAt(0))) {
                return; // Não faz nada se tentar adicionar outro operador após um operador
            }
        }

        if (limpar_dados || txtResultado.getText().toString().isEmpty()) {
            txtExpressao.setText(textoAtual + string);
        } else {
            txtExpressao.setText(txtResultado.getText() + string);
            txtResultado.setText("");
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonZeroID:
                AcrescentarUmaExpressao("0",true);
                break;
            case R.id.buttonUmID:
                AcrescentarUmaExpressao("1",true);
                break;
            case R.id.buttonDoisID:
                AcrescentarUmaExpressao("2",true);
                break;
            case R.id.buttonTresID:
                AcrescentarUmaExpressao("3",true);
                break;
            case R.id.buttonQuatroID:
                AcrescentarUmaExpressao("4",true);
                break;
            case R.id.buttonCincoID:
                AcrescentarUmaExpressao("5",true);
                break;
            case R.id.buttonSeisID:
                AcrescentarUmaExpressao("6",true);
                break;
            case R.id.buttonSeteID:
                AcrescentarUmaExpressao("7",true);
                break;
            case R.id.buttonOitoID:
                AcrescentarUmaExpressao("8",true);
                break;
            case R.id.buttonNoveID:
                AcrescentarUmaExpressao("9",true);
                break;
            case R.id.buttonVirgulaID:
                AcrescentarUmaExpressao(".",true);
                break;
            case R.id.buttonSomaID:
                AcrescentarUmaExpressao("+",false);
                break;
            case R.id.buttonSubtracaoID:
                AcrescentarUmaExpressao("-",false);
                break;
            case R.id.buttonMultiplicacaoID:
                AcrescentarUmaExpressao("*",false);
                break;
            case R.id.buttonDivisaoID:
                AcrescentarUmaExpressao("/",false);
                break;
            case R.id.buttonPorcentoID:
                AcrescentarUmaExpressao("%",false);
                break;
        }
    }
}