/**
 * Module that allows exceptions handling and
 * makes debugging easier, it contains package:
 * <ul>
 *     <li>
 *         {@code org.exceptions}
 *     </li>
 * </ul>
 * @author Maciej
 */
module Exceptions {
    requires java.desktop;
    exports org.exceptions.file;
    exports org.exceptions.ui;
    exports org.exceptions.exceptions;
}