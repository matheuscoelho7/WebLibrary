package com.example.matheussilva.weblibrary.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by matheus.silva on 24/11/2017.
 */

public class BancoSQL extends SQLiteOpenHelper {

    ContentValues cv;

    public BancoSQL(Context context) {
        super(context, "dbWebLibrary", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE USUARIO (" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "NOME TEXT NOT NULL, " +
                        "EMAIL TEXT NOT NULL, " +
                        "LOGIN TEXT NOT NULL, " +
                        "SENHA TEXT NOT NULL)");

        sqLiteDatabase.execSQL(
                "CREATE TABLE SERVICE (" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "DESCRICAO TEXT NOT NULL, " +
                        "PRAZO_ENTREGA INTEGER NOT NULL, " +
                        "PRAZO_BUSCA_POR_AGEND INTEGER NOT NULL, " +
                        "STATUS TEXT NOT NULL," +
                        //"LONGITUDE TEXT NOT NULL, " +
                        //"LATITUDE TEXT NOT NULL, " +
                        "USUARIO_ID INTEGER NOT NULL," +
                        "CATEGORIA_ID INTEGER NOT NULL," +
                        "FOREIGN KEY(USUARIO_ID) REFERENCES USUARIO(ID)," +
                        "FOREIGN KEY(CATEGORIA_ID) REFERENCES CATEGORIA(ID))");

        sqLiteDatabase.execSQL(
                "CREATE TABLE CATEGORIA_LIVRO (" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "CATEGORIA TEXT NOT NULL," +
                        "TITULO TEXT NOT NULL, " +
                        "CAMINHO_IMAGEM TEXT)");

        sqLiteDatabase.execSQL(
                "CREATE TABLE USUARIO_LOGADO ( " +
                        "ID INTEGER PRIMARY KEY," +
                        "TIPO TEXT NOT NULL)");


        //Usuário Administrador
        cv = new ContentValues();
        cv.put("LOGIN", "admin");
        cv.put("NOME", "MATHEUS");
        cv.put("SENHA", "123");
        cv.put("EMAIL", "matheusguilherme.coelho02@gmail.com");
        cv.put("CELULAR", "81984813918");
        sqLiteDatabase.insert("USUARIO", null, cv);

        //Categorias de Livros
        cv = new ContentValues();
        cv.put("CATEGORIA", "Ação");
        sqLiteDatabase.insert("CATEGORIA_LIVRO", null, cv);

        cv = new ContentValues();
        cv.put("CATEGORIA", "Anime");
        sqLiteDatabase.insert("CATEGORIA_LIVRO", null, cv);

        cv = new ContentValues();
        cv.put("CATEGORIA", "Comédia");
        sqLiteDatabase.insert("CATEGORIA_LIVRO", null, cv);

        cv = new ContentValues();
        cv.put("CATEGORIA", "Drama");
        sqLiteDatabase.insert("CATEGORIA_LIVRO", null, cv);

        cv = new ContentValues();
        cv.put("CATEGORIA", "Ficção Científica");
        sqLiteDatabase.insert("CATEGORIA_LIVRO", null, cv);

        cv = new ContentValues();
        cv.put("CATEGORIA", "Romance");
        sqLiteDatabase.insert("CATEGORIA_LIVRO", null, cv);

        cv = new ContentValues();
        cv.put("CATEGORIA", "Suspense");
        sqLiteDatabase.insert("CATEGORIA_LIVRO", null, cv);

        cv = new ContentValues();
        cv.put("CATEGORIA", "Terror");
        sqLiteDatabase.insert("CATEGORIA_LIVRO", null, cv);

        cv = new ContentValues();
        cv.put("CATEGORIA", "Internacionais");
        sqLiteDatabase.insert("CATEGORIA_LIVRO", null, cv);

        //INSERT USUÁRIO SERVICO
        cv = new ContentValues();
        cv.put("DESCRICAO", "ALUGUEL DE LIVRO");
        cv.put("PRAZO", "1 MÊS");
        //cv.put("LONGITUDE", "60");
        //cv.put("LATITUDE", "30");
        cv.put("USUARIO_ID", "1");
        cv.put("CATEGORIA_ID", "1");
        sqLiteDatabase.insert("SERVICE", null, cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                //upgrade logic from version 1 to 2;
            case 2:
                //upgrade logic from version 2 to 3;
            case 3:
                //upgrade logic from version 3 to 4;
            case 4:
                //upgrade logic from version 4 to 5
            case 5:
                //upgrade logic from version 5 to 6
            case 6:
                //upgrade logic from version 6 to 7
                break;
            default:
                throw new IllegalStateException(
                        "onUpgrade() with unknown oldVersion " + oldVersion);
        }
    }
}

