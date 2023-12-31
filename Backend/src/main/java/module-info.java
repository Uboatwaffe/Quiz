/**
 * Module that takes care of whole connectivity with DB,
 * manages and prepares questions. In resources, it has {@code log.txt} which
 * stores what is happening with program
 * @author Maciej
 */
module Backend {
    requires java.sql;
    requires transitive Exceptions;
    exports org.uiProperties to UI;
    exports org.db.connecting to UI;
    exports org.db.manage to UI;
    exports org.db.tables to UI;
    exports org.db.reset to UI;
    exports org.db.interfaces to UI;
    exports org.score to UI;
    exports org.file to UI;
    exports org.annotation;
}