module Backend {
    requires java.sql;
    requires Exceptions;
    exports org.db.connecting;
    exports org.db.manage;
    exports org.db.score;
    exports org.db.tables;
    exports org.db.reset;
}