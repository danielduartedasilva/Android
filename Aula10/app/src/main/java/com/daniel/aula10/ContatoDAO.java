package com.daniel.aula10;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ContatoDAO {
    private DBHelper helper; // dados da tabela que vamos acessar (Contatos)
    private DBGateway gateway; // conexão ativa com o banco de dados

    public ContatoDAO(Context context){
        gateway = DBGateway.getInstance(context); // recebe uma instância ativa da conexão com o banco de dados
    }
    // salvar contato na tabela
    public boolean salvarContatoDB(Contato c){
        ContentValues values = new ContentValues(); // ContentValues é um tipo de objeto próprio para guardar os dados dentro de uma tabela no SQLite
        long result; // retorno do método insert

        // armazenar em values os valores que pretendemos inserir na tabela contatos
        values.put(helper.NOME, c.getNome());
        values.put(helper.FONE, c.getFone());

        // executar insert
        result = gateway.getDatabase().insert(helper.TABLE, null, values);
        if (result > 0){
            return true; // inserido com sucesso
        }
        return false; // não deu certo
    }
    public void getContatosDB(){
        String sql = "SELECT * FROM " + helper.TABLE;
        Cursor cursor = gateway.getDatabase().rawQuery(sql, null); // Cursor serve para armazenar todos os dados de uma tabela
        try {
            // se houverem dados na tabela, mover para o primeiro registro retornado
            cursor.moveToFirst();

            // criar um laço while para percorrer todas as posições deste cursor
            while (cursor != null){
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(helper.ID));
                @SuppressLint("Range") String nome = cursor.getString(cursor.getColumnIndex(helper.NOME));
                @SuppressLint("Range") String fone = cursor.getString(cursor.getColumnIndex(helper.FONE));
                Contato c = new Contato(id, nome, fone);
                // adicionar na lista local este contato
                ContatoLista.addContato(c);
                cursor.moveToNext(); // mover para o próximo registro retornado pelo select
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
