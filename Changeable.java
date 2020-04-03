
/**

 * Interface to implement a Changeable type of action - either undo or redo.

 * @author Greg COpe

 *

 */

public interface Changeable {



	/**

	 * Undoes an action

	 */

	public void undo();

	

	/**

	 * Redoes an action

	 */

	public void redo();

}