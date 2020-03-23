public class Article {
    private String[] author;
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
	public Article() {}

	/**
	* Default Article constructor
	*/
	public Article(String author, String journal, String title, String year, String volume, String number, String pages, String keywords, String doi, String ISSN, String month) {
		this.author = author.split(" ");
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
	* Sets new value of author
	* @param
	*/
	public void setAuthor(String author) {
        this.author = getRidOfExtraStuff(author).split(" and ");
	}

	/**
	* Sets new value of journal
	* @param
	*/
	public void setJournal(String journal) {
		this.journal = getRidOfExtraStuff(journal);
	}

	/**
	* Sets new value of title
	* @param
	*/
	public void setTitle(String title) {
		this.title = getRidOfExtraStuff(title);
	}

	/**
	* Sets new value of year
	* @param
	*/
	public void setYear(String year) {
		this.year = getRidOfExtraStuff(year);
	}

	/**
	* Sets new value of volume
	* @param
	*/
	public void setVolume(String volume) {
		this.volume = getRidOfExtraStuff(volume);
	}

	/**
	* Sets new value of number
	* @param
	*/
	public void setNumber(String number) {
		this.number = getRidOfExtraStuff(number);
	}

	/**
	* Sets new value of pages
	* @param
	*/
	public void setPages(String pages) {
		this.pages = getRidOfExtraStuff(pages);
	}

	/**
	* Sets new value of keywords
	* @param
	*/
	public void setKeywords(String keywords) {
		this.keywords = getRidOfExtraStuff(keywords);
	}

    /**
    * Sets new value of doi
    * @param
    */
    public void setDoi(String doi) {
        this.doi = getRidOfExtraStuff(doi);
    }

	/**
	* Sets new value of ISSN
	* @param
	*/
	public void setISSN(String ISSN) {
		this.ISSN = getRidOfExtraStuff(ISSN);
	}

	/**
	* Sets new value of month
	* @param
	*/
	public void setMonth(String month) {
		this.month = getRidOfExtraStuff(month + " ");
	}

    /**
    *
    *
    */
    // All strings will start with a '{' and end with a '}, '
    public String getRidOfExtraStuff(String word) {
        return word.substring(1, word.length()-3);
    }

    /**
    *
    *
    */
    public String IEEE() {
        String newAuthor = "";
        for (int i=0; i<author.length-1; i++) newAuthor += author[i] + ", ";
        newAuthor += author[author.length-1];

        return (newAuthor + ". \"" + title + "\", " + journal + ", vol. " + volume + ", no. " + number + ", p. " + pages + ", " + month + " " + year + ".");
    }

    /**
    *
    *
    */
    public String ACM() {
        String newAuthor = author[0];
        if (author.length > 1) newAuthor += " et al.";

        return (newAuthor + " " + year + ". " + title + ". " + journal + ". " + volume + ", " + number + " (" + year + "), " + pages + ". DOI:https://doi.org/" + doi + ".");
    }

    /**
    *
    *
    */
    public String NJ() {
        String newAuthor = "";
        for (int i=0; i<author.length-1; i++) newAuthor += author[i] + " & ";
        newAuthor += author[author.length-1];

        return (newAuthor + ". " + title + ". " + journal + ". " + volume + ", " + pages + "(" + year + ").");
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
