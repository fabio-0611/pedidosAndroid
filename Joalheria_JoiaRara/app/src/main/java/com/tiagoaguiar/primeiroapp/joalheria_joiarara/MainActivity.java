package com.tiagoaguiar.primeiroapp.joalheria_joiarara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantidade=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void somar(View view){
        quantidade= quantidade +1;
        displayQuantidade(quantidade);
    }
    public void subtrair(View view){
        quantidade= quantidade - 1;
        displayQuantidade(quantidade);
    }

    public void displayQuantidade(int qtdvinho) {
        TextView qtdTextView=(TextView) findViewById(R.id.quantidade_tv);
        qtdTextView.setText("" +qtdvinho);
    }

    public void enviarPedido(View view){
        EditText campoNome =(EditText) findViewById(R.id.campo_nome);
        String nome = campoNome.getText().toString();

        EditText campoEndereco = (EditText) findViewById(R.id.campo_endereco);
        String endereço = campoEndereco.getText().toString();

        EditText campoTelefone = (EditText) findViewById(R.id.campo_telefone);
        String telefone = campoTelefone.getText().toString();


        CheckBox checkSeco = (CheckBox) findViewById(R.id.seco);
        boolean temseco= checkSeco.isChecked();



        CheckBox checkTinto = (CheckBox) findViewById(R.id.tinto);
        boolean temtinto= checkTinto.isChecked();



        CheckBox checkBranco = (CheckBox) findViewById(R.id.branco);
        boolean tembranco= checkBranco.isChecked();


        CheckBox checkSuco = (CheckBox) findViewById(R.id.suco);
        boolean temsuco= checkSuco.isChecked();


        int valor = calcularPreco(temseco,temtinto,tembranco,temsuco);

        String mensagem = "Nome        " + nome;
        mensagem = "\nEndereço:        " + endereço;
        mensagem = "\nETelefone:       " + telefone;
        mensagem += "\nAnel Chevron:   " + temseco;
        mensagem += "\nColar São Bento: " + temtinto;
        mensagem += "\nColar Graduado: " + tembranco;
        mensagem += "\nAnel Samos:     " + temsuco;
        mensagem += "\nQuantidade:     " + quantidade;
        mensagem += "\nTotal: R$       " + valor;
        TextView pedidoTextView = (TextView) findViewById(R.id.resumo_pedido);
        pedidoTextView.setText(mensagem);
        //abrir o email
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "\n Pedido de " +nome  +endereço);
        intent.putExtra(Intent.EXTRA_TEXT,mensagem);
        if(intent.resolveActivity(getPackageManager())!=null)
            startActivity(intent);

    }
    public int calcularPreco( boolean temseco, boolean temtinto, boolean tembranco, boolean temSuco) {
        int vinho = 5100;
        int suco = 810;
        int colar= 759;
        int anel = 5100;

        return vinho*quantidade;

    }
}




