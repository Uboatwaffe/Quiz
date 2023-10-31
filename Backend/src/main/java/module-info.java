/**
 * Module that takes care of whole connectivity with DB,
 * manages and prepares questions
 * @author Maciej
 */
module Backend {
    requires java.sql;
    requires transitive Exceptions;
    exports org.db.connecting to UI;
    exports org.db.manage to UI;
    exports org.db.tables to UI;
    exports org.db.reset to UI;
    exports org.db.interfaces to UI;
    exports org.score to UI;
    exports org.file to UI;
}