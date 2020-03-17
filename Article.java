public class Article {
    private String author;
    private String journal;
    private String title;
    private String year;
    private String volume;
    private String number;
    private String pages;
    private String keywords;
    private String doi;
    private String ISSN;
    private String month;


	/**
	* Default empty Article constructor
	*/
	public Article() {
        //
	}

	/**
	* Default Article constructor
	*/
	public Article(String author, String journal, String title, String year, String volume, String number, String pages, String keywords, String doi, String ISSN, String month) {
		this.author = author;
		this.journal = journal;
		this.title = title;
		this.year = year;
		this.volume = volume;
		this.number = number;
		this.pages = pages;
		this.keywords = keywords;
        this.doi = doi;
		this.ISSN = ISSN;
		this.month = month;
	}

	/**
	* Returns value of author
	* @return
	*/
	public String getAuthor() {
		return author;
	}

	/**
	* Sets new value of author
	* @param
	*/
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	* Returns value of journal
	* @return
	*/
	public String getJournal() {
		return journal;
	}

	/**
	* Sets new value of journal
	* @param
	*/
	public void setJournal(String journal) {
		this.journal = journal;
	}

	/**
	* Returns value of title
	* @return
	*/
	public String getTitle() {
		return title;
	}

	/**
	* Sets new value of title
	* @param
	*/
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	* Returns value of year
	* @return
	*/
	public String getYear() {
		return year;
	}

	/**
	* Sets new value of year
	* @param
	*/
	public void setYear(String year) {
		this.year = year;
	}

	/**
	* Returns value of volume
	* @return
	*/
	public String getVolume() {
		return volume;
	}

	/**
	* Sets new value of volume
	* @param
	*/
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	* Returns value of number
	* @return
	*/
	public String getNumber() {
		return number;
	}

	/**
	* Sets new value of number
	* @param
	*/
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	* Returns value of pages
	* @return
	*/
	public String getPages() {
		return pages;
	}

	/**
	* Sets new value of pages
	* @param
	*/
	public void setPages(String pages) {
		this.pages = pages;
	}

	/**
	* Returns value of keywords
	* @return
	*/
	public String getKeywords() {
		return keywords;
	}

	/**
	* Sets new value of keywords
	* @param
	*/
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

    /**
    * Returns value of doi
    * @return
    */
    public String getDoi() {
        return doi;
    }

    /**
    * Sets new value of doi
    * @param
    */
    public void setDoi(String doi) {
        this.doi = doi;
    }

	/**
	* Returns value of ISSN
	* @return
	*/
	public String getISSN() {
		return ISSN;
	}

	/**
	* Sets new value of ISSN
	* @param
	*/
	public void setISSN(String ISSN) {
		this.ISSN = ISSN;
	}

	/**
	* Returns value of month
	* @return
	*/
	public String getMonth() {
		return month;
	}

	/**
	* Sets new value of month
	* @param
	*/
	public void setMonth(String month) {
		this.month = month;
	}

    public String IEEE() {
        return "";
    }

    public String ACM() {
        return "";
    }

    public String NJ() {
        return "";
    }

	/**
	* Create string representation of Article for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Article [author=" + author + ", journal=" + journal + ", title=" + title + ", year=" + year + ", volume=" + volume + ", number=" + number + ", pages=" + pages + ", keywords=" + keywords + ", ISSN=" + ISSN + ", month=" + month + "]";
	}
}
