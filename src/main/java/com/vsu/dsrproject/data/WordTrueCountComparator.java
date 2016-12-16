package com.vsu.dsrproject.data;

import com.vsu.dsrproject.entity.Word;

import java.util.Comparator;

/**
 * Created by Pavel on 16.12.2016.
 */
public class WordTrueCountComparator implements Comparator<Word>{
    public int compare(Word a, Word b){
        return a.getTrueCount().compareTo(b.getTrueCount());
    }
}
