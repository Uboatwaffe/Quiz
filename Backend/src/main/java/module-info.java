module Backend {
    requires java.sql;
    requires Exceptions;
    exports org.db.connecting;
    exports org.db.manage;
    exports org.db.tables;
    exports org.db.reset;
    exports org.file.writing;
    exports org.db.interfaces;
}