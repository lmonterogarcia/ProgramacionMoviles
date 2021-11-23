package com.luismontero.gestinmobiliaria;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Inmobiliaria {

    public static List<Casa> lstCasas = new ArrayList<Casa>();
    public static int CasaSeleccionada;
    public static boolean booInsertar = true;
    public static int ultimoId;
}


