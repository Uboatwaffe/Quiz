package org.db.interfaces;

import org.db.manage.Adding;

public sealed interface Add permits org.db.tables.Add, Adding {
    static void add(String question, String answer, String type) {

    }
    static void add(String message){

    }
}
