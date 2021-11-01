package com.alvindev.aplikasibelajaruts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
TextView unsur;
Button jawab;
EditText jawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Objects.requireNonNull(getSupportActionBar()).hide();
        unsur = findViewById(R.id.UnsurKimia);
        jawab = findViewById(R.id.btnJawab);
        jawaban = findViewById(R.id.jawaban);
        String[][] unsuratom = {
                {"Hidrogen", "H"},
                {"Helium", "He"},
                {"Litium", "Li"},
                {"Berilium", "Be"}, {"Boron", "B"}, {"Karbon", "C"}, {"Nitrogen", "N"}, {"Oksigen", "O"}, {"Fluor", "F"}, {"Neon", "Ne"}, {"Natrium", "Na"}, {"Magnesium", "Mg"}, {"Aluminium", "Al"}, {"Silikon", "Sl"}, {"Fosfor", "P"}, {"Belerang", "S"}, {"Klorin", "Cl"}, {"Argon", "Ar"}, {"Kalium", "K"}, {"Calsium", "C"}, {"Skandium", "Sc"}, {"Titanium", "Ti"}, {"Vanadium", "V"}, {"Kromium", "Cr"}, {"Mangan", "Mn"}, {"Besi", "Fe"}, {"Kobalt", "Co"}, {"Nikel", "Ni"}, {"Tembaga", "Cu"}, {"Seng", "Zn"}, {"Galium", "Ga"}, {"Germanium", "Ge"}, {"Arsen", "As"}, {"Selenium", "Se"}, {"Bromin", "Br"}, {"Kripton", "Kr"}, {"Rubidium", "Rb"}, {"Stronsium", ""}, {"Itrium", "Y"}, {"Zirkonium", "Zr"}, {"Niobium", "Nb"}, {"Molibdenum", "Mo"}, {"Teknesium", "Tc"}, {"Ruthenium", "Ru"}, {"Rodium", "Rh"}, {"Paladium", "Pd"}, {"Perak", "Ag"}, {"Kadmium", "Cd"}, {"Indium", "In"}, {"Timah", "Sn"}, {"Antimon", "Sb"}, {"Telurium", "Te"}, {"Iodin", "I"}, { "Xenon", "Xe"}, { "Sesium", "Cs"}, { "Barium", "Ba"}, { "Lantanum", "La"}, { "Serium", "Ce"}, { "Praseodimium", "Pr"}, { "Neodimium", "Nd"}, { "Prometium", "Pm"}, { "Samarium", "Sm"}, { "Europium", "Eu"}, { "Gadolinium", "Gd"}, { "Terbium", "Tb"}, { "Disprosium", "Dy"}, { "Holmium", "Ho"}, { "Erbium", "Er"}, { "Tulium", "Tm"}, { "Iterbium", "Yb"}, {"Lutesium", "Lu"}, { "Hafnium", "Hf"}, { "Tantalum", "Ta"}, { "Wolfram", "W"}, { "Renium", "Re"}, { "Osmium", "Os"}, { "Iridium", "Ir"}, { "Platina", "Pt"}, { "Emas", "Au"}, { "Raksa", "Hg"}, { "Talium", "Tl"}, { "Timbal", "Pb"}, { "Bismut", "Bi"}, { "Polonium", "Po"}, { "Astatin", "At"}, { "Radon", "Rn"}, { "Fransium", "Fr"}, { "Radium", "Ra"}, { "Aktinium", "Ac"}, { "Torium", "Th"}, { "Protaktinium", "Pa"}, { "Uranium", "U"}, { "Neptunium", "Np"}, { "Plutonium", "Pu"}, { "Amerisium", "Am"}, { "Curium", "Cm"}, { "Curium", "Bk"}, { "Kalifornium", "Cf"}, {"Einsteinium", "Es"}, {"Fermium", "Fm"}, { "Mendelevium", "Md"}, { "Nobelium", "No"}, { "Lawrensium", "Lr"}, { "Rutherfordium", "Rf"}, { "Dubnium", "Db"}, { "Seaborgium", "Sg"}, { "Bohrium", "Bh"}, { "Hassium", "Hs"}, { "Meitnerium", "Mt"}, { "Darmstadtium", "Ds"}, { "Roentgenium", "Rg"}, { "Kopernisium", "Cn"}, { "Nihonium", "Nh"}, { "Flerovium", "Fl"}, { "Moskovium", "Mc"}, { "Livermorium", "Lv"}, { "Tenesin", "Ts"}, { "Iterbium", "Og"}
        };

        Random rand = new Random();
        int nomorAtom = rand.nextInt(102);
        String nama = unsuratom[nomorAtom][0];
        String lambang = unsuratom[nomorAtom][1];
        unsur.setText(lambang);
        jawab.setOnClickListener(view -> {
            String jawabnya = jawaban.getText().toString();
            if (jawabnya.equalsIgnoreCase(nama)){
                Intent intentBenar = new Intent(GameActivity.this, BenarActivity.class);
                startActivity(intentBenar);
            }else{
                Intent intentSalah = new Intent(GameActivity.this, SalahActivity.class);
                intentSalah.putExtra("jawab", nama);
                startActivity(intentSalah);
            }
        });
        super.finish();
    }
}