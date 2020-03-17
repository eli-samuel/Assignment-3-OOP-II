public class FileInvalidException extends Exception {

    private String errorMessage;

    /**
    * Default empty FileInvalidException constructor
    */
    public FileInvalidException() {
        super();
    }

    /**
	* Default FileInvalidException constructor
	*/
    public FileInvalidException(String errorMessage) {
        this();
        this.errorMessage = errorMessage;
    }

	/**
	* Create string representation of FileInvalidException for printing
	* @return
	*/
	public String getMessage() {
        if(errorMessage.length() > 0) return errorMessage;
		return "Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)";
	}

}
