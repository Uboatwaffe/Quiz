package org.db.interfaces;

import org.db.manage.Deleting;

public sealed interface Delete permits org.db.tables.Delete, Deleting {
    static void delete(String index){

    }
}
